/*
 @author Jonathan Medina
 This Script is the part of web extension that runs in the context of a particular web page (as opposed to background
 script wich are part of the extension)
 */

var navBarUI = false;
var currentTOE = null;
var urlParameters = "";

// Create the navBar ui iframe and inject it in the current page
function initNavBar() {

    var iframe = document.createElement("iframe");
    iframe.setAttribute("id", "nav-bar-iframe");
    iframe.setAttribute("src", chrome.runtime.getURL("resources/nav-bar.html"));
    iframe.setAttribute("class", "nav-bar-iframe-left");
    document.body.appendChild(iframe);

    // When the navBar is ready this call findInput function to find all input fields of the web page
    $('#nav-bar-iframe').on("load", function () {
        findInput();

        //handle the clic event of the attacks popover's checkbox
        $(".vuln-label-ch").click(function () {
            syncPopoverNavbar($(this), 2)
        });
    });


    return navBarUI = {
        iframe: iframe, visible: true
    };
}

//Put or remove the nav bar of the web page
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

        //assign the domain of the current TOE in a global variable
        currentTOE = msg.currentTOE;

        //This message is sent when the browser action button is pressed
        if (msg.action == "toggle-in-page-navBar") {
            if (navBarUI) {
                toggleNavBar(navBarUI);
            } else {
                navBarUI = initNavBar();
            }
            //    This message is sent when occur an event of change or update of a tab
        } else if (msg.action == "add-in-page-navBar") {
            if (navBarUI) {
                navBarUI.visible = true;
                navBarUI.iframe.style["display"] = "block";
            } else {
                navBarUI = initNavBar();
            }
        } else if (msg.action == "remove-in-page-navBar") {
            navBarUI.visible = false;
            navBarUI.iframe.style["display"] = "none";
        }
    });
}

//initializing variables
var attackList = ['SQL Injection', 'Authentication', 'XSS', 'Authorization', 'Privilege Scalation'];
// var schema = "<div class='site'> <div class='menu' id='nav-bar'/> <div class='original' id='original-content' /> </div>";
var server_url = vuln_server = 'localhost:3000';
var toHide = [];


//Create the list of attack in html
function attacksUI(idx) {
    var content = "<ul class='attack-list' id='attacks-" + idx + "'>";
    for (attack in attackList) {
        content += "<li class='li-f'>";
        content += "<label class='vuln-label-ch' id='" + idx + "-" + attackList[attack].replace(' ', '') + "'><input type='checkbox' class='vuln-input  ch'><span class='attack-name'>" + attackList[attack] + "</span></label>";
        content += "</li>";
    }
    content += "</ul>";
    return content;
}

function format(field, idx, action) {
    var label;
    // if(field.attr('name')){
    label = field.attr('name');
    // }else if (field.attr('id')){
    //     label = field.attr('id');
    // }else{
    //     label = 'no-name'+ idx;
    // }
    var text = "<div class='vuln-attack-item truncate' id='field-" + idx + "'>";
    text += "<input type='checkbox' class='vuln-input vuln-ch'/><span class='field-name'>" + label + "</span>";
    text += "<input type='hidden' class='vuln-input input-form-url' value='" + action + "' />";
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
    $('.vuln-attack-item').removeClass('active-field');
    $('input').removeClass('active-input');
}

function checking() {
    var inputField = $(this);
    var idx = inputField.parent().attr('id').split('-').slice(1);
    var field = $(this).parent();
    field.parent().find('#attacks-' + idx).find('.vuln-label-ch').each(function (idx, val) {
        if (inputField.prop('checked')){
            $(this).find('input').prop('checked', true);
            field.addClass('vuln-selected-field');
        }else{
            $(this).find('input').prop('checked', false);
            field.removeClass('vuln-selected-field');
        }
    });
    // if ($(this).prop('checked')) {
    //     $(this).prop('checked', false);
    //
    // } else {
    //     $(this).prop('checked', true);
    // }
}

