// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
//= require bootstrap


if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}

console.log("      _ _    _ _   _ _  _______ _   _");
console.log("     | | |  | | \\ | | |/ /_   _| \\ | |");
console.log("     | | |  | |  \\| | ' /  | | |  \\| |");
console.log(" _   | | |  | | . ` |  <   | | | . ` |");
console.log("| |__| | |__| | |\\  | . \\ _| |_| |\\  |");
console.log("\\____/ \\____/ |_| \\_|_|\\_\\_____|_| \\_|");


$(document).ready(function () {
    //Button loading events
    $(document).on('click', '.btn-loading', function () {
        var $this = $(this);
        $this.button('loading');
        $('input').blur(function (event) {
            event.target.checkValidity();
        }).bind('invalid', function (event) {
            $this.button('reset');
        });
    });
});