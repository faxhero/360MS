<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="init.jsp" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sign in &middot; Twitter Bootstrap</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/daterangepicker.css" />
    <style type="text/css">
      body {
        padding-top: 100px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
  </head>

  <body>
    <div class="navbar navbar-inverse">
      <div class="navbar-inner">
        <div class="container-fluid">          
          <h1 align="center"><font color="#ffffff">360°All Round Investigate Manager System</font></h1>         
        </div>
      </div>        
    </div>
    <div class="container">
      <form class="form-signin" action="login.do" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <div class="input-append">
          <input  name="dateInput" type="text"><i class="icon-calendar"></i>
        </div>
        <br>   
        用户名：<input type="text" class="input-block-level" name="usernumber"  placeholder="Email address">
        密码：<input type="password" class="input-block-level" name="passwd" placeholder="Password">        
        <select name="language">
        	<option value="cn">中文</option>
        	<option value="en">English</option>
        </select>        
        <br/>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>
    </div> <!-- /container -->       
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script> 
  	<script type="text/javascript" src="js/date.js"></script>
  	<script type="text/javascript" src="js/daterangepicker.js"></script>
  	<script type="text/javascript">
  	$(document).ready(function() {
  	   $("input[name='dateInput']").daterangepicker();
  	});
</script>
  </body>
</html>

