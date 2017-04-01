package io.github.xiaobaxi.certification.core;

import io.github.xiaobaxi.certification.exception.CertificationCenterException;
import io.github.xiaobaxi.certification.result.ResultCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 默认的strategy adapter
 * @author fangzhibin
 */
public abstract class DefaultAuthenticationHandlerStrategyAdapter implements AuthenticationHandlerStrategy {
    protected List<AuthenticationHandler> authenticationHandlers = new ArrayList<>();
    protected List<CredentialResolver> credentialResolvers = new ArrayList<>();

    @Override
    public void registerHandler(AuthenticationHandler handler) {
        synchronized (this) {
            authenticationHandlers.add(handler);
            authenticationHandlers.sort(Comparator.comparingInt(AuthenticationHandler::getOrder));
        }
    }

    @Override
    public void registerCredentialResolver(CredentialResolver resolver) {
        synchronized (this) {
            credentialResolvers.add(resolver);
            credentialResolvers.sort(Comparator.comparingInt(CredentialResolver::getOrder));
        }
    }

    /**
     * 默认逻辑：先通过credentialResolvers转换credential；再遍历handler，通过一个就算通过
     * @param credentials
     * @return
     * @throws CertificationCenterException
     */
    @Override
    public HandlerResult authenticate(Credentials credentials) throws CertificationCenterException {
        for (CredentialResolver credentialResolver : credentialResolvers) {
            credentials = credentialResolver.resolve(credentials);
        }
        for (AuthenticationHandler authenticationHandler : authenticationHandlers) {
            HandlerResult hr = authenticationHandler.authenticate(credentials);
            if(hr.isAuthenticated()) {
                return hr;
            }
        }
        throw new CertificationCenterException(ResultCode.INCORRECT_CREDENTIALS);
    }
}
