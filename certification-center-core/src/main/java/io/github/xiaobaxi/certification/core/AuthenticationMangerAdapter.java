package io.github.xiaobaxi.certification.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author fangzhibin
 */
public abstract class AuthenticationMangerAdapter implements AuthenticationManger {
    protected List<AuthenticationHandleStrategy> strategies = new ArrayList<>();

    @Override
    public void registerHandleStrategy(AuthenticationHandleStrategy strategy) {
        synchronized (this) {
            strategies.add(strategy);
            strategies.sort(Comparator.comparingInt(AuthenticationHandleStrategy::getOrder));
        }
    }
}
