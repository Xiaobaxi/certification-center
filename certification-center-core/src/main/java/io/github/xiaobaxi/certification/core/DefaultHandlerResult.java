package io.github.xiaobaxi.certification.core;

import java.util.List;
import java.util.Map;

/**
 * @author fangzhibin
 */
public class DefaultHandlerResult implements HandlerResult {
    private String handlerName;

    private Credentials credentialMetaData;

    private Principal principal;

    private List<Map<String, String>> warnings;

    private boolean authenticated;

    public DefaultHandlerResult() {
    }

    public DefaultHandlerResult(String handlerName, Credentials credentialMetaData, Principal principal, List<Map<String, String>> warnings, boolean authenticated) {
        this.handlerName = handlerName;
        this.credentialMetaData = credentialMetaData;
        this.principal = principal;
        this.warnings = warnings;
        this.authenticated = authenticated;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public String getHandlerName() {
        return this.handlerName;
    }

    @Override
    public Credentials getCredentialMetaData() {
        return this.credentialMetaData;
    }

    @Override
    public Principal getPrincipal() {
        return this.principal;
    }

    @Override
    public List<Map<String, String>> getWarnings() {
        return this.warnings;
    }
}
