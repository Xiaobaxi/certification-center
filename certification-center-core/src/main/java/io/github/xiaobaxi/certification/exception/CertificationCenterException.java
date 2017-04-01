package io.github.xiaobaxi.certification.exception;

import io.github.xiaobaxi.certification.result.ResultCode;

/**
 * Created by fangzhibin on 2017/4/1.
 */
public class CertificationCenterException extends RuntimeException {
    private String code;
    private String msg;
    private Object[] args;

    public CertificationCenterException() {
    }

    public CertificationCenterException(String code) {
        this.code = code;
    }

    public CertificationCenterException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CertificationCenterException(ResultCode resultCode) {
        this.code = resultCode.code();
    }

    public CertificationCenterException(ResultCode resultCode, String msg) {
        super(msg);
        this.code = resultCode.code();
        this.msg = msg;
    }

    public CertificationCenterException(String code, String msg, Object... args) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.args = args;
    }

    public CertificationCenterException(ResultCode resultCode, String msg, Object... args) {
        super(msg);
        this.code = resultCode.code();
        this.msg = msg;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