function syncPopoverNavbar(actLabel, checked) {
    if (checked == 1) {
        var labelNavbar = actLabel;
        var labelPopover = $('#' + actLabel.attr('id'));
    } else {
        var labelPopover = actLabel;
        var labelNavbar = iframe.find('#' + actLabel.attr('id'));
    }

    var attackNavbar = labelNavbar.find('input');
    var attackPopover = labelPopover.find('input');
    var index = labelNavbar.attr('id').split('-')[0];
    var field = iframe.find('#field-' + index);
    var input = field.find('input');

    function handlingCheckingTrue() {
        input.prop('checked', true);
        field.addClass('vuln-selected-field');
        field.toggleClass('active');
        field.toggleClass('active-field');
    }

    function handlingCheckingFalse() {
        if (labelNavbar.parent().parent().find('input:checkbox:checked').length == 0) {
            input.prop('checked', false);
            field.removeClass('vuln-selected-field');
        } else {
            input.prop('checked', true);
            field.toggleClass('active');
            field.toggleClass('active-field');
        }
    }

    if (checked == 1) {
        if (attackNavbar.prop('checked')) {
            attackPopover.prop('checked', true);
            handlingCheckingTrue();

        } else {
            attackPopover.prop('checked', false);
            handlingCheckingFalse();
        }
    } else {
        if (attackPopover.prop('checked')) {
            attackNavbar.prop('checked', true);
            handlingCheckingTrue();
        } else {
            attackNavbar.prop('checked', false);
            handlingCheckingFalse();
        }
    }
}

