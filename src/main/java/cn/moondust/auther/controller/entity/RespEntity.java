package cn.moondust.auther.controller.entity;

/**
 * Created by j0 on 2016/8/5.
 */
public class RespEntity {

    private int code;

    private String message;

    public RespEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
