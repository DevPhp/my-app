<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Rba</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="/public/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/public/css/layout.css">
    

  </head>

<body>
  <div class="loginpage">
      <div class="">
      <img src='/public/images/biglogo.png'>
<h2>(Prototype) Financial Reporting Suite</h2>
<h5 >
    <p>Date and Time: <span id="datetime"></span></p>

    <script>
        var dt = new Date();
        document.getElementById("datetime").innerHTML = dt.toLocaleString();
    </script>
</h5>
<div class="alert"><p id="loginWarning" class="lead" style="color: red; display:none;">Bad login attempt.</p></div>
      <form id="loginForm">
          <div class="form-group row">
              <label for="" class="col-sm-3 col-form-label">Username</label>
              <div class="col-sm-9">
                   <input type="text" class="form-control" id="username" placeholder=" Username" aria-describedby="basic-addon1">
              </div>
          </div>
          <div class="form-group row">
              <label for="" class="col-sm-3 col-form-label">Password</label>
              <div class="col-sm-9">
                  <input type="password" class="form-control" id="password" placeholder=" Password" aria-describedby="basic-pw">
              </div>
          </div>
          <div class="control-label">
           <input type="submit" class="btn btn-primary" id="loginSubmitBtncc" value="Login" align="center"/>
           </div>
      </form>
          </div>
  </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/public/js/jquery-3.2.1.min.js"></script>
    <script src="/public/js/popper.min.js"></script>
    <script src="/public/js/bootstrap.min.js"></script>
  </body>
<script>
    $("form#loginForm").submit(function(e) {
        e.preventDefault();
        attemptLogin();
    });
    function attemptLogin() {
        $("p#failuremsg").css("display","none");
        const username = $("input#username").val();
        const password = $("input#password").val();
        const creds = {username: username, password: password};
        const loginReq = jQuery.ajax({url:"/auth/generate-token", contentType: "application/json; charset=utf-8",
            dataType: "json", method:"POST", json:true,data:JSON.stringify(creds),
            statusCode: {
                401: function() {
                    $("p#loginWarning").css("display","block");
                }
            }, success: function() {
                window.location.reload();
            }
        });

    }
</script>

</html>
