package io.github.xiaobaxi.certification.auth;

import io.github.xiaobaxi.certification.core.*;
import io.github.xiaobaxi.certification.exception.CertificateException;
import io.github.xiaobaxi.certification.exception.CertificationCenterException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangzhibin
 */
public class AuthenticationManagerImpl extends AuthenticationMangerAdapter {

    @Override
    public Principal authenticate(Credentials credentials) throws CertificateException {
        List<CertificationCenterException> handlerErrors = new ArrayList<>();

        for(AuthenticationHandleStrategy strategy : strategies) {
            if(strategy.supports(credentials)) {
                try {
                    HandlerResult hr = strategy.authenticate(credentials);
                    return hr.getPrincipal();
                } catch (CertificationCenterException e) {
                    handlerErrors.add(e);
                }
            }
        }
        throw new CertificateException(handlerErrors);
    }

}
