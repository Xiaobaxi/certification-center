package io.github.xiaobaxi.certification.core;


/**
 * @author fangzhibin
 */
public interface AuthenticationHandler extends Ordered {

    HandlerResult authenticate(Credentials credentials);
}