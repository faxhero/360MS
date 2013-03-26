<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="init.jsp" %>
<html>
<head>
<title>个人办公</title>
<style type='text/css'>
body{
	background:#ffffff;
	background-color: #FFFFCC;
}
a{
	color:#000000;
	text-decoration:none;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<body>

<script language='JavaScript' src='person/person.js'></script>

<script language="JavaScript">


addtree('个人信息');
addtree('-个人信息');
addtree('--个人信息查询','个人信息/个人信息.html',target="mainFrame");
addtree('--个人信息修改','个人信息/个人信息修改.html',target="mainFrame");
addtree('日程安排');
addtree('-日程权限设置');
addtree('--权限设置设置','日程安排/set_reader.html',target="mainFrame");
addtree('-日程更新');
addtree('--添加日程','日程安排/add_data.html',target="mainFrame");
addtree('--编辑日程','日程安排/table.html',target="mainFrame");
addtree('-日程查询');
addtree('--日历查看','日程安排/查询页面.html',target="mainFrame");


addtree('名片夹');
addtree('-名片夹','名片夹/j-1.html',target="mainFrame");
addtree('公司通讯录');
addtree('-通讯录','通讯录/UntitledFrameset-2.html',target="mainFrame");
addtree('待办事件');
addtree('-代办','待办事项/消息主页面（有用）.html',target="mainFrame");
addtree('在线信息');
addtree('-在线信息','在线信息/首页.html',target="mainFrame");

addtree('个人文件夹')
addtree('-文件上传','个人文件夹/文件上传.html',target="mainFrame");

createtree();
</script>
</body>
</html>
