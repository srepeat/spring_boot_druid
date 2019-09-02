<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
</head>
<body>

	<h1 align="center">用户登陆</h1>
	<h5 align="center">${error }</h5>
	<hr>
	<form action="${pageContext.request.contextPath }/login/login.action" method="post">
		<table border="1" align="center" width="50%" cellpadding="5">
			<tr>
				<td width="30%" align="right">用户名:</td>
				<td>
					<input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td width="30%" align="right">密码:</td>
				<td>
					<input type="text" name="userpwd">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>