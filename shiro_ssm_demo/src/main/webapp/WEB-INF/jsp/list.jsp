<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<h1 align="center">用户列表</h1>
<hr>
<table id="dg"></table>
    <div id="toolbar">
    	<shiro:hasPermission name="user:create">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
       </shiro:hasPermission>
       <shiro:hasPermission name="user:update">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改用户</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:delete">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
  		 </shiro:hasPermission>
    </div>
</body>
<script type="text/javascript">
//初始化表格数据
$("#dg").datagrid({
	title:'用户列表',
	toolbar:'#toolbar',//工具栏
	iconCls:'icon-save',
	width:'100%',//宽度
	pagination:true, //是否使用分页
	rownumbers:true,//是否显示行号
	fitColumns:true,//是否平分列宽
	singleSelect:true,//是否支持单行选中
	url:'${pageContext.request.contextPath }/user/loadAllUser.action',//数据接口
	columns:[[
           {field:'id',title:'ID',align:'center',width:100,hidden:true},
           {field:'name',title:'用户名',width:100,align:'center',sortable:true},
           {field:'userpwd',title:'密码',width:100,align:'center'},
           {field:'userpwd',title:'密码',width:100,align:'center'},
           {field:'address',title:'地址',width:100,align:'center'},
         {field:'sex',title:'性别',width:100,align:'center',templet: function(res) {
                return res.sex == 1 ? '男' : '女';
            }}
	    ]]
});
</script>
</html>