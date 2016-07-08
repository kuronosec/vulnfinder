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

$(window).load(function () {
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

// // Connect to the background page.
// var port = chrome.runtime.connect();
//
// // Handle click events on the toolbar button.
// document.querySelector("#toggle").addEventListener("click", function() {
//   // Ask the background page to toggle the toolbar on the current tab
//   port.postMessage("toggle-in-page-toolbar");
// });
