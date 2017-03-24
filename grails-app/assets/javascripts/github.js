$(document).ready(function (e) {

    if ($('body').data('page') === "home") {

        /*On Submit - Post the vote form async. */
        $(document).on("submit", ".repo-vote-form", function (e) {
            e.preventDefault();

            var $form = $(this);
            var action = $form.attr('action');
            var data = $form.serialize();
            $.ajax({
                type: "POST",
                url: action,
                data: data,
                success: function (response) {
                    if (response.success) {
                        $('#voteModal').modal('toggle');
                        var vote = response.vote.vote;
                        var comment = response.vote.comment;
                        var repo = $('*[data-id="' + response.id + '"]');
                        var voteList = repo.find('ul.votes-list');
                        var listData;
                        if (!comment) {
                            comment = 'No need to comment my thumb says it all ;-)'
                        }
                        if (vote == 1) {
                            listData = "<p><span class='fa fa-thumbs-up green'></span>&nbsp;" + comment + "</p>";
                        } else {
                            listData = "<p><span class='fa fa-thumbs-down red'></span>&nbsp;" + comment + "</p>";
                        }
                        voteList.append('<li>' + listData + '</li>');
                        voteList.children('li.no-vote').remove()
                        $form[0].reset();
                    } else {
                        // bad stuff happened
                        console.log("Houston we have a problem.")
                    }
                }
            });
        });

        /*On Click - Grab the latest commit from github */
        $(document).on("click", ".show-commit", function (e) {
            var $this = $(this);
            var repo = $this.closest('li.repo-data');
            var owner = repo.data("owner");
            var name = repo.data("name");
            var data = {
                owner: owner,
                name: name
            }

            $.ajax({
                url: '/github/getLatestCommit',
                data: data,
                cache: false,
                success: function (response) {
                    var commit = response.commit;
                    $this.closest('span.latest-commit').html(commit)
                },
                error: function (response) {

                }
            });
        });

        /*On Click - Set the vote and submit the form */
        $(document).on("click", ".vote-button", function (e) {
            var $this = $(this);
            var vote = null
            if ($this.hasClass("up")) {
                vote = 1
            } else if ($this.hasClass("down")) {
                vote = -1
            }
            $('.vote-value').val(vote);

            $('.repo-vote-form').submit();

        });

        /*Set data attribute and title on open*/
        $('#voteModal').on('shown.bs.modal', function (e) {
            $(e.relatedTarget).one('focus', function (e) {
                $(this).blur();
            });
            var repo = $(e.relatedTarget).closest('li.repo-data');
            var owner = repo.data("owner");
            var name = repo.data("name");
            var repoId = repo.data("id");

            //populate the textbox
            $(e.currentTarget).find('.modal-title').text(name);
            $(e.currentTarget).data("id", repoId)
            $(e.currentTarget).find('input[name="id"]').val(repoId);
            $(e.currentTarget).find('input[name="name"]').val(name);

        })

    }
});