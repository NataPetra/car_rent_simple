<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/password.css" rel="stylesheet">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<div class="bg">
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                            <form method="post" action="${pageContext.request.contextPath}/registration.action">

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <input type="text" name="firstName" id="firstName" class="form-control form-control-lg" />
                                            <label class="form-label" for="firstName">First Name</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <input type="text" name="lastName" id="lastName" class="form-control form-control-lg" />
                                            <label class="form-label" for="lastName">Last Name</label>
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 d-flex align-items-center">

                                        <div class="form-outline datepicker w-100">
                                            <input type="text" name="birthDay" class="form-control form-control-lg" id="birthDay" placeholder="1992-07-17"/>
                                            <label for="birthDay" class="form-label">Birthday</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <input type="tel" name="phoneNumber" id="phoneNumber" class="form-control form-control-lg" placeholder="+375(44)7204206"/>
                                            <label class="form-label" for="phoneNumber">Phone Number</label>
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <input type="email" name="email" id="email" class="form-control form-control-lg" required/>
                                            <label class="form-label" for="email">Email</label>
                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="password" class="form-control form-control-lg"
                                                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required/>
                                            <label class="form-label" for="password">Password</label>
                                        </div>

                                        <div id="message">
                                            <h3>Password must contain the following:</h3>
                                            <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
                                            <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
                                            <p id="number" class="invalid">A <b>number</b></p>
                                            <p id="length" class="invalid">Minimum <b>8 characters</b></p>
                                        </div>

                                        <script>
                                            var myInput = document.getElementById("psw");
                                            var letter = document.getElementById("letter");
                                            var capital = document.getElementById("capital");
                                            var number = document.getElementById("number");
                                            var length = document.getElementById("length");

                                            // When the user clicks on the password field, show the message box
                                            myInput.onfocus = function() {
                                                document.getElementById("message").style.display = "block";
                                            }

                                            // When the user clicks outside of the password field, hide the message box
                                            myInput.onblur = function() {
                                                document.getElementById("message").style.display = "none";
                                            }

                                            // When the user starts to type something inside the password field
                                            myInput.onkeyup = function() {
                                                // Validate lowercase letters
                                                var lowerCaseLetters = /[a-z]/g;
                                                if(myInput.value.match(lowerCaseLetters)) {
                                                    letter.classList.remove("invalid");
                                                    letter.classList.add("valid");
                                                } else {
                                                    letter.classList.remove("valid");
                                                    letter.classList.add("invalid");
                                                }

                                                // Validate capital letters
                                                var upperCaseLetters = /[A-Z]/g;
                                                if(myInput.value.match(upperCaseLetters)) {
                                                    capital.classList.remove("invalid");
                                                    capital.classList.add("valid");
                                                } else {
                                                    capital.classList.remove("valid");
                                                    capital.classList.add("invalid");
                                                }

                                                // Validate numbers
                                                var numbers = /[0-9]/g;
                                                if(myInput.value.match(numbers)) {
                                                    number.classList.remove("invalid");
                                                    number.classList.add("valid");
                                                } else {
                                                    number.classList.remove("valid");
                                                    number.classList.add("invalid");
                                                }

                                                // Validate length
                                                if(myInput.value.length >= 8) {
                                                    length.classList.remove("invalid");
                                                    length.classList.add("valid");
                                                } else {
                                                    length.classList.remove("valid");
                                                    length.classList.add("invalid");
                                                }
                                            }
                                        </script>

                                    </div>
                                </div>

                                <div class="mt-4 pt-2">
                                    <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="${pageContext.request.contextPath}/login.view"
                                                                                                        class="fw-bold text-body"><u>Login here</u></a></p>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
