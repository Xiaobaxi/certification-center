package io.github.xiaobaxi.certification.core;

import java.util.List;
import java.util.Map;

/**
 * @author fangzhibin
 */
public interface HandlerResult {
    boolean isAuthenticated();
    /**
     * Gets handler name.
     *
     * @return the handler name
     */
    String getHandlerName();

    /**
     * Gets credential meta data.
     *
     * @return the credential meta data
     */
    Credentials getCredentialMetaData();

    /**
     * Gets principal.
     *
     * @return the principal
     */
    Principal getPrincipal();

    /**
     * Gets warnings.
     *
     * @return the warnings
     */
    List<Map<String, String>> getWarnings();
}
