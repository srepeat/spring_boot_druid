package com.sxt.common;

import com.google.gson.Gson;
import com.sxt.utils.GsonUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 鲜磊 on 2019/9/14
 **/
public class AbstractServlet {

    protected void out(HttpServletResponse response, Resp resp){
        Gson gson = GsonUtils.createGson();
        ServletOutputStream out = null;
        try {
            response.setStatus(resp.getStatus());
            out = response.getOutputStream();
            out.write(gson.toJson(resp).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
