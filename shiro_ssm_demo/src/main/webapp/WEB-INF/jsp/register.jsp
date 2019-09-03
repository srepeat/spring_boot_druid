<%--
  Created by IntelliJ IDEA.
  User: 鲜磊
  Date: 2019/9/3
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h1 align="center">用户注册</h1>
<h5 align="center">${error }</h5>
<hr>
<form action="${pageContext.request.contextPath }/login/register.action" method="post">
    <table border="1" align="center" width="50%" cellpadding="5">
        <tr>
            <td width="30%" align="right">用户名:</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td width="30%" align="right">密 &nbsp;&nbsp;码:</td>
            <td>
                <input type="password" name="userpwd">
            </td>
        </tr>
        <tr>
            <td width="30%" align="right">性 &nbsp;&nbsp;别:</td>
            <td>
                <input type="radio" name="sex" value="0" checked="true">女
                <input type="radio" name="sex" value="1">男
            </td>

        </tr>
        <tr>
            <td width="30%" align="right">地 &nbsp;&nbsp;址:</td>
            <td>
                <input type="text" name="address">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="提交注册">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
