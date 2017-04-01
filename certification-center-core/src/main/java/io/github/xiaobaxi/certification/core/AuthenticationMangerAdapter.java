package io.github.xiaobaxi.certification.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author fangzhibin
 */
public abstract class AuthenticationMangerAdapter implements AuthenticationManger {
    protected List<AuthenticationHandlerStrategy> strategies = new ArrayList<>();

    @Override
    public void registerHandleStrategy(AuthenticationHandlerStrategy strategy) {
        synchronized (this) {
            strategies.add(strategy);
            strategies.sort(Comparator.comparingInt(AuthenticationHandlerStrategy::getOrder));
        }
    }
}
