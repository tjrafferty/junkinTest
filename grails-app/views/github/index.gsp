<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="base"/>
    <title>Github Thingamajig | Junkin</title>
    <meta name="description"
          content="Thingamajig is a noun used to refer to or address a person or thing whose name one has forgotten, does not know, or does not wish to mention.">

</head>

<body data-page="home">
<header><h1>Thingamajig</h1>

    <p>"one of those thingamajigs for keeping all the fireplace tools together"</p></header>

<div class="container">
    <h2><span class="fa fa-github fa-1x"></span>&nbsp;Github Repos</h2>

    <p>View the top rated repos on Github and their latest commits.</p>

    <div class="row">
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item text-muted" contenteditable="false">Title</span>
                </li>
                <li class="list-group-item flex space-between">
                    <strong class="">Date</strong>
                    <span class="text-right number">
                        <g:formatDate date="${new Date()}" type="datetime" style="MEDIUM" timeStyle="SHORT"/>
                    </span>
                </li>
                <li class="list-group-item flex space-between">
                    <strong class="">Something</strong>
                    <span class="text-right">
                        Foo
                    </span>
                </li>

                <li class="list-group-item flex space-between">
                    <strong>Something Else</strong>
                    <span class="text-right">
                        Bar
                    </span>
                </li>

            </ul>

            <ul class="list-group">
                <li class="list-group-item text-muted" contenteditable="false">Title</span>
                </li>
                <li class="list-group-item flex space-between">
                    <strong class="">Date</strong>
                    <span class="text-right number">
                        <g:formatDate date="${new Date()}" type="datetime" style="MEDIUM" timeStyle="SHORT"/>
                    </span>
                </li>
                <li class="list-group-item flex space-between">
                    <strong class="">Something</strong>
                    <span class="text-right">
                        Foo
                    </span>
                </li>

                <li class="list-group-item flex space-between">
                    <strong>Something Else</strong>
                    <span class="text-right">
                        Bar
                    </span>
                </li>

            </ul>
        </div>

        <div class="col-sm-9">
            <div class="top-repos-list-container">
                <h3><span
                        class="fa fa-bar-chart-o fa-1x">&nbsp;Top Rated Java Repos (${repos.size() + " of " + reposTotal})</span>
                </h3>

                <g:render template="/templates/repos/list"/>
            </div>
            <hr/>

            <div class="other-repos-list-container">
                <h3><span class="fa fa-star fa-1x">&nbsp;Other</span></h3>

            </div>
        </div>
    </div>
</div>

</body>
</html>
