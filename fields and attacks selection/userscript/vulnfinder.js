// ==UserScript==
// @name        VulnFinder
// @namespace   test
// @include     *
// @version     1
// @grant       none
// @require     https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js
// @require     https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js
// ==/UserScript==


//String template with CSS
var vulnfinder_st = `
.attack-list {
  display: none;
  color: white;
  font-size: 10px;
  margin: 5px 0px 5px 0px;
  padding-left: 20px;
}

#nav-bar {
  font-family: sans-serif !important;
  font-size: 14px;
  float: left;
  background-color: #333;
  margin: 0px 0px 0px 0px;
  padding: 30px 0px 30px 30px;
  border: solid;
  border-color: black;
  color: white;
}

#original-content {
  float: left;
}

.active-input {
  background-color: yellow !important;
}

.active-field {
  background-color: yellow !important;
  color: gray !important;
}

.ul-f {
  color: white;
  margin-top: 5px;
  cursor: pointer;
}

.li-f {
  cursor: pointer;
}

.v-line {
  margin: 5px 0px 5px -25px;
  padding: 0px 0px 0px 0px;
}

.vul-config {
  font-size: 15px;
  margin-bottom: 20px;
}

#see-hidden {
  cursor: pointer;
}

.all-fields {
  margin: 15px 0px 15px 0px;
}

.vul-send {
  margin: 30px 0px 0px -15px;
}

#vul-server-field {
  display: none;
}

#configPanel {
  color: black;
}

.ch {
  cursor: pointer;
  margin-right: 10px !important;
}

.vulnfinder-header {
  color: gray;
}

.noselect {
  -webkit-touch-callout: none; /* iOS Safari */
  -webkit-user-select: none;   /* Chrome/Safari/Opera */
  -khtml-user-select: none;    /* Konqueror */
  -moz-user-select: none;      /* Firefox */
  -ms-user-select: none;       /* IE/Edge */
  user-select: none;           /* non-prefixed version, currently not supported by any browser */
}`;

//initializing variables
var attackList = ['SQL Injection', 'Fuzzer', 'XSS', 'Auth and session', 'Auth', 'General Injection'];
var schema = "<div class='site'> <div class='col-md-2' id='nav-bar'/> <div class='col-md-10' id='original_content' /> </div>";
var server_url = vulnfinder_server = '127.0.0.1:3000';
var toHide = [];

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
}

var stylesheets = [
    "<link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css' />",
    "<script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js' />"
];

addGlobalStyle(vulnfinder_st);

onHover = function (input, field) {
    input.toggleClass('active-input');
    field.toggleClass('active-field');
}


// attacksUI = function (idx) {
//     // var content = document.createElement('ul');
//     // content.className = 'attack-list';
//     // content.id = 'attacks-' + idx;
//     var content = "<ul class='attack-list' id='attacks-" + idx + "'>";
//     for (attack in attackList) {
//         // var item = document.createElement('li');
//         // item.className = 'li-f noselect';
//         // var attackCheck = document.createElement('input');
//         // attackCheck.type = 'checkbox';
//         // attackCheck.className = 'ch';
//         // var attackText = document.createElement('span');
//         // attackText.className = 'attack-name';
//         // var attackName = document.createTextNode(attackList[attack]);
//         // attackText.appendChild(attackName);
//         // item.appendChild(attackCheck);
//         // item.appendChild(attackText)
//         content += "<li class='li-f noselect'>";
//         content += "<input type='checkbox' class='ch'> <span class='attack-name'>" + attackList[attack] + "</span>";
//         content += "</li>";
//     }
//     content.appendChild(item);
//     doc
//     content += "</ul>";
//     return content;
// }

attacksUI = function (idx) {
    var content = "<ul class='attack-list' id='attacks-" + idx + "'>";
    for (attack in attackList) {
        content += "<li class='li-f noselect'>";
        content += "<input type='checkbox' class='ch'> <span class='attack-name'>" + attackList[attack] + "</span>";
        content += "</li>";
    }
    content += "</ul>";
    return content;
}

