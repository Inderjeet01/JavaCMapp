<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="dist-4.0-css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap-3.3.6/dist/css/styles.css" rel="stylesheet">
</head>
<style>

    .full {
        background: url('images/Headphones3.jpg') no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
        height: 100%
    }

</style>

<body class="login-bg full">
<div class="header">
    <div class="container " style="text-align: center">
        <div class="row">
            <div class="col-md-12">
                <!-- Logo -->
                <div class="logo">
                    <h1><a href="index.html">Customer Management</a></h1>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin:0 auto">
            <div class="login-wrapper">
                <div class="box">
                    <div class="content-wrap">
                        <h6>Sign In</h6>
                        <div class="social">
                            <a class="face_login" href="#">
	                                <span class="face_icon">
	                                    <img src="images/facebook.png" alt="fb">
	                                </span>
                                <span class="text">Sign in with Facebook</span>
                            </a>
                            <div class="division">
                                <hr class="left">
                                <span>or</span>
                                <hr class="right">
                            </div>
                        </div>
                        <form action="LoginServlet" method="post">
                            <input class="form-control" id="customerEmailID" type="email" name="customerEmail"
                                   placeholder="E-mail address">
                            <input class="form-control" id="customerPasswordID" type="password" name="customerPassword"
                                   placeholder="Password">
                            <input type="submit" value="Login" class="btn btn-success">

                        </form>
                    </div>
                </div>

                <div class="already">
                    <p class="text-white">Don't have an account yet?</p>
                    <a href="Registration.jsp" style="color: #1dc1da">Sign Up</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var emailVal = document.getElementById("customerEmailID");
if(emailVal.checkValidity()){
    document.getElementById("customerEmailID").innerHTML=emailVal.validationMessage;

}
</script>
<script src="bootstrap-3.3.6/js/tests/vendor/jquery.min.js"></script>
<script src="bootstrap-3.3.6/dist/js/custom.js"></script>
</body>
</html>