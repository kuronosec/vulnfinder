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
    var field = $('#field-' + index);
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
});
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