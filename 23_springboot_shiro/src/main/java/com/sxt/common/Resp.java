package com.sxt.common;

import lombok.Data;
import lombok.ToString;

/**
 * @author 鲜磊 on 2019/9/14
 **/
@ToString
public class Resp {

    private Integer status;
    private Boolean state;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public Resp setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Boolean getState() {
        return state;
    }

    public Resp setState(Boolean state) {
        this.state = state;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Resp setMessage(String message) {
        this.message = message;
        return this;
    }

    public static Resp builder(){
        return new Resp();
    }
}
