package io.github.xiaobaxi.certification.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author fangzhibin
 */
public class AjaxResult implements Result, Serializable{
    private Object value;
    private transient Throwable exception;
    private transient Map<String, String> attachments = new HashMap<>();
    private transient Object[] messageArgs;

    public AjaxResult(Object value) {
        this.value = value;
    }

    public AjaxResult(Throwable exception) {
        this.exception = exception;
    }

    public AjaxResult(Object value, String code, String result, String message) {
        this.value = value;
        this.setCode(code);
        this.setResult(result);
        this.setMessage(message);
    }

    public AjaxResult(Object value, String code, String result, String message, Object[] messageArgs) {
        this.value = value;
        this.setCode(code);
        this.setResult(result);
        this.setMessage(message);
        this.messageArgs = messageArgs;
    }

    public String getCode() {
        return this.attachments.get("code");
    }

    public void setCode(String code) {
        this.attachments.put("code", code);
    }

    public String getResult() {
        return this.attachments.get("result");
    }

    public void setResult(String result) {
        this.attachments.put("result", result);
    }

    public String getMessage() {
        return this.attachments.get("message");
    }

    public void setMessage(String message) {
        this.attachments.put("message", message);
    }

    public void setMessageArgs(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public Throwable getException() {
        return this.exception;
    }

    @Override
    public boolean hasException() {
        return this.exception != null;
    }

    @Override
    public Map<String, String> getAttachments() {
        return this.attachments;
    }

    @Override
    public String getAttachment(String key) {
        return attachments.get(key);
    }

    @Override
    public String getAttachment(String key, Supplier<String> defaultValue) {
        String result = this.attachments.get(key);
        if (result == null || result.length() == 0) {
            result = defaultValue.get();
        }

        return result;
    }
}
