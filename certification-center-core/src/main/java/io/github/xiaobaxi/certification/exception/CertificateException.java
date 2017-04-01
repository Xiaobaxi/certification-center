package io.github.xiaobaxi.certification.exception;


import io.github.xiaobaxi.certification.core.HandlerResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fangzhibin
 */
public class CertificateException extends RuntimeException {

    /**
     * 失败的异常
     */
    private final List<CertificationCenterException> handlerErrors;

    /**
     * 成功handlerResult
     */
    private final List<HandlerResult> handlerSuccesses;

    public CertificateException(final String msg) {
        this(msg, Collections.emptyList(), Collections.emptyList());
    }

    /**
     * 初始化一个CertificateException异常.
     */
    public CertificateException() {
        this("No supported authentication handlers found for given credentials");
    }

    /**
     * 创建一个没有handler成功验证的异常实例.
     *
     * @param handlerErrors handler名称与错误的映射.
     */
    public CertificateException(final List<CertificationCenterException> handlerErrors) {
        this(handlerErrors, Collections.emptyList());
    }

    /**
     * 创建一个有handler成功验证和失败验证的异常实例.
     *
     * @param handlerErrors    handler名称与错误的映射.
     * @param handlerSuccesses handler名称与成功的映射.
     */
    public CertificateException(
            final List<CertificationCenterException> handlerErrors, final List<HandlerResult> handlerSuccesses) {
        this(String.format("%s errors, %s successes", handlerErrors.size(), handlerSuccesses.size()), handlerErrors, handlerSuccesses);
    }

    /**
     * 创建一个有handler成功验证和失败验证的异常实例.并需要自定义错误信息。
     *
     * @param message          自定义错误信息
     * @param handlerErrors    handler名称与错误的映射.
     * @param handlerSuccesses handler名称与成功的映射.
     */
    public CertificateException(
            final String message,
            final List<CertificationCenterException> handlerErrors,
            final List<HandlerResult> handlerSuccesses) {
        super(message);
        this.handlerErrors = new ArrayList<>(handlerErrors);
        this.handlerSuccesses = new ArrayList<>(handlerSuccesses);
    }

    /**
     * 获取handler名称与错误的映射
     *
     * @return handler名称与错误的映射.
     */
    public List<CertificationCenterException> getHandlerErrors() {
        return this.handlerErrors;
    }

    /**
     * handler名称与成功的映射.
     *
     * @return handler名称与错误的映射.
     */
    public List<HandlerResult> getHandlerSuccesses() {
        return this.handlerSuccesses;
    }
}
