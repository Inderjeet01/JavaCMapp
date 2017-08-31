<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GST Invoice</title>
    <link href="dist-4.0-css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap-3.3.6/dist/css/shop-homepage.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-title" style="text-align: center; font-size:xx-large ">
                    <p class="text-info">GST Invoice</p>
                </div>
                <div class="card-body">
                    <!--GST invoice code-->
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th >#</th>
                                <th>Customer Email</th>
                                <th >Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <td>1</td>
                            <%--User has to go through the login process otherwise emailValue will be null
                            e.g access the webpage directly with url pattern /CheckOut --%>
                            <td><% HttpSession httpSession = request.getSession();
                                String emailValue = (String) httpSession.getAttribute("emailCookie");
                            out.print(emailValue);
                            %></td>
                            <td><%= new Date()%></td>
                            <td></td>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer">

                </div>
            </div>
        </div>
    </div>

</div>


<!--Scripts-->
<script src="bootstrap-3.3.6/js/tests/vendor/jquery.min.js"></script>
<script src="bootstrap-3.3.6/dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.6/dist/js/custom.js"></script>

</body>
</html>