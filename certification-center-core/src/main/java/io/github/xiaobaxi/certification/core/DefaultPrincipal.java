package io.github.xiaobaxi.certification.core;

/**
 * @author fangzhibin
 */
public class DefaultPrincipal implements Principal {
    private String principalId;

    public DefaultPrincipal(String principalId) {
        this.principalId = principalId;
    }

    @Override
    public Object getPrincipalId() {
        return principalId;
    }
}
