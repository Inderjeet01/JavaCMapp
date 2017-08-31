<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

    <link href="dist-4.0-css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap-3.3.6/dist/css/styles.css" rel="stylesheet">
</head>
<style>
    .login-bg{
        background:  url('images/Headphones.jpg') no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        height: 100%;
    }
</style>
<body class="login-bg" >
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Logo -->
                <div class="logo">
                    <h1 style="text-align: center"><a href="index.html">Customer Management</a></h1>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin: 0 auto">
            <div class="login-wrapper">
                <div class="box">
                    <div class="content-wrap">
                        <h6>Register</h6>
                        <form action="RegistrationServlet" method="post">
                        <input class="form-control" type="text"  max="30" id="customeNameID" placeholder="Name" name="customerName">
                        <input class="form-control"  type="email" max="25"id="customerEmailID" placeholder="Email" name="customerEmail">
                        <input class="form-control" type="password" max="30"placeholder="Password" name="customerPassword">
                        <input class="form-control" type="text" max="150"placeholder="Address" name="customerAddress">
                        <input class="form-control" type="text" max="15" placeholder="Date of Birth" name="customerDateOfBirth">

                            <input class="btn btn-success" type="submit" value="Submit" ></input>

                        </form>
                    </div>
                </div>

                <div class="already">
                    <p class="text-white">Have an account already?</p>
                    <a href="LoginPage.jsp" style="color: #0fa6bc;">Login</a>
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