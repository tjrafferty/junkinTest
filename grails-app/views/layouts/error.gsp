<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="MyPetCerts"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" sizes="64x64" href="${assetPath(src: 'favicons/junkin-thingamajig-favicon.ico')}" type="image/png">
    <asset:stylesheet src="application.less"/>
    <asset:javascript src="application.js"/>


    <g:layoutHead/>

</head>

<body data-page="${g.pageProperty(name: 'body.data-page')}" data-id="${g.pageProperty(name: 'body.data-id')}">

<div class="main">

    <%-- Layout Body --%>
    <main>
        <g:layoutBody/>
    </main>
    <%-- Render Footer --%>

</div>
</body>
</html>