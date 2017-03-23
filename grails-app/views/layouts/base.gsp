<%--
  Created by IntelliJ IDEA.
  User: FULL-MB
  Date: 3/22/17
  Time: 6:55 PM
--%>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="MyPetCerts"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" sizes="64x64" href="${assetPath(src: 'favicons/junkin-thingamajig-favicon.ico')}" type="image/png">

    <%--<link href='http://fonts.googleapis.com/css?family=Ubuntu:300, 400' rel='stylesheet' type='text/css'>--%>

    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

    <%-- Layout Head--%>
    <g:layoutHead/>
</head>

<body class="${g.pageProperty(name: 'body.class')}" data-page="${g.pageProperty(name: 'body.data-page')}"
      data-id="${g.pageProperty(name: 'body.data-id')}">

<div class="main">
    <%-- Header --%>
    <g:render template="/templates/header"/>
    <!-- /header -->

    <%-- Layout Body --%>
    <main>
        <g:layoutBody/>
    </main>

    <%-- Render Footer --%>
    <g:render template="/templates/footer"/>

</div>
</body>
</html>
