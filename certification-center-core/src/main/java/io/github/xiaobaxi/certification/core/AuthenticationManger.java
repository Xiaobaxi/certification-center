package io.github.xiaobaxi.certification.core;

import io.github.xiaobaxi.certification.exception.CertificationCenterException;

import java.security.cert.Certificate;

/**
 * @author fangzhibin
 */
public interface AuthenticationManger {

    Principal authenticate(Credentials credentials) throws CertificationCenterException;

    void registerHandleStrategy(AuthenticationHandleStrategy strategy);
}
