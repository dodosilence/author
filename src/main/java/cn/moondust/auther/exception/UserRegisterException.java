package cn.moondust.auther.exception;

/**
 * Created by j0 on 2016/8/3.
 *
 *
 *
 *
 *
 */
public class UserRegisterException  extends Exception{
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @param code    1 已经被注册   2  验证码错误   3密码不合法   4密码不同  10其他错误
     *
     */
    public UserRegisterException(int code) {
        this.code = code;
    }
}
