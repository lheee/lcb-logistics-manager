<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js"></script>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">用户管理</a></li>
			<li><a href="#">信息列表</a></li>
		</ul>
	</div>
	<div class="rightinfo">

		<div class="tools">
			<ul class="toolbar">
				<li class="click1"><a href="/user/userUpdate"><span><img
							src="/images/t01.png" /></span>添加</a></li>
				<li class="click"><a href="#"><span><img
							src="/images/t02.png" /></span>修改</a></li>
				<li><span><img src="/images/t03.png" /></span>删除</li>
				<li><span><img src="/images/t04.png" /></span>统计</li>
			</ul>
			<ul class="toolbar1">
				<li><span><img src="/images/t05.png" /></span>设置</li>
			</ul>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>编号<i class="sort"><img src="/images/px.gif" /></i></th>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>密码</th>
					<th>邮箱</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="user">
					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.realName }</td>
						<td>${user.password }</td>
						<td>${user.email }</td>
						<td>${user.phone }</td>

						<td><a href="/user/userUpdate?id=${user.userId }"
							class="tablelink"><label>修改</label></a> 
							<!-- 删除之前先确定 -->
							<a href="javascript:void(0)" onclick="deleteUser(${user.userId})" class="tablelink"> 删除</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
	<script type="text/javascript">
		<!-- 是否确定删除当前记录 -->
		function deleteUser(id){
			if(window.confirm("确定要删除当前记录么")){
				location.href="/user/delete?id="+id;
			}
		}
	
		$(document).ready(function() {
			$(".click").click(function() {
				/* 将jQuery对象转换为js原生对象 */
				$(".tablelink")[0].click();
			});
		
		});
		
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>