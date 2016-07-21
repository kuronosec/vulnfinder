// CSS styles to fields
var vulnfinder_st = `.active-input {
  background-color: yellow !important;
}

.active-field {
  background:#f1f1f1;
  color:black
}
.active {
    background-color: #4CAF50;
    color: white;
}`;

// Add CSS styles in head of TOE
function addGlobalStyle(css) {
    var head, style;
    head = document.getElementsByTagName('head')[0];
    if (!head) {
        return;
    }
    style = document.createElement('style');
    style.type = 'text/css';
    style.innerHTML = css;
    head.appendChild(style);
};

var navBarUI;

// Create the navBar ui iframe and inject it in the current page
function initNavBar() {
    var iframe = document.createElement("iframe");
    iframe.setAttribute("id", "nav-bar-iframe")
    iframe.setAttribute("src", chrome.runtime.getURL("resources/nav-bar.html"));
    iframe.setAttribute("style", "position: fixed; top: 0; left: 0; z-index: 10000; overflow-y: auto; height: 100%; width:15%; border:none");
    document.body.appendChild(iframe);
    // $('#nav-bar-iframe').ready(findInput());

    return navBarUI = {
        iframe: iframe, visible: true
    };
}

function toggleNavBar(navBarUI) {
    if (navBarUI.visible) {
        navBarUI.visible = false;
        navBarUI.iframe.style["display"] = "none";
    } else {
        navBarUI.visible = true;
        navBarUI.iframe.style["display"] = "block";
    }
}

// Handle messages from the add-on background page (only in top level iframes)
if (window.parent == window) {
    chrome.runtime.onMessage.addListener(function (msg) {
        if (msg == "toggle-in-page-navBar") {
            if (navBarUI) {
                toggleNavBar(navBarUI);
            } else {
                addGlobalStyle(vulnfinder_st);
                navBarUI = initNavBar();
                setTimeout(findInput, 500);
            }
        }
    });
}

//initializing variables
var attackList = ['SQL Injection', 'Fuzzer', 'XSS', 'Auth and session', 'Auth', 'General Injection'];
// var schema = "<div class='site'> <div class='menu' id='nav-bar'/> <div class='original' id='original-content' /> </div>";
var server_url = vulnfinder_server = 'localhost:3000';
var toHide = [];

function onHover(input, field) {
    input.toggleClass('active-input');
    field.toggleClass('active-field');
}

function attacksUI(idx) {
    var content = "<ul class='attack-list' id='attacks-" + idx + "'>";
    for (attack in attackList) {
        content += "<li class='li-f noselect'>";
        content += "<label class='label-ch'><input type='checkbox' class='vulnfinder-input  ch'> <span class='attack-name'>" + attackList[attack] + "</span></label>";
        content += "</li>";
    }
    content += "</ul>";
    return content;
}

function format(field, idx, action) {
    var label = field.attr('name');
    var text = "<div class='ul-f noselect truncate' id='field-" + idx + "'>";
    text += "<input type='checkbox' class='vulnfinder-input vulnfinder-ch-field'><span class='field-name'>" + label + "</span>";
    text += "<input type='hidden' class='vulnfinder-input input-form-url' value='" + action + "' />";
    text += "</div>";

    if (label === undefined || label == 'downvoteReason') return '';
    return text + attacksUI(idx) + " <span class='domain'>(" + action + ")</span>";
}


function dataContent(idx, iframe) {
    var res = [];
    iframe.find('#attacks-' + idx).find('input:checkbox:checked').each(function () {
        var info = $(this).parent().find('.attack-name').html();
        res.push(info);
    });
    return res;
}

function actionForm(input) {
    var action = input.closest('form').attr('action');
    var action_d = String(document.location.href);

    if (action == '' || action === undefined) {
        action = action_d;
        // } else if (action[0] == '/') {
        // var last = String(action_d.split('/').slice(-1)).length;
        // action = action_d.substr(0, action_d.length - last - 1) + String(action);
    }
    return String(action);
}

function onReset() {
    $('input:checkbox').prop('checked', false);
    $('.attack-list').css('display', 'none');
    $('.ul-f').removeClass('active-field');
    $('input').removeClass('active-input');
}

function checking(field) {
    var attack = field.find('input');

    if (attack.prop('checked')) {
        attack.prop('checked', true);

    } else {
        attack.prop('checked', false);
    }
}