function findInput() {
    iframe = $('#nav-bar-iframe').contents();

    //this event move the nav-bar left to right
    iframe.find("#vuln-lateral-move").click(function () {
        $('#nav-bar-iframe').toggleClass("nav-bar-iframe-left");
        $('#nav-bar-iframe').toggleClass("nav-bar-iframe-right");
    })

    function onHover(input, field) {
        if (input != null)
            input.toggleClass('active-input');
        field.toggleClass('active-field');

    }

    var getParameters = window.location.search.substr(1);
    var keyElement;
    var action = String(location.pathname);
    var tableGet = document.createElement("table");
    tableGet.setAttribute("style", "width:100%");
    var trTitleGet = document.createElement("tr");
    var th1Get = document.createElement("th");
    var th2Get = document.createElement("th");
    th1Get.innerHTML = "Parameter";
    trTitleGet.appendChild(th1Get);
    th2Get.innerHTML = "Static";
    trTitleGet.appendChild(th2Get);
    tableGet.appendChild(trTitleGet);
    iframe.find('#vuln-get-parameters-div').append(tableGet);

    if (getParameters.length){
        var keys = getParameters.split('&');
        for (k in keys){
            key = keys[k].split('=')[0];
            keyElement = document.createElement('input');
            keyElement.setAttribute('name', key);
            keyElement = $(keyElement);
            var trFieldGet = document.createElement("tr");
            var tdFieldGet = document.createElement("td");
            var tdCheckGet = document.createElement("td");
            var checkGet = document.createElement("input");
            var idx = parseInt(k)+2000;
            var elm = format(keyElement, idx, action);
            var element = document.createElement("div");
            element.innerHTML = elm;
            tdFieldGet.appendChild(element);
            checkGet.setAttribute("type", "checkbox");
            checkGet.setAttribute("id", "parameter-static" + idx);
            checkGet.setAttribute("class", "vuln-ch-parameter-static");
            tdCheckGet.appendChild(checkGet);
            trFieldGet.appendChild(tdFieldGet);
            trFieldGet.appendChild(tdCheckGet);
            // iframe.find('#vuln-get-parameters-div').append(elm);
            tableGet.appendChild(trFieldGet);

            iframe.find('#field-' + idx).hover(function () {
                onHover(null, $(this));
            }, function () {
                onHover(null, $(this));
            }).click(function () {
                var attack = iframe.find('#attacks-' + $(this).attr('id').split('-').slice(-1));
                attack.toggle();
            });


        }

    }


    // attach input and bind events
    $('body').find('input').each(function (idx, val) {
        var input = $(this);
        var elm = format(input, idx, actionForm(input));
        iframe.find('#fields-div').append(elm);

        if (elm.length > 0) {
            input.addClass('vuln-target');

            //Create popover of this input
            var element = document.createElement('div');
            element.innerHTML = elm;
            var divAttacks = document.createElement('div');
            divAttacks.setAttribute('class', 'webui-popover-content');
            divAttacks.setAttribute('id', 'vuln-attacks-' + idx);
            divAttacks.appendChild(element.childNodes[1]);
            document.body.appendChild(divAttacks);
            input.webuiPopover({url: '#vuln-attacks-' + idx, trigger: 'hover', width: 175});
        }

        var field = iframe.find('#field-' + idx);
        var attack = iframe.find('#attacks-' + idx);

        field.hover(function () {
            onHover(input, $(this));
            input.focus();
        }, function () {
            onHover(input, $(this));
        }).click(function () {
            attack.toggle();
        });

        input.hover(function () {
            onHover(input, field);
            // input.webuiPopover('show');
            field.find('input')[0].focus();
        }, function () {
            onHover(input, field);
        });
    });

    // attach select and bind events
    var idx = 1000;
    $('body').find('select').each(function () {
        var input = $(this);
        // if (!input.hasClass('vuln-input')) {
        var elm = format(input, idx, actionForm(input));
        iframe.find('.all-fields').append(elm);

        if (elm.length > 0) {
            input.addClass('vuln-target');

            //Create popover of this input
            var element = document.createElement('div');
            element.innerHTML = elm;
            var divAttacks = document.createElement('div');
            divAttacks.setAttribute('class', 'webui-popover-content');
            divAttacks.setAttribute('id', 'vuln-attacks-' + idx);
            divAttacks.appendChild(element.childNodes[1]);
            document.body.appendChild(divAttacks);
            input.webuiPopover({url: '#vuln-attacks-' + idx, trigger: 'hover', width: 175});
        }

        var field = iframe.find('#field-' + idx);
        var attack = iframe.find('#attacks-' + idx);

        // var hack = idx;
        field.hover(function () {
            onHover(input, $(this));
            input.focus();
        }, function () {
            onHover(input, $(this));
        }).click(function () {
            attack.toggle();
        });

        input.hover(function () {
            onHover(input, field);
            field.find('input')[0].focus();
        }, function () {
            onHover(input, field);
        });
        idx += 1;
        // }
    });

    // handle 'see hidden' checkbox
    iframe.find('#see-hidden').click(function () {
        var chk = $(this).find('input:checkbox').first();
        if (chk.prop('checked')) {
            chk.prop('checked', true);
            $('.vuln-target').each(function () {
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


    iframe.find('.vuln-label-ch').click(function () {
        syncPopoverNavbar($(this), 1)
    });

    //handle checking of field in navBar
    iframe.find('.vuln-ch').click(checking);

    // handle config panel
    iframe.find('.vcc2').click(function () {
        iframe.find('#vul-server-field').attr('value', '');
        iframe.find('#vul-server-field').css('display', 'block');
    });

    iframe.find('.vcc1').click(function () {
        server_url = vuln_server;
        iframe.find('#vul-server-field').attr('value', server_url);
        iframe.find('#vul-server-field').css('display', 'none');
    });

    iframe.find('#vul-server-button').click(function () {
        var r_val = iframe.find("input[name='vul-config-server']:checked").val();
        if (r_val == '2') {
            server_url = iframe.find('#vul-server-field').val();
        }
    });


    iframe.find("#vul-accept-button").click(function () {
        iframe.find("#TOE-panel").toggleClass("target-js");
        sendData();
    });

    iframe.find("#vul-cancel-button").click(function () {
        iframe.find("#TOE-panel").toggleClass("target-js");
    });

    iframe.find('.vul-send').click(function () {
        TOEDomain = document.domain;
        if (currentTOE != null && currentTOE != TOEDomain) {
            iframe.find("#TOE-panel").toggleClass("target-js");
            // window.location.href = "#TOE-panel";
        } else {
            sendData();
        }
    });

    function sendData() {
        var invocation = new XMLHttpRequest();
        var data = [];
        var action_d = String(document.location.href);
        var last = String(action_d.split('/').slice(-1)).length;

        iframe.find('.vuln-selected-field').each(function () {
            var dataField = {};
            var index = $(this).attr('id').split('-')[1];
            var field = $(this).find('.field-name').html();


            action = String($(this).find('.input-form-url').attr('value'));
            if (action[0]=='/'){
                action = action.substring(1);
            }
            if (action != action_d) {
                action = action_d.substr(0, action_d.length - last) + action;
            }
            dataField.actionForm = action;
            dataField.inputName = field;
            dataField.attacks = dataContent(index, iframe);
            data.push(dataField);

        });


        alert(JSON.stringify(data));
        var url = 'http://' + server_url;
        invocation.open('POST', url, true);
        invocation.onreadystatechange = responseHandler;
        invocation.send(JSON.stringify(data));


        //handle the response of XMLHttpRequest()
        function responseHandler(evtXHR) {
            if (invocation.readyState == 4) {
                if (invocation.status == 200) {
                    var response = invocation.responseXML;
                    alert("Data sent successfully");
                    notifyBackgroundPage(TOEDomain);
                    window.addEventListener("beforeunload", function (event) {
                        event.returnValue = "If you continue won't be able keep sending information to the server about this TOE ";
                    });
                }
                else
                    alert("Invocation Errors Occured");
            }
            else
                dump("currently the application is at" + invocation.readyState);
        }

        // onReset();
    }

    //Send the last TOE analized to background script
    function notifyBackgroundPage(message) {
        chrome.runtime.sendMessage(
            {TOEDomain: message}
        );
    }
}
