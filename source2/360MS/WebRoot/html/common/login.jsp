<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="init.jsp" %>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">		
		function $(id){
		    return document.getElementById(id);
		}
		function autoResizepic(){
			alert(jQuery('#fontzoom1'));
		    var bodywidth = $('fontzoom1').style.height;
		    bodywidth =document.body.scrollHeight;
		    var picTarget=$('fontzoom1').getElementsByTagName('img');    		    
		    if(picTarget.length>0){
		        for(var i =0;i<picTarget.length;i++){ 
	                if(picTarget[i].height>bodywidth)
	                    {picTarget[i].height=bodywidth;}		
	                if(picTarget[i].height<bodywidth)
	                    {picTarget[i].height=bodywidth;}            
		        }
		    }
		}
		function login(){
			
			$("loginForm").action="login.do";
			$("loginForm").submit();
		}
		function afterLoad(){
		}
		window.onresize=autoResizepic;
		autoResizepic();	
	</script>
	<style>
		input {
   			height:25px;
   			width:160px;
   			font-size:medium;
   			border-color:#ffffff;
 		} 
		*{margin:0;padding:0;}
		#fontzoom1{width:100%;overflow:hidden;}
	</style>
  </head>
  
  <body onload="afterLoad()">
	  <div id="fontzoom1"  align="center" style="width: 100%;height: 100%;position: absolute;z-index: 1">
	  <img src="html/image/login.jpg"/>   
	  </div>
	  <div style="text-align:center;top:70%;left:45%;margin:-150px 0 0 -400px;width:1000px;height:100px;border:1px;position: absolute;z-index: 2">
	  	<form name="loginForm" id="loginForm" action="login.do">
		  	<span id="userBtnName" style="font-size: 20">工号:&nbsp;&nbsp;</span><input type="text" name="usernumber" id="usernumber"/><br/><br/>
		  	<span id="pwdBtnName" style="font-size: 20">密码:&nbsp;&nbsp;</span><input type="password" name="passwd" id="passwd"/><br/><br/>
		  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  	<span id="userBtnName" style="font-size: 20">语言:&nbsp;&nbsp;</span>
		  	<select id="language" name="language">
		  		<option value="CN" selected>中文</option>
		  		<option value="EN">English</option>
		  	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  	<br>
		  	<br>
		  	<button id="loginBtnName" style="font-size: 20" onclick="login()">登录</button>
		  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  	<button id="resetBtnName" style="font-size: 20">重置</button>
	  	</form>	  	
	  </div>
  </body>
</html>