function findInput() {
    var iframe = $('#nav-bar-iframe').contents();
    // attach input and bind events
    $('body').find('input').each(function (idx, val) {
        var input = $(this);
        if (!input.hasClass('vulnfinder-input')) {
            var elm = format(input, idx, actionForm(input));
            iframe.find('#fields-div').append(elm);

            if (elm.length > 0) {
                input.addClass('vulnfinder-target');
            }

            var field = iframe.find('#field-' + idx);
            var attack = iframe.find('#attacks-' + idx);

            field.hover(function () {
                if (attack.css('display') === 'none') {
                    onHover(input, $(this));
                }
                input.focus();
            }).click(function () {
                attack.toggle();
            });

            input.hover(function () {
                if (attack.css('display') === 'none') {
                    onHover(input, field);
                }
                field.find('input')[0].focus();
            });
        }
    });

    // attach select and bind events
    var idx = 1000;
    $('body').find('select').each(function () {
        var input = $(this);
        if (!input.hasClass('vulnfinder-input')) {
            var elm = format(input, idx, actionForm(input));
            iframe.find('.all-fields').append(elm);

            var field = iframe.find('#field-' + idx);
            var attack = iframe.find('#attacks-' + idx);

            // var hack = idx;
            field.hover(function () {
                if (attack.css('display') === 'none') {
                    onHover(input, $(this));
                }
                input.focus();
            }).click(function () {
                attack.toggle();
            });

            input.hover(function () {
                if (attack.css('display') === 'none') {
                    onHover(input, field);
                }
                field.find('input')[0].focus();
            });
            idx += 1;
        }
    });

    // handle 'see hidden' checkbox
    iframe.find('#see-hidden').click(function () {
        var chk = $(this).find('input:checkbox').first();
        if (chk.prop('checked')) {
            chk.prop('checked', true);
            $('.vulnfinder-target').each(function () {
                if ($(this).attr('type') == 'hidden') {
                    toHide.push($(this));
                    $(this).attr('type', 'text');
                }
            });
        } else {
            chk.prop('checked', false);
            for (input in toHide) {
                toHide[input].attr('type', 'hidden');
            }
        }
    });

    iframe.find('.label-ch').click(function () {
        var attack = $(this).find('input');
        var index = $(this).parent().parent().attr('id').split('-')[1];
        var field = iframe.find('#field-' + index);
        var input = field.find('input');
        if (attack.prop('checked')) {
            input.prop('checked', true);
            field.addClass('vulnfinder-selected-field');
            field.toggleClass('active');
            field.toggleClass('active-field');
        } else {
            if ($(this).parent().parent().find('input:checkbox:checked').length == 0) {
                input.prop('checked', false);
                field.removeClass('vulnfinder-selected-field');
            } else {
                field.toggleClass('active');
                field.toggleClass('active-field');
            }
        }
    });

    // handle config panel
    iframe.find('.vcc2').click(function () {
        iframe.find('#vul-server-field').attr('value', '');
        iframe.find('#vul-server-field').css('display', 'block');
    });

    iframe.find('.vcc1').click(function () {
        server_url = vulnfinder_server;
        iframe.find('#vul-server-field').attr('value', server_url);
        iframe.find('#vul-server-field').css('display', 'none');
    });

    iframe.find('#vul-server-button').click(function () {
        var r_val = iframe.find("input[name='vul-config-server']:checked").val();
        if (r_val == '2') {
            server_url = iframe.find('#vul-server-field').val();
        }        
    });

    iframe.find('.vul-send').click(function () {
        var invocation = new XMLHttpRequest();
        var data = [];
        iframe.find('.vulnfinder-selected-field').each(function () {
            var dataField = {};
            var index = $(this).attr('id').split('-')[1];
            var field = $(this).find('.field-name').html();

            dataField.actionForm = document.domain + $(this).find('.input-form-url').attr('value');
            dataField.inputName = field;
            dataField.attacks = dataContent(index, iframe);
            data.push(dataField);

            // var data = new FormData();
            // data.append(field, dataField);
            // data.append('inputName', field);
            // data.append('attacks', dataContent(index, iframe));
            // data.append('prueba', da);


        });
        alert(JSON.stringify(data));
        var url = 'http://' + server_url;
        invocation.open('POST', url, true);
        invocation.onreadystatechange = handler;
        invocation.send(data);

        function handler(evtXHR) {
            if (invocation.readyState == 4) {
                if (invocation.status == 200) {
                    var response = invocation.responseXML;
                    var invocationHistory = response.getElementsByTagName('invocationHistory').item(0).firstChild.data;
                    invocationHistoryText = document.createTextNode(invocationHistory);
                    var textDiv = document.getElementById("textDiv");
                    textDiv.appendChild(invocationHistoryText);

                }
                else
                    alert("Invocation Errors Occured");
            }
            else
                dump("currently the application is at" + invocation.readyState);
        }

        onReset();

    });
}



