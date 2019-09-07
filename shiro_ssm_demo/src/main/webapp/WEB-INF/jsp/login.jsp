<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/easyui/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/easyui/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/easyui/css/nprogress.css">
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/easyui/css/nprogress.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>

	<style type="text/css">
		.form-control{
			width: 25%;
			/*margin-top: 15px;*/
		}
		.but_sub{
			margin-top: 10px;
		}
	</style>

<title>用户登陆</title>
</head>
<body class="login">
	<div align="center">
		<a class="hiddenanchor" id="signup"></a>
		<a class="hiddenanchor" id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form method="post" action="${pageContext.request.contextPath}/login/login.action">
						<h1>shiro学习demo案例</h1>
						<div style="color: red;align:center">${error}</div>
						<div>
							<label>用户名</label>
							<input type="text" name="username" class="form-control" placeholder="username" required="" />
						</div>
						<div>
							<label>密 &nbsp;&nbsp;码</label>
							<input type="password" name="userpwd" class="form-control" placeholder="userpwd" required="" />
						</div>
						<div class="but_sub">
							<button class="btn btn-default" id="loginBtn" type="submit">登录</button>
							<button class="btn btn-default" id="register" type="button">注册</button>
						</div>
						<div class="clearfix"></div>

						<div class="separator">
							<div class="clearfix"></div>
							<br />

							<div>
								<h1><i class="fa fa-paw"></i> 江苏工程学院</h1>
								<p>©2019 All Rights Reserved. 江苏工程学院</p>
							</div>
						</div>
					</form>
				</section>
			</div>

		</div>
	</div>

	<script type="text/javascript">

        /**
		 * 跳转注册页面
         */
		$(function () {
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