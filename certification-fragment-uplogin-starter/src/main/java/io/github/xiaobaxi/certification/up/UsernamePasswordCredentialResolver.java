package io.github.xiaobaxi.certification.up;

import io.github.xiaobaxi.certification.core.DefaultCredentials;
import io.github.xiaobaxi.certification.core.CredentialResolver;
import io.github.xiaobaxi.certification.core.Credentials;

/**
 * @author fangzhibin
 */
public class UsernamePasswordCredentialResolver implements CredentialResolver {
    @Override
    public Credentials resolve(Credentials credentials) {
        DefaultCredentials cc = (DefaultCredentials) credentials;
        return new UsernamePasswordCredentials(cc.getPrincipalId(), (String) cc.getCertificates().get("up"));
    }

    @Override
    public boolean supports(Credentials credentials) {
        return true;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
