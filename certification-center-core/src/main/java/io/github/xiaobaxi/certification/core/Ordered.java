package io.github.xiaobaxi.certification.core;

/**
 * @author fangzhibin
 */
public interface Ordered {
    int HIGHEST_PRECEDENCE = -2147483648;
    int LOWEST_PRECEDENCE = 2147483647;

    int getOrder();
}
