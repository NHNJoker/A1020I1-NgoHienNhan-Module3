<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama resort</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/styleLogin.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
          integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>
<body>
<div class="limiter" id="login">
    <div class="container-login100"
         style="background-image:url(https://q-cf.bstatic.com/images/hotel/max1024x768/642/64261840.jpg)">
        <div class="container">
            <div class="row">
                <div class="col-md-6"></div>
                <div class="col-md-5 col-md-offset-1">
                    <div class="login_topimg"></div>
                    <div class="wrap-login100">
                        <form action="/login?actionUser=login" method="post" class="login100-form validate-form"><span class="login100-form-title "> Login </span>
                            <span class="login100-form-subtitle m-b-16"> to your account </span>
                            <div class="wrap-input100 validate-input m-b-16"
                                 data-validate="Valid email is required: ex@abc.xyz">
                                <input value="${userName}" class="input100" type="text" id="userName" name="userName" placeholder="Username"> <span
                                    class="focus-input100"></span>
                                <span class="symbol-input100"> <span class="glyphicon glyphicon-user"></span> </span>
                            </div>
                            <div class="wrap-input100 validate-input m-b-16" data-validate="Password is required">
                                <input class="input100" type="password" name="pass" placeholder="Password">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <span class="glyphicon glyphicon-lock"></span>
                                </span>
                            </div>
                            <label for="userName" class="text-danger">${msg}</label>
                            <div class="flex-sb-m w-full p-b-30">
                                <div class="form-check">
                                    <input class="form-check-input" id="ckb1" type="checkbox" name="remember-me">
                                    <label class="form-check-label" for="ckb1"> Remember me </label>
                                </div>
                                <div><a href="#" class="txt1"> Forgot Password? </a></div>
                            </div>
                            <div class="container-login100-form-btn p-t-25">
                                <button class="login100-form-btn"> Login</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Main layout-->
<!--footer-->
<div class="container-fluid mt-lg-5" style="background-color: #8e8b8b">
    <div class="row">
        <div class="col-lg-4">
            <h3 class="text-white mt-lg-5">BẢN ĐỒ</h3>
            <iframe class="w-100 h-75"
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.50245898014!2d108.24769741416945!3d16.039395344498725!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31420fdbc8cc38ef%3A0x9a6a3e31121225d2!2sFurama%20Resort%20Danang!5e0!3m2!1svi!2s!4v1619427748449!5m2!1svi!2s"
                    style="border:0;" allowfullscreen="" loading="lazy"></iframe>
        </div>

        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <h3 class="text-white mt-lg-5">Liên hệ</h3>
            <p>105 Võ Nguyên Giáp, Ngũ Hành Sơn, Đà Nẵng, Việt Nam</p>
            <p>Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666</p>
            <p>Email: reservation@furamavietnam.com * www.furamavietnam.com</p>
            <img src="img/world-hotel-F-new.png" class="w-100"/>
            <p>GDS-Codes: Amadeus-WWDADFUR, Apollo/Galileo-WW16236, SabreWW32771, Worldspan-WWDADFU</p>
        </div>
    </div>
    <div class="row text-center">
        <div class="col-lg-12">
            <p>© 2018 Furama Resort Danang.</p>
        </div>
    </div>
</div>
<!--footer-->
<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<!--js-->
</body>
</html>
