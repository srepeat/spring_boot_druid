/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-04 06:25:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Basic Form - jQuery EasyUI Demo</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/themes/default/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/themes/icon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/demo/demo.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h2>欢迎来到注册页面</h2>\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin:20px 0;\"></div>\r\n");
      out.write("<div class=\"easyui-panel\" title=\"New Topic\" style=\"width:100%;max-width:400px;padding:30px 60px;\">\r\n");
      out.write("    <form id=\"ff\" method=\"post\">\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"name\" style=\"width:100%\" data-options=\"label:'Name:',required:true\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"email\" style=\"width:100%\" data-options=\"label:'Email:',required:true,validType:'email'\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"subject\" style=\"width:100%\" data-options=\"label:'Subject:',required:true\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <input class=\"easyui-textbox\" name=\"message\" style=\"width:100%;height:60px\" data-options=\"label:'Message:',multiline:true\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"margin-bottom:20px\">\r\n");
      out.write("            <select class=\"easyui-combobox\" name=\"language\" label=\"Language\" style=\"width:100%\"><option value=\"ar\">Arabic</option><option value=\"bg\">Bulgarian</option><option value=\"ca\">Catalan</option><option value=\"zh-cht\">Chinese Traditional</option><option value=\"cs\">Czech</option><option value=\"da\">Danish</option><option value=\"nl\">Dutch</option><option value=\"en\" selected=\"selected\">English</option><option value=\"et\">Estonian</option><option value=\"fi\">Finnish</option><option value=\"fr\">French</option><option value=\"de\">German</option><option value=\"el\">Greek</option><option value=\"ht\">Haitian Creole</option><option value=\"he\">Hebrew</option><option value=\"hi\">Hindi</option><option value=\"mww\">Hmong Daw</option><option value=\"hu\">Hungarian</option><option value=\"id\">Indonesian</option><option value=\"it\">Italian</option><option value=\"ja\">Japanese</option><option value=\"ko\">Korean</option><option value=\"lv\">Latvian</option><option value=\"lt\">Lithuanian</option><option value=\"no\">Norwegian</option><option value=\"fa\">Persian</option><option value=\"pl\">Polish</option><option value=\"pt\">Portuguese</option><option value=\"ro\">Romanian</option><option value=\"ru\">Russian</option><option value=\"sk\">Slovak</option><option value=\"sl\">Slovenian</option><option value=\"es\">Spanish</option><option value=\"sv\">Swedish</option><option value=\"th\">Thai</option><option value=\"tr\">Turkish</option><option value=\"uk\">Ukrainian</option><option value=\"vi\">Vietnamese</option></select>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <div style=\"text-align:center;padding:5px 0\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"submitForm()\" style=\"width:80px\">Submit</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"clearForm()\" style=\"width:80px\">Clear</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    function submitForm(){\r\n");
      out.write("        $('#ff').form('submit');\r\n");
      out.write("    }\r\n");
      out.write("    function clearForm(){\r\n");
      out.write("        $('#ff').form('clear');\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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