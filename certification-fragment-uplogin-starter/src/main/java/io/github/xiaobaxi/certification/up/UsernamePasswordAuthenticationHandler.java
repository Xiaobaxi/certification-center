package io.github.xiaobaxi.certification.up;

import io.github.xiaobaxi.certification.core.AuthenticationHandler;
import io.github.xiaobaxi.certification.core.Credentials;
import io.github.xiaobaxi.certification.core.DefaultPrincipal;
import io.github.xiaobaxi.certification.core.Principal;

/**
 * @author fangzhibin
 */
public class UsernamePasswordAuthenticationHandler implements AuthenticationHandler {
    private int order = 0;

    public UsernamePasswordAuthenticationHandler(int order) {
        this.order = order;
    }

    public UsernamePasswordAuthenticationHandler() {
    }

    @Override
    public boolean authenticate(Credentials credentials) {
        UsernamePasswordCredentials c = (UsernamePasswordCredentials) credentials;
        if ("admin".equals(c.getUsername()) && "admin".equals(c.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean supports(Credentials credentials) {
        return true;
    }

    @Override
    public Principal authenticateAndObtainPrincipal(Credentials credentials) {
        UsernamePasswordCredentials c = (UsernamePasswordCredentials) credentials;
        if ("admin".equals(c.getUsername()) && "12345".equals(c.getPassword())) {
            return new DefaultPrincipal(c.getUsername());
        } else {
            return Principal.NOT_PERMMITED;
        }
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
