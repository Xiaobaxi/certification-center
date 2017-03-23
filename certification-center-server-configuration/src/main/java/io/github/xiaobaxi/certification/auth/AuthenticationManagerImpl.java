package io.github.xiaobaxi.certification.auth;

import io.github.xiaobaxi.certification.core.AuthenticationHandler;
import io.github.xiaobaxi.certification.core.AuthenticationMangerAdapter;
import io.github.xiaobaxi.certification.core.Credentials;
import io.github.xiaobaxi.certification.core.Principal;

/**
 * @author fangzhibin
 */
public class AuthenticationManagerImpl extends AuthenticationMangerAdapter {

    @Override
    public boolean authenticateInternal(Credentials credentials) {
        /*
         * 默认第一个支持的handler起效
         */
        for(AuthenticationHandler handler : authenticationHandlers) {
            if(handler.supports(credentials)) {
                return handler.authenticate(credentials);
            }
        }
        return false;
    }

    @Override
    public Principal authenticateAndObtainPrincipalInternal(Credentials credentials) {
        /*
         * 默认第一个支持的handler起效
         */
        for(AuthenticationHandler handler : authenticationHandlers) {
            if(handler.supports(credentials)) {
                return handler.authenticateAndObtainPrincipal(credentials);
            }
        }
        return Principal.NOT_PERMMITED;
    }

}
