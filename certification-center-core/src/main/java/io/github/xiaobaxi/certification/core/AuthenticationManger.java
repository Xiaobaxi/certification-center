package io.github.xiaobaxi.certification.core;

/**
 * @author fangzhibin
 */
public interface AuthenticationManger {

    boolean authenticate(Credentials credentials);

    Principal authenticateAndObtainPrincipal(Credentials credentials);

    void registerHandler(AuthenticationHandler handler);

    void registerCredentialResolver(CredentialResolver resolver);
}
