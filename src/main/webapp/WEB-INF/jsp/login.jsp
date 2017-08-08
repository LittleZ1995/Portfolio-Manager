<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  <%String path = request.getContextPath(); %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

    <!-- Bootstrap -->
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="<%=path %>/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<%=path %>/css/custom.min.css" rel="stylesheet">
     <link href="<%=path %>/css/style.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
          
            <form action="login" method="post">
              <h1>Login Form</h1>
              <div>
                <input type="text"  name="account" id="account" class="form-control" placeholder="Account" required="" />
              </div>
              <div>
                <input type="password" name="password" id="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <input id="loginbtn" type="submit" value="Log in"/>
              </div>

              <div class="clearfix"></div>
         		<div class="separator">

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1>Portfolio System</h1>
                  <p>©2017 By Chen Tao & Leo & Chen Min & Helen</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
