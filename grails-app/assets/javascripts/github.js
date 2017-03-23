$(document).ready(function (e) {

    if ($('body').data('page') === "home") {

        $(document).on("submit", ".repo-comment-form", function (e) {

        });

        $(document).on("click", ".vote-button", function (e) {
            var repoId = $(this).closest('li.repo-data').data("id");
           // var repoId = repo
            console.log(repoId)
            var vote = null
            if ($(this).hasClass("up")) {
                vote = 1
            } else if ($(this).hasClass("down")) {
                vote = -1
            }

            $.ajax({
                url: '/github/vote',
                data: {phrase: params.phrase},
                cache: false,
                success: function (response) {
                    $(_listSelector).replaceWith(response);
                    var count = $(_listSelector).data('count');
                    $('.page-header span.number').text(count)
                    //MPC.timeService.refresh();
                },
                error: function (response) {

                }
            });

        });
    }
});