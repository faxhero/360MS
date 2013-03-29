<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/init.jsp"%>
<div class="row-fluid">
	<div class="span12">		
		<h3>我起草的任务</h3>  
		<form class="navbar-form pull-left form-inline">
			标题：<input class="input-large" type="text" placeholder="title">
			内容：<input class="input-large" type="text" placeholder="context">
			<button type="submit" class="btn btn-info">search</button>
			<button type="submit" class="btn">search</button>
		</form> 					
	</div>	
</div>
<br>
<div class="row-fluid">		
		<table class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<th>#</td>
				<th><strong>标题</strong></th>				
				<th><strong>申请人</strong></th>
				<th><strong>内容</strong></th>
				<th><strong>operate</strong></th>
			</tr>
			<tr>
				<td> 
					<label class="checkbox">
						<input type="checkbox">
					</label>
				</td>
				<td title="关于党组织的第一次代表大会">hy</td>
				<td>小光</td>				
				<td>2013-02-01</td>
				<td>
					<div class="btn-group">
	                	<button class="btn dropdown-toggle btn-info" data-toggle="dropdown"><i class="icon-wrench"></i>Action<span class="caret"></span></button>
	                   	<ul class="dropdown-menu">
	                   		<li><a href="#"><i class="icon-play"></i>发送</a></li>
	                       	<li><a href="#"><i class="icon-search"></i>查看</a></li>
	                  	   	<li><a href="#"><i class="icon-edit"></i>修改</a></li>
	                  	   	<li><a href="#"><i class="icon-trash"></i>删除</a></li>		                 
	                	</ul>
	              	</div>	
				</td>	
			</tr>
			<tr>
				<td>
					<label class="checkbox">
						<input type="checkbox">
					</label>
				</td>
				<td>关于党组织的第一次代表大会</td>
				<td>小宝</td>				
				<td>2013-02-01</td>
				<td>							                        
	                <div class="btn-group">
	                	<button class="btn dropdown-toggle" data-toggle="dropdown"><i class="icon-wrench"></i>Action<span class="caret"></span></button>
	                   	<ul class="dropdown-menu">
	                   		<li><a href="#"><i class="icon-play"></i>发送</a></li>
	                       	<li><a href="#"><i class="icon-search"></i>查看</a></li>
	                  	   	<li><a href="#"><i class="icon-edit"></i>修改</a></li>
	                  	   	<li><a href="#"><i class="icon-trash"></i>删除</a></li>		                 
	                	</ul>
	              	</div>		            	          
				</td>	
			</tr>
			<tr>
				<td>
					<label class="checkbox">
						<input type="checkbox">
					</label>
				</td>
				<td>关于党组织的第一次代表大会</td>
				<td>大龙</td>
				<td>2013-02-01</td>
				<td>
					<div class="btn-group">
	                	<button class="btn dropdown-toggle" data-toggle="dropdown"><i class="icon-wrench"></i>Action<span class="caret"></span></button>
	                   	<ul class="dropdown-menu">
	                   		<li><a href="#"><i class="icon-play"></i>发送</a></li>
	                       	<li><a href="#"><i class="icon-search"></i>查看</a></li>
	                  	   	<li><a href="#"><i class="icon-edit"></i>修改</a></li>
	                  	   	<li><a href="#"><i class="icon-trash"></i>删除</a></li>		                 
	                	</ul>
	              	</div>	 
				</td>	
			</tr>			
		</table>		
		<div class="pagination"> 
			<ul>
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><a href="#">9</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>	
	</div>	
</div>