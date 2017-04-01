package io.github.xiaobaxi.certification.up;

import io.github.xiaobaxi.certification.core.*;

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
    public HandlerResult authenticate(Credentials credentials) {
        UsernamePasswordCredentials c = (UsernamePasswordCredentials) credentials;
        if ("admin".equals(c.getUsername()) && "admin".equals(c.getPassword())) {
            return new DefaultHandlerResult(this.getClass().getCanonicalName(), credentials, new DefaultPrincipal(c.getUsername()), null, true);
        } else {
            return new DefaultHandlerResult(this.getClass().getCanonicalName(), credentials, new DefaultPrincipal(c.getUsername()), null, false);
        }
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
