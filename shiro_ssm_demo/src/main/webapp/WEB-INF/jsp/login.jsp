<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" media="all" href="${pageContext.request.contextPath}/easyui/">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<title>用户登陆</title>
</head>
<body>

	<h1 align="center">用户登陆</h1>
	<h5 align="center">${error }</h5>
	<hr>
	<form action="${pageContext.request.contextPath}/login/login.action" method="post">
		<table border="1" align="center" width="50%" cellpadding="5">
			<tr>
				<td width="30%" align="right">用户名:</td>
				<td>
					<input type="text" id="username" name="username">
				</td>
			</tr>
			<tr>
				<td width="30%" align="right">密 &nbsp;&nbsp;码:</td>
				<td>
					<input type="text" id="userpwd" name="userpwd">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" id="register" value="注册">
					<input type="submit" id="loginBtn" value="登录">
				</td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		$(function(){
		    $("#loginBtn").click(function () {
				var username = $("#username").val();
				var userpwd = $("#userpwd").val();
                /**
				 * 验证用户名
                 */
                if(!username){
                    alert("用户名必填!");
                    $("#username").focus();//获取焦点
                    return ;
                }

                if(!userpwd){
                    alert("密码必填！");
                    $("#userpwd").focus();
                    return ;
				}

                /**
				 * ${pageContext.request.contextPath}/login/login.action
				 * 使用ajax提
				 */
				 /*$.ajax({
					// type: "post",
					url : "",
					data :{
                        "username":username,
                        "userpwd":userpwd
					},
					success:function (result) {
                        if (result) {
                            window.location.href = "list";
                            // alert("111")
                        } else {
                            alert("用户名或者密码错误!");
                        }
                    }
				})*/
            })

            $("#register").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/login/toRegister.action",
                    success:function (data) {
						if(data){
                            window.location.href="${pageContext.request.contextPath}/login/toRegister.action";
                            // alert("1111");
                        }else {
						    return;
						}
                    }
                })
            })
		})
	</script>
</body>
</html>