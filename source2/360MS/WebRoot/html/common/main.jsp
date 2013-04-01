<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="init.jsp"%>
<html lang="en">
  <head>    
    <title>Bootstrap, from Twitter</title>
    <base href="<%=basePath%>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content="nero"/>
 
    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <style type="text/css">
      body {
        padding-top: 120px;
        padding-bottom: 20px;
      }
      /* 菜单位置*/
      .sidebar-nav {
        padding: 9px 0;
      }
 
      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet"/>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">          
          <h1 align="center"><font color="#ffffff">360°All Round Investigate Manager System</font></h1>          
          <div class="nav-collapse collapse">
            <a class="brand" href="#">360ms</a>           
            <ul class="nav">
              <li><a href="main.html">Home</a></li>              
            </ul>
             <form class="navbar-form pull-right">
              <input class="search-query" type="text" placeholder="Search"/>             
              <button type="submit" class="btn"><i class="icon-search"></i>search</button>
            </form>
             <p class="navbar-text pull-right">
              Logged in as :<a href="#">nero </a>
              /<a href="#">login off</a>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>              
            </p>
          </div>
        </div>        
      </div>
    </div>
 
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">个人工作台</li>
              <li><a href="javascript:;" onclick="loadCenterHtml('html/workStation/myDraft.jsp')">我起草的任务</a></li>
              <li><a href="javascript:;" onclick="loadCenterHtml('html/workStation/mySend.jsp')">我发起的任务</a></li>
              <li><a href="javascript:;" onclick="loadCenterHtml('html/workStation/myWait.jsp')">待我处理的任务</a></li>
              <li><a href="javascript:;" onclick="loadCenterHtml('html/workStation/myApproved.jsp')">经我处理的任务</a></li>             
              <li class="nav-header">模板管理</li>
              <li><a href="javascript:;">360模板</a></li>
              <li><a href="javascript:;">满意度模板</a></li>
              <li><a href="javascript:;">自定义模板</a></li>              
              <li class="nav-header">数据字典</li>
              <li><a href="javascript:;">类型1</a></li>
              <li class="nav-header">系统管理</li>
              <li><a href="javascript:;" onclick="loadCenterHtml('html/user/userManger.jsp')">用户管理</a></li>
              <li><a href="javascript:;" onclick="loadCenterHtml('html/systemManage/organization.jsp')">组织管理</a></li>              
              <li><a href="#">岗位管理</a></li>
              <li><a href="#">菜单管理</a></li>             
            </ul>
          </div><!--/.well -->
        </div><!--/span-->        
        <div class="span10" id="maincenter">
          <div class="hero-unit">
            <h1>Hello!Welcome to 360 Manager System home</h1>
            <p>360MS的全称是360°All Round Investigate Manager System，是企业内部管理系统的重要组成部分，是通过信息化得方式来对企业内部的各个方面进行调查评估，同时也是员工进行自我评价的一种平台，系统包括满意度（匿名调查），员工评估（实名调查），以及自定义调查等多项功能，通过这种调查可以更好的了解企业的内部情况，更好的管理企业，更好团结整个企业团队</p>
            <p><a href="javascript:;" class="btn btn-primary btn-large" onclick="loadCenterHtml('html/workStation/myWait.jsp')">处理待办 &raquo;</a></p>              
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->      
      <hr>      
      <footer>
        <p>&copy; Company max egg 2013</p>
      </footer>
 
    </div><!--/.fluid-container-->
 
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript">
      function loadCenterHtml(path){       	        
        $.ajax({
            type: "post",
            url: path,
            data: "",
            success: function (html) {            	                        
                $("#maincenter").html(html);
            }
        });        
      }
    </script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>    
    
  </body>
</html>

