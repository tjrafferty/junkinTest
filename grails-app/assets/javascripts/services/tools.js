var THINGA = THINGA || {};

(function () {
    var self = this;

    var init = function () {

    };

    //Go back one from <a onclick> events
    function goBack() {
        window.history.back();
    }

    THINGA.Tools = {
        goBack: goBack
    };

    init();

})();