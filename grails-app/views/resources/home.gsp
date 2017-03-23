<%--
  Created by IntelliJ IDEA.
  User: FULL-MB
  Date: 3/22/17
  Time: 7:22 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="base"/>
    <title>Home |</title>
    <meta name="description"
          content="Thingamajig is a noun used to refer to or address a person or thing whose name one has forgotten, does not know, or does not wish to mention.">

</head>

<body data-page="home">
<div class="container">
    <h1>Thingamajig</h1>

    <p>"one of those thingamajigs for keeping all the fireplace tools together"</p>

    <div class="row">
        <div class="col-sm-3">

        </div>
        <div class="col-sm-9">
            <div class="repos-list-container">
                <h3>Github Top Repos</h3>
                <g:render template="/templates/repos/list"/>
            </div>
        </div>
    </div>
</div>

</body>
</html>