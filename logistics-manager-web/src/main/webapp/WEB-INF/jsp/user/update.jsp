<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="/user/saveOrUpdate" method="post">
	    <ul class="forminfo">
	    <li><label>用户名</label><input name="user.userName" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
	    <li><label>真实姓名</label><input name="user.realName" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
	    <li><label>密码</label><input name="user.password" type="password" class="dfinput" /><i>不能超过30个字符</i></li>
	    <li><label>确认密码</label><input name="confirmPassword" type="password" class="dfinput" /><i>不能超过30个字符</i></li>
	    <li><label>邮箱</label><input name="user.email" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
	    <li><label>手机</label><input name="user.phone" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
	    <li>
	    	<label>分配角色</label>
	    	<c:forEach items="${roles }" var="role">
		    	<input name="roleIds" type="checkbox" value="${role.roleId }"/>${role.roleName }&nbsp;&nbsp;
	    	</c:forEach>
	    </li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>