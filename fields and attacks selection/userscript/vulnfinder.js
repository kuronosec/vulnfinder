/**
 * Created by jonathan on 27/06/16.
 */
// ==UserScript==
// @name        VulnFinderNew
// @namespace   test
// @include     *
// @version     1
// @grant       none
// @require     https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js
// ==/UserScript==

var vulnfinder_st = `.button {
  font-size: 1em;
  padding: 10px;
  color: #fff;
  border: 2px solid #06D85F;
  border-radius: 20px/50px;
  text-decoration: none;
  cursor: pointer; 
}

.button:hover {
  background: #088A4B;
}

.overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.7);
  transition: opacity 500ms;
  visibility: hidden;
  opacity: 0;
}

.overlay:target {
  visibility: visible;
  opacity: 1;
}

.popup {
  margin: 70px auto;
  padding: 20px;
  background: #fff;
  border-radius: 5px;
  width: 30%;
  position: relative;
  transition: all 5s ease-in-out;
}

.popup h2 {
  margin-top: 0;
  color: #333;
  font-family: Tahoma, Arial, sans-serif;
}
.popup .close {
  position: absolute;
  top: 20px;
  right: 30px;
  transition: all 200ms;
  font-size: 30px;
  font-weight: bold;
  text-decoration: none;
  color: #333;
}
.popup .close:hover {
  color: #06D85F;
}
.popup .modal-body {
  max-height: 30%;
  overflow: auto;
  color: #333;
  font-family: Tahoma, Arial, sans-serif;
}

@media screen and (max-width: 700px){
  .box{
    width: 70%;
  }
  .popup{
    width: 70%;
  }
}

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
  padding: 30px 0px 30px 5px;
  border: solid;
  border-color: black;
  color: white;
  position: fixed;
  z-index: 100;
  overflow-y: auto;
  height: 93%;
  width:15%;
}
#original-content {
    width:84.5%;
    float:right;
}

.ul-f {
  color: white;
  margin-top: 20px;
  cursor: pointer; 
  clear:left
}

.li-f .label-ch{
  display:block;
  cursor: pointer;
  text-indent:15px;
}

.li-f:hover {
  background:#f1f1f1;
  color:black
}

.ch {
  cursor:pointer;
}

#see-hidden {
  cursor: pointer;
}
  
.active-input {
  background-color: yellow !important;
}

.active-field {
  background:#f1f1f1;
  color:black
}

.all-fields {
  margin: 15px 0px 15px 0px;
}

.domain {
    float:left;
}

.truncate {
  width: 250px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.v-line {
  margin: 5px 0px 5px -25px;
  padding: 0px 0px 0px 0px;
}

.active {
    background-color: #4CAF50;
    color: white;
}
`;

//initializing variables
var attackList = ['SQL Injection', 'Fuzzer', 'XSS', 'Auth and session', 'Auth', 'General Injection'];
var schema = "<div class='site'> <div class='menu' id='nav-bar'/> <div class='original' id='original-content' /> </div>";
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
    "<script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js' />"
];

addGlobalStyle(vulnfinder_st);

onHover = function (input, field) {
    input.toggleClass('active-input');
    field.toggleClass('active-field');
}

attacksUI = function (idx) {
    var content = "<ul class='attack-list' id='attacks-" + idx + "'>";
    for (attack in attackList) {
        content += "<li class='li-f noselect'>";
        content += "<label class='label-ch'><input type='checkbox' class='ch'> <span class='attack-name'>" + attackList[attack] + "</span></label>";
        content += "</li>";
    }
    content += "</ul>";
    return content;
}

