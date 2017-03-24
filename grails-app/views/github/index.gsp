<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="base"/>
    <title>Github Thingamajig | Junkin</title>
    <meta name="description"
          content="Thingamajig is a noun used to refer to or address a person or thing whose name one has forgotten, does not know, or does not wish to mention.">

</head>

<body data-page="home">
<header>
    <h1>Thingamajig</h1>

    <p>"${randomQuote.content}"</p>
</header>

<div class="container">
    <h2><span class="fa fa-github fa-1x"></span>&nbsp;Github Repos</h2>

    <p>View the top rated repos on Github and their latest commits.</p>

    <div class="row">
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item text-muted" contenteditable="false"><span
                        class="fa fa-bar-chart-o fa-1x">&nbsp;Public Repos</span>
                </li>
                <li class="list-group-item flex space-between">
                    <strong class="">Date</strong>
                    <span class="text-right number">
                        <g:formatDate date="${new Date()}" type="datetime" style="MEDIUM" timeStyle="SHORT"/>
                    </span>
                </li>
                <li class="list-group-item flex space-between">
                    <strong class="">Total</strong>
                    <span class="text-right">
                        ${reposTotal}
                    </span>
                </li>

                <li class="list-group-item flex space-between">
                    <strong>Showing</strong>
                    <span class="text-right">
                        ${repos.size()}
                    </span>
                </li>

                <li class="list-group-item flex space-between">
                    <strong>Load Time</strong>
                    <span class="text-right page-load-time">

                    </span>
                </li>

            </ul>

        </div>

        <div class="col-sm-9">
            <div class="top-repos-list-container">
                <g:render template="/templates/repos/list"/>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="voteModal" role="dialog" data-id="">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>

            <div class="modal-body">
                <g:form name="repo-vote-form" class="repo-vote-form" controller="github"
                        action="vote">
                    <div class="form-group">
                        <textarea name="comments" class="form-control comments" placeholder="Tell us what you think"
                                  rows="7"
                                  cols="50" required=""></textarea>
                        <input type="hidden" name="vote" class="vote-value" placeholder="Vote"/>
                        <input type="hidden" name="id" class="repo-id" placeholder="id"/>
                        <input type="hidden" name="name" class="repo-name" placeholder="id"/>
                    </div>
                </g:form>
                <button class="vote-button down btn btn-danger btn-sm">
                    <span class="fa fa-thumbs-down"></span> Down Vote
                </button>

                <button class="vote-button up btn btn-info btn-sm">
                    <span class="fa fa-thumbs-up"></span> Up Vote
                </button>
            </div>

        </div>

    </div>
</div>

</body>
</html>
