package io.github.xiaobaxi.certification.core;

/**
 * @author fangzhibin
 */
public interface Principal {
    Principal NOT_PERMMITED = null;

    Object getPrincipalId();
}
