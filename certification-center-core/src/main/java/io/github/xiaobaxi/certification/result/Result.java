package io.github.xiaobaxi.certification.result;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @author fangzhibin
 */
public interface Result {
    Object getValue();

    Throwable getException();

    boolean hasException();

    Map<String, String> getAttachments();

    String getAttachment(String key);

    String getAttachment(String key, Supplier<String> defaultValue);
}