format = function (field, idx, action) {
    var label = field.attr('name');
    var text = "<div class='ul-f noselect' id='field-" + idx + "'>";
    text += "<input type='checkbox' class='ch'> <span class='field-name'>" + label + "</span>";
    text += "<input type='hidden' class='input-form-url' value='" + action + "' />";
    text += "</div>";

    if (label === undefined || label == 'downvoteReason') return '';
    return text + attacksUI(idx) + " (" + action + ")";
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

configPanel = function () {
    // would be nice to use a template engine as handlebars for this kind of html codes insertion ...
    var panel = "<div class='modal fade' id='configPanel' tabindex='-1' role='dialog' aria-labelledby='select server ...'>" +
        "<div class='modal-dialog' role='document'>" +
        "<div class='modal-content'>" +
        "<div class='modal-header'>" +
        "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>x</span></button>" +
        "<h4 class='modal-title'>Select a Server</h4>" +
        "</div>" +
        "<div class='modal-body'>" +
        "<input type='radio' name='vul-config-server' class='vul-chk-config vcc1' value='1' checked /> Use online servers<br><br>" +
        "<input type='radio' name='vul-config-server' class='vul-chk-config vcc2' value='2' /> I have my own server<br><br>" +
        "<input type='text' name='vul-server-ip' id='vul-server-field' class='form-control' value='" + server_url + "' placeholder='e.g. 127.0.0.1'/>" +
        "</div>" +
        "<div class='modal-footer'>" +
        "<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>" +
        "<button type='button' class='btn btn-primary' data-dismiss='modal' id='vul-server-button'>Save changes</button>" +
        "</div>" +
        "</div>" +
        "</div>" +
        "</div>";
    return panel;
}

jQuery(document).ready(function () {
    // Inject dependencies
    for (st in stylesheets)
        $('head').prepend(stylesheets[st]);

    // add left-nav
    var body_content = $('body').html();
    $('body').html(schema);
    $('#nav-bar').append(configPanel);
    $('#nav-bar').append("<h1 class='vulnfinder-header'> vulnfinder </h1>");
    $('#nav-bar').append("<div class='vul-config' data-toggle='modal' data-target='#configPanel'><span class='btn btn-xs btn-default'>config</span></div>");
    $('#nav-bar').append("<hr class='v-line' />");
    $('#nav-bar').append("<input type='checkbox' class='ch' />");
    $('#nav-bar').append("<span class='noselect' id='see-hidden'> See hidden </span> <hr class='v-line' />");
    $('#nav-bar').append("<div class='all-fields' />");

    $('#original_content').html(body_content);
});

$(window).load(function () {
    // attach input and bind events
    $("#original_content").find('input').each(function (idx, val) {
        var input = $(this);
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
            // $('#field-' + idx).focus();
        });
    });

    // attach select and bind events
    var idx = 1000;
    $("#original_content").find('select').each(function () {
        var input = $(this);
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
            if ($('#attacks-' + idx).css('display') === 'none') {
                onHover(input, $('#field-' + idx));
            }
            // $('#field-' + idx).focus();
        });
        idx += 1;
    });

    $('#nav-bar').append("<hr class='v-line' />");
    $('#nav-bar').append("<button class='btn-sm btn-block vul-send btn btn-default'>Analize input fields</button>");

    // disable checkboxes
    $('input:checkbox').prop('disabled', true);

    // handle config panel
    $('.vcc2').click(function () {
        $('#vul-server-field').attr('value', '');
        $('#vul-server-field').css('display', 'block');
    });

    $('.vcc1').click(function () {
        server_url = vulnfinder_server;
        $('#vul-server-field').attr('value', server_url);
        $('#vul-server-field').css('display', 'none');
    });

    $('#vul-server-button').click(function () {
        var r_val = $("input[name='vul-config-server']:checked").val();
        if (r_val == '2') {
            server_url = $('#vul-server-field').val();
        }
    });

    // handle checkboxes - check / uncheck
    $('.li-f').click(function () {
        var attack = $(this).find('input');
        var index = $(this).parent().attr('id').split('-')[1];
        var input = $('#field-' + index).find('input');

        if (attack.prop('checked')) {
            attack.prop('checked', false);
            if ($(this).parent().find('input:checkbox:checked').length == 0) {
                input.prop('checked', false);
            }
        } else {
            attack.prop('checked', true);
            input.prop('checked', true);
        }
    }).hover(function () {
        $(this).toggleClass('active-field');
    });

    // due to cross-site attacks, ajax request are marked as preflighted requests
    // http://stackoverflow.com/questions/1256593/why-am-i-getting-an-options-request-instead-of-a-get-request
    // origin policy only allow XMLHTTPRequests to your own domain, then we will use JSONP instead
    $('.vul-send').click(function () {
        $('.ul-f').each(function () {
            var marked = $(this).find('input:checkbox:checked');
            var index = $(this).attr('id').split('-')[1];
            var field = $(this).find('.field-name').html();

            if (marked.length == 1) {
                $.getJSON("https://" + server_url + "/?callback=?", {
                    actionForm: $(this).find('.input-form-url').attr('value'),
                    inputName: field,
                    "attacks[]": dataContent(index)
                }).fail(function (data, textStatus, error) {
                    //var err = textStatus + ", " + error;
                    alert("Request Failed: " + "field " + field + ", " + error);
                }).done(function () {
                    alert("Datos enviados.");
                });
            }
        });

    // $('.vul-send').click(function () {
    //     $('.ul-f').each(function () {
    //         var marked = $(this).find('input:checkbox:checked');
    //         var index = $(this).attr('id').split('-')[1];
    //         var field = $(this).find('.field-name').html();
    //         var invocation = new XMLHttpRequest();
    //
    //         if (marked.length == 1) {
    //             var url = 'http://' + server_url + '?actionForm=' + $(this).find('.input-form-url').attr('value') +
    //                 '&inputName=' + field + '&attacks[]=' + dataContent(index);
    //             invocation.open('GET', url, true);
    //             invocation.onreadystatechange = handler;
    //             invocation.send();
    //         }
    //     });
    //
    //     function handler(evtXHR)
    //     {
    //         if (invocation.readyState == 4)
    //         {
    //             if (invocation.status == 200)
    //             {
    //                 var response = invocation.responseXML;
    //                 var invocationHistory = response.getElementsByTagName('invocationHistory').item(0).firstChild.data;
    //                 invocationHistoryText = document.createTextNode(invocationHistory);
    //                 var textDiv = document.getElementById("textDiv");
    //                 textDiv.appendChild(invocationHistoryText);
    //
    //             }
    //             else
    //                 alert("Invocation Errors Occured");
    //         }
    //         else
    //             dump("currently the application is at" + invocation.readyState);
    //     }

        onReset();

        // decide whether a server is offline is impossible from JS
        // anyway if don't take my words you can google "javascript ping"

        // now you can say AJAX and its method handlers are the solution but ...

        // that is't quite true, we can't make any request to other domains
        // without verify our identity MEANS preflight-request (works like sync-ack in tcp protocol)

        // but you can say lets use .error() handler for $.getJSON unfortunately JQUERY doesn't support it for JSONP request
        // taken from JQUERY DOC:

        // .timeout(): "JSONP requests cannot be cancelled by a timeout; the script will run even if it arrives after the timeout period."
        // .error(): "This handler is not called for cross-domain script and cross-domain JSONP requests"

        // also can check original ISSUE
        // https://bugs.jquery.com/ticket/3442

    });

    // handle 'see hidden' checkbox
    $('#see-hidden').click(function () {
        var chk = $(this).parent().find('input:checkbox').first();
        if (chk.prop('checked') === false) {
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
});