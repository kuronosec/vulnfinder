// ==UserScript==
// @name        vulnfinder-old
// @namespace   test
// @include     *
// @version     1
// @grant       none
// @require     http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.js
// @require     http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js
// ==/UserScript==

/**
 * sendInfo recibe un objeto (en lo general es un arreglo) y lo transmite por medio de POST a la url especificada en ajaxURL.
 * En el lado del servidor se recibe usando sockets normales.
 */
function sendInfo(info) {
    var toSend = {}; //Arreglo donde se guardan los datos a enviar.
    toSend[1] = info;
    var ajaxURL = 'http://localhost:25000';
    $.ajax({ //Definimos la acción a realizar.
        method: 'POST',
        url: ajaxURL,
        dataType: 'json',
        data: JSON.stringify(toSend),
    }).done(function (msg) { //Se envían los datos
        if (msg['response'] == 'empty') { //Si la respuesta es vacía es porque ocurrió un problema
            alert('Debe seleccionar un campo para evaluar');
        } else if (msg['response'] == 'ok') { //Si la respuesta es OK, se le indica al usuario
            alert('Datos procesados');
        } else if (msg['response'] != 'empty' && msg['response'] != 'ok') {
            alert('El servidor no esta disponible')
        }
    });
    alert(info + "ionfoooooooooo");
}

/**
 * jQuery ready
 * Esto se llama cuando se carga el DOM.
 */
jQuery(document).ready(function () {

    // definimos un arreglo con la lista de los posibles ataques a realizar.
    var attackList = [
        'SQL Injection',
        'Fuzzer',
        'XSS',
        'Auth and session',
        'Auth',
        'General Injection'
    ];

    //En el header agregamos la dependencia de bootstrap para los popoverables
    $('head').append('<link rel=\'stylesheet\' type=\'text/css\' href=\'http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css\'/>');
    //  $('body').append(texto);
    // Recorre cada form

    //Buscamos cada form en el documento
    $('form').each(function () {
        // Para alamcenar cada check
        var newCheck = '';
        // Almacena el action de cada form
        var actionForm = $(this).attr('action');
        if (actionForm == '' || actionForm == undefined) {
            actionForm = document.location;
        }
        //alert('action: ' + actionForm);
        $(this).find('input').each(function (unusedIndex, child) {
            /*
             crea por cada input un check
             agrega la clase chk_vfinder para identificar los checks incertados
             agraga la clase act_ mas el nombre del action para identificar de que form viene
             */


            var texto = '<div id=\'filters_' + $(this).attr('id') + '_lbl_opt\' style=\'display: none;\'>';
            for (attack in attackList) { //Agregamos cada ataque a la lista...
                texto = texto + '<label><input class=\'' + $(this).attr('id') + '_lbl_opt\' type=\'checkbox\' >' + attackList[attack] + '</label><br>';
            }
            texto = texto + '</div>';
            //Creamos un div que contendrá el popover que se mostrará cuando el usuario pose el puntero sobre el checkbox
            newCheck = '<label class=\'popoverable\' id=\'' + $(this).attr('id') + '_lbl\'>' + $(this).attr('name') + '<input type=\'checkbox\' name=\'' + $(this).attr('name') + '_chk\' id=\'' + $(this).attr('id') + '_chk\' class=\'chk_vfinder act_' + actionForm + '\'>' + '</label>' + texto;
            //$(this).replaceWith(newCheck);
            $(this).parent().append(newCheck);
        });
    });
    // Agrega el boton para enviar los checks seleccionados
    //$('body').prepend('<input type=\'button\' value=\'Send Vulnfinder\' id=\'enviar_vulnfinder\' name=\'enviar_vulnfinder\'><div id=\'destino\'></div>');
    // Evento para enviar los datos al hacer click
    $('.chk_vfinder').on('change', function () {
        if (this.checked) {
            sendInfo($(this).attr('name') + " checked");
        } else {
            sendInfo($(this).attr('name') + " UNchecked");
        }
    });
});

/**
 * jQuery load
 * Se ejecuta una vez se cargue todas las partes de la página, aquí se le agrega la propiedad popover a los elementos
 * .popoverable.
 */
$(window).load(function () {
    /** INICIO SECCIÓN CUSTOM POPOVER BEHAVIOR
     * En esta sección se indica que el popover se debe mostrar cuando el usuario mueva el mouse sobre el elemento y
     * se debe desaparecer cuando el usuario mueva el mouse fuera del elemento.
     */
    var originalLeave = $.fn.popover.Constructor.prototype.leave;
    $.fn.popover.Constructor.prototype.leave = function (obj) {
        var self = obj instanceof this.constructor ?
            obj : $(obj.currentTarget) [this.type](this.getDelegateOptions()).data('bs.' + this.type)
        var container,
            timeout;
        originalLeave.call(this, obj);
        if (obj.currentTarget) {
            container = $(obj.currentTarget).siblings('.popover')
            timeout = self.timeout;
            container.one('mouseenter', function () {
                //We entered the actual popover – call off the dogs
                clearTimeout(timeout);
                //Let's monitor popover content instead
                container.one('mouseleave', function () {
                    $.fn.popover.Constructor.prototype.leave.call(self, self);
                });
            })
        }
    };
    /** FIN SECCIÓN CUSTOM POPOVER BEHAVIOR*/
    //$('body').popover({ selector: '[data-popover]', trigger: 'click hover', placement: 'auto', delay: {show: 50, hide: 400}});

    //Asociamos los .popoverable con la funcionalidad popover
    $('.popoverable').popover({
        trigger: 'click hover',
        placement: 'auto',
        html: true,
        content: function () {
            //alert('#filters_'+this.id+'_opt');
            //Se retorna el HTML de lo que se debe mostrar.
            return $('body').find('#filters_' + this.id + '_opt').html();
        },
        delay: {
            show: 50,
            hide: 400
        }
    });
    /**
     * Esta es una pequeña triquiñuela de implementación.
     * Cuando el usuario cambie una opción en el popover se "persiste" temporalmente, en la estructura
     * que está oculta a la vista pero existe en el DOM, de tal manera que al cerrarse el popover no se
     * destruya la información que el usuario había ingresado.
     */
    $('.popoverable').on('shown.bs.popover', function () {
        $('.popover-content input').on('change', function () {
            if (this.checked) {
                this.setAttribute('checked', 'checked');
            } else {
                this.removeAttribute('checked');
            }
            sendInfo('#filters_' + this.className);
            $('#filters_' + this.className).html($('.popover-content').html());
        });
    });
});


