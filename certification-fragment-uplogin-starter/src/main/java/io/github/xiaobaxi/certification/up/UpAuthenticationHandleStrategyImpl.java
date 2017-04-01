package io.github.xiaobaxi.certification.up;


import io.github.xiaobaxi.certification.core.Credentials;
import io.github.xiaobaxi.certification.core.DefaultAuthenticationHandleStrategyAdapter;
import io.github.xiaobaxi.certification.core.DefaultCredentials;

/**
 * @author fangzhibin
 */
public class UpAuthenticationHandleStrategyImpl extends DefaultAuthenticationHandleStrategyAdapter {
    private int order = 0;

    public UpAuthenticationHandleStrategyImpl() {
    }

    public UpAuthenticationHandleStrategyImpl(int order) {
        this.order = order;
    }

    @Override
    public boolean supports(Credentials credentials) {
        DefaultCredentials cc = (DefaultCredentials) credentials;
        return cc.getCertificates().containsKey("up");
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
