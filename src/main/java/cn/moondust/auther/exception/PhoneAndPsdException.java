package cn.moondust.auther.exception;

/**
 * Created by j0 on 2016/8/4.
 */
public class PhoneAndPsdException  extends Exception{

    public PhoneAndPsdException(int code) {
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
