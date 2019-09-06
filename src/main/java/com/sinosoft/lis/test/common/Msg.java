package com.sinosoft.lis.test.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by cxq on 2019/8/23.
 */
public class Msg<T> {
    private String message;
    private String flag;
    @Setter
    @Getter
    private T data;

    private Msg(){}

    private Msg(String message,String flag){
        this.message = message;
        this.flag = flag;
    }

    public static Msg success(String message){
        Msg msg = new Msg(message,"SUCCESS");
        return msg;
    }

    public static Msg fail(String message){
        Msg msg = new Msg(message,"FAIL");
        return msg;
    }
}
