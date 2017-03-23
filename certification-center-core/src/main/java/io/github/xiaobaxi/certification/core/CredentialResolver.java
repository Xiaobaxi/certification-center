package io.github.xiaobaxi.certification.core;

/**
 * @author fangzhibin
 */
public interface CredentialResolver extends Ordered {
    Credentials resolve(Credentials credentials);

    boolean supports(Credentials credentials);
}
