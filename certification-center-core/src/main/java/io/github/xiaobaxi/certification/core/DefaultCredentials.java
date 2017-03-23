package io.github.xiaobaxi.certification.core;

import java.util.Map;

/**
 * @author fangzhibin
 */
public class DefaultCredentials implements Credentials {
    private String principalId;

    private Map<String, Object> certificates;

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public Map<String, Object> getCertificates() {
        return certificates;
    }

    public void setCertificates(Map<String, Object> certificates) {
        this.certificates = certificates;
    }
}
