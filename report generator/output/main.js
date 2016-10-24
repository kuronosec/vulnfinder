function loadJQuery() {

    var waitForLoad = function () {
        if (typeof jQuery != "undefined") {
            console.log("jquery loaded..");
            $('.alert-title').click(function (e) {
                e.preventDefault();
            });
            $('[data-toggle="popover"]').popover();
            $(function () {
                $(".expand").on("click", function () {
                    $(this).next().slideToggle(200);
                    $expand = $(this).find(">:first-child");

                    if ($expand.text() === "+") {
                        $expand.text("-");
                    } else {
                        $expand.text("+");
                    }
                });
            });
        } else {
            console.log("jquery not loaded..");
            window.setTimeout(waitForLoad, 500);
        }
    };
    window.setTimeout(waitForLoad, 500);
}

window.onload = loadJQuery;


