package io.github.xiaobaxi.certification.core;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author fangzhibin
 */
public abstract class AuthenticationMangerAdapter implements AuthenticationManger {
    protected List<AuthenticationHandler> authenticationHandlers = new CopyOnWriteArrayList<>();
    protected List<CredentialResolver> credentialResolvers = new CopyOnWriteArrayList<>();

    @Override
    public boolean authenticate(Credentials credentials) {
        Credentials c = getCredentialResolver(credentials);
        return authenticateInternal(c);
    }

    public abstract boolean authenticateInternal(Credentials credentials);

    @Override
    public Principal authenticateAndObtainPrincipal(Credentials credentials) {
        Credentials c = getCredentialResolver(credentials);
        return authenticateAndObtainPrincipalInternal(c);
    }

    public abstract Principal authenticateAndObtainPrincipalInternal(Credentials credentials);

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

    private Credentials getCredentialResolver(Credentials credentials){
        for(CredentialResolver resolver : credentialResolvers) {
            if(resolver.supports(credentials)) {
                return resolver.resolve(credentials);
            }
        }
        return credentials;
    }
}
