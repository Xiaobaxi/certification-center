package io.github.xiaobaxi.certification.core;

import io.github.xiaobaxi.certification.exception.CertificationCenterException;

/**
 * @author fangzhibin
 */
public interface AuthenticationHandleStrategy extends Ordered {

    void registerHandler(AuthenticationHandler handler);

    void registerCredentialResolver(CredentialResolver resolver);

    boolean supports(Credentials credentials);

    HandlerResult authenticate(Credentials credentials) throws CertificationCenterException;
}
