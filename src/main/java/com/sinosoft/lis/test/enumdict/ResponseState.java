package com.sinosoft.lis.test.enumdict;

/**
 * Created by cxq on 2019/8/26.
 */
public enum ResponseState {
    SUCCESS("操作成功！"),FAIL("操作失败！");

    private final String value;

    private ResponseState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ResponseState getEnumFromString(String string){
        if(string!=null){
            return Enum.valueOf(ResponseState.class, string.trim());
        }
        return null;
    }
}
