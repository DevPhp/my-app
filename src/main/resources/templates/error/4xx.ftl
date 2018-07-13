<html>
<head>
    <title>Uhoh</title>
</head>
<body>
<div><h1>${status + ' ' + error} </h1></div>
<div class="rt-container">

    <div class="container well">
        <div>
            <#if status == 404>
                <div><p>Your requested content was not found!</p></div>
            </#if>
        </div>
        <div class="rt-error-title">
            <p>
                There should probably descriptive verbiage here...
            </p>
        </div>
        <div class=""><a href="/" class="btn btn-danger"><span>Take Me Home</span></a></div>
    </div>
    <div class="clear"></div>
</div></body>
</html>
