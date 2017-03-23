package io.github.xiaobaxi.certification.core;


/**
 * @author fangzhibin
 */
public interface AuthenticationHandler extends Ordered {

    boolean authenticate(Credentials credentials);

    Principal authenticateAndObtainPrincipal(Credentials credentials);

    boolean supports(Credentials credentials);
}