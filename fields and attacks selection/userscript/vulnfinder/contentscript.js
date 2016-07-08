var navBarUI;

// Create the navBar ui iframe and inject it in the current page
function initNavBar() {
    var iframe = document.createElement("iframe");
    iframe.setAttribute("src", chrome.runtime.getURL("resources/nav-bar.html"));
    iframe.setAttribute("style", "position: fixed; top: 0; left: 0; z-index: 10000; overflow-y: auto; height: 100%; width:15%; border:none");
    document.body.appendChild(iframe);

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
                navBarUI = initNavBar();
                findInput();
            }
        }
    });
}

//initializing variables
var attackList = ['SQL Injection', 'Fuzzer', 'XSS', 'Auth and session', 'Auth', 'General Injection'];
var schema = "<div class='site'> <div class='menu' id='nav-bar'/> <div class='original' id='original-content' /> </div>";
var server_url = vulnfinder_server = '127.0.0.1:3000';
var toHide = [];

onHover = function (input, field) {
    input.toggleClass('active-input');
    field.toggleClass('active-field');
}

attacksUI = function (idx) {
    var content = "<ul class='attack-list' id='attacks-" + idx + "'>";
    for (attack in attackList) {
        content += "<li class='li-f noselect'>";
        content += "<label class='label-ch'><input type='checkbox' class='vulnfinder-input  ch'> <span class='attack-name'>" + attackList[attack] + "</span></label>";
        content += "</li>";
    }
    content += "</ul>";
    return content;
}

format = function (field, idx, action) {
    var label = field.attr('name');
    var text = "<div class='ul-f noselect truncate' id='field-" + idx + "'>";
    text += "<input type='checkbox' class='vulnfinder-input vulnfinder-ch-field'><span class='field-name'>" + label + "</span>";
    text += "<input type='hidden' class='vulnfinder-input input-form-url' value='" + action + "' />";
    text += "</div>";

    if (label === undefined || label == 'downvoteReason') return '';
    return text + attacksUI(idx) + " <span class='domain'>(" + action + ")</span>";
}


dataContent = function (idx) {
    var res = [];
    $('#attacks-' + idx).find('input:checkbox:checked').each(function () {
        var info = $(this).parent().find('.attack-name').html();
        res.push(info);
    });
    return res;
}

actionForm = function (input) {
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

onReset = function () {
    $('input:checkbox').prop('checked', false);
    $('.attack-list').css('display', 'none');
    $('.ul-f').removeClass('active-field');
    $('input').removeClass('active-input');
}

checking = function (field) {
    var attack = field.find('input');

    if (attack.prop('checked')) {
        attack.prop('checked', true);

    } else {
        attack.prop('checked', false);
    }
}

function findInput() {
    // attach input and bind events
    $('body').find('input').each(function (idx, val) {
        var input = $(this);
        if (!input.hasClass('vulnfinder-input')) {
            var elm = format(input, idx, actionForm(input));
            $('.all-fields').append(elm);

            if (elm.length > 0) {
                input.addClass('vulnfinder-target');
            }

            $('#field-' + idx).hover(function () {
                if ($('#attacks-' + idx).css('display') === 'none') {
                    onHover(input, $(this));
                }
                input.focus();
            }).click(function () {
                $("#attacks-" + idx).toggle();
            });

            input.hover(function () {
                if ($('#attacks-' + idx).css('display') === 'none') {
                    onHover(input, $('#field-' + idx));
                }
                $('#field-' + idx).find('input')[0].focus();
            });
        }
    });

    // attach select and bind events
    var idx = 1000;
    $('body').find('select').each(function () {
        var input = $(this);
        if (!input.hasClass('vulnfinder-input')) {
            var elm = format(input, idx, actionForm(input));
            $('.all-fields').append(elm);

            var hack = idx;
            $('#field-' + idx).hover(function () {
                if ($('#attacks-' + hack).css('display') === 'none') {
                    onHover(input, $(this));
                }
                input.focus();
            }).click(function () {
                $("#attacks-" + hack).toggle();
            });

            input.hover(function () {
                if ($('#attacks-' + hack).css('display') === 'none') {
                    onHover(input, $('#field-' + hack));
                }
                $('#field-' + hack).find('input')[0].focus();
            });
            idx += 1;
        }
    });
}

