/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-06 13:58:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/css/bootstrap.min.css\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/css/font-awesome.min.css\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/css/nprogress.css\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/css/nprogress.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.form-control{\r\n");
      out.write("\t\t\twidth: 25%;\r\n");
      out.write("\t\t\t/*margin-top: 15px;*/\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.but_sub{\r\n");
      out.write("\t\t\tmargin-top: 10px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\r\n");
      out.write("<title>用户登陆</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login\">\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<a class=\"hiddenanchor\" id=\"signup\"></a>\r\n");
      out.write("\t\t<a class=\"hiddenanchor\" id=\"signin\"></a>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"login_wrapper\">\r\n");
      out.write("\t\t\t<div class=\"animate form login_form\">\r\n");
      out.write("\t\t\t\t<section class=\"login_content\">\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login/login.action\">\r\n");
      out.write("\t\t\t\t\t\t<h1>shiro学习demo案例</h1>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"color: red;align:center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<label>用户名</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"username\" required=\"\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<label>密 &nbsp;&nbsp;码</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"userpwd\" class=\"form-control\" placeholder=\"userpwd\" required=\"\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"but_sub\">\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-default\" id=\"loginBtn\" type=\"submit\">登录</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-default\" id=\"register\" type=\"button\">注册</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"separator\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1><i class=\"fa fa-paw\"></i> 江苏工程学院</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>©2019 All Rights Reserved. 江苏工程学院</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("\t\t * 跳转注册页面\r\n");
      out.write("         */\r\n");
      out.write("\t\t$(function () {\r\n");
      out.write("            $(\"#register\").click(function () {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login/toRegister.action\",\r\n");
      out.write("                    success:function (data) {\r\n");
      out.write("                        if(data){\r\n");
      out.write("                            window.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login/toRegister.action\";\r\n");
      out.write("                            // alert(\"1111\");\r\n");
      out.write("                        }else {\r\n");
      out.write("                            return;\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