format = function (field, idx, action) {
    var label = field.attr('name');
    var text = "<div class='ul-f noselect truncate' id='field-" + idx + "'>";
    text += "<input type='checkbox' class='vulnfinder-ch-field'><span class='field-name'>" + label + "</span>";
    text += "<input type='hidden' class='input-form-url' value='" + action + "' />";
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

configPanel = function () {
    // would be nice to use a template engine as handlebars for this kind of html codes insertion ...
    var panel = "<div class='overlay' id='configPanel'>" +
        "<div class='popup' role='document'>" +
        "<div class='modal-header'>" +
        "<a class='close' href='#'>&times</a>" +
        "<h2>Select a Server</h2>" +
        "</div>" +
        "<div class='modal-body'>" +
        "<input type='radio' name='vul-config-server' class='vul-chk-config vcc1' value='1' checked /> Use online servers<br><br>" +
        "<input type='radio' name='vul-config-server' class='vul-chk-config vcc2' value='2' /> I have my own server<br><br>" +
        "<input type='text' name='vul-server-ip' id='vul-server-field' class='form-control' value='" + server_url + "' placeholder='e.g. 127.0.0.1' hidden='true'/>" +
        "</div>" +
        "<div class='modal-footer'>" +
        "<button type='button' class='btn btn-primary' id='vul-server-button'>Save changes</button>" +
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
    $('#nav-bar').append("<a class='button' href='#configPanel'>settings</a><br><br><br>");
    $('#nav-bar').append("<hr class='v-line' />");
    $('#nav-bar').append("<label id='see-hidden'><input type='checkbox' class='ch' /><span class='noselect' id='see-hidden-span'> See hidden </span></label> <hr class='v-line' />");
    // $('#nav-bar').append("<span class='noselect' id='see-hidden-span'> See hidden </span> <hr class='v-line' /></label>");
    $('#nav-bar').append("<div class='all-fields' />");

    $('#original-content').html(body_content);
});

$(window).load(function () {
    // attach input and bind events
    $("#original-content").find('input').each(function (idx, val) {
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
            $('#field-' + idx).find('input')[0].focus();
        });
    });

    // attach select and bind events
    var idx = 1000;
    $("#original-content").find('select').each(function () {
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
            if ($('#attacks-' + hack).css('display') === 'none') {
                onHover(input, $('#field-' + hack));
            }
            $('#field-' + hack).find('input')[0].focus();
        });
        idx += 1;
    });

    $('#nav-bar').append("<hr class='v-line' />");
    $('#nav-bar').append("<button class='btn-sm btn-block vul-send btn btn-default'>Analize input fields</button>");

    // disable checkboxes
    // $('#field-ch').prop('disabled', true);

    //handle field checkbox
    $('.vulnfinder-ch-field').click(function () {
        $(this).prop('checked', !$(this).prop('checked'))
    })

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
    $('.label-ch').click(function () {
        var attack = $(this).find('input');
        var index = $(this).parent().parent().attr('id').split('-')[1];
        var field = $('#field-' + index)
        var input = field.find('input');
        if (attack.prop('checked')) {
            input.prop('checked', true);
            field.toggleClass('active');
            field.toggleClass('active-field');
        } else {
            if ($(this).parent().parent().find('input:checkbox:checked').length == 0) {
                input.prop('checked', false);
            } else {
                field.toggleClass('active');
                field.toggleClass('active-field');
            }
        }
    })
    //     .hover(function () {
    //     $(this).toggleClass('active-field');
    // });

    // handle 'see hidden' checkbox
    $('#see-hidden').click(function () {
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


    // due to cross-site attacks, ajax request are marked as preflighted requests
    // http://stackoverflow.com/questions/1256593/why-am-i-getting-an-options-request-instead-of-a-get-request
    // origin policy only allow XMLHTTPRequests to your own domain, then we will use JSONP instead
    // $('.vul-send').click(function () {
    //     $('.ul-f').each(function () {
    //         var marked = $(this).find('input:checkbox:checked');
    //         var index = $(this).attr('id').split('-')[1];
    //         var field = $(this).find('.field-name').html();
    //
    //         if (marked.length == 1) {
    //             $.getJSON("https://" + server_url + "/?callback=?", {
    //                 actionForm: $(this).find('.input-form-url').attr('value'),
    //                 inputName: field,
    //                 "attacks[]": dataContent(index)
    //             }).fail(function (data, textStatus, error) {
    //                 //var err = textStatus + ", " + error;
    //                 alert("Request Failed: " + "field " + field + ", " + error);
    //             }).done(function () {
    //                 alert("Datos enviados.");
    //             });
    //         }
    //     });

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

    // onReset();

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

    // });

    //

});