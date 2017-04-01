package io.github.xiaobaxi.certification.config;

import io.github.xiaobaxi.certification.core.AuthenticationHandleStrategy;
import io.github.xiaobaxi.certification.core.AuthenticationHandler;
import io.github.xiaobaxi.certification.core.AuthenticationManger;
import io.github.xiaobaxi.certification.core.CredentialResolver;
import io.github.xiaobaxi.certification.up.UpAuthenticationHandleStrategyImpl;
import io.github.xiaobaxi.certification.up.UsernamePasswordAuthenticationHandler;
import io.github.xiaobaxi.certification.up.UsernamePasswordCredentialResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fangzhibin
 */
@Configuration
public class LoginFragmentConfiguration {

    @Bean("upAuthenticationHandleStrategy")
    @ConditionalOnBean(AuthenticationManger.class)
    public AuthenticationHandleStrategy upAuthenticationHandleStrategy(AuthenticationManger authenticationManger){
        AuthenticationHandleStrategy apolloAuthenticationHandleStrategy = new UpAuthenticationHandleStrategyImpl();
        authenticationManger.registerHandleStrategy(apolloAuthenticationHandleStrategy);
        return apolloAuthenticationHandleStrategy;
    }

    @Bean("usernamePasswordAuthenticationHandler")
    @ConditionalOnBean(AuthenticationManger.class)
    public AuthenticationHandler usernamePasswordAuthenticationHandler(AuthenticationHandleStrategy upAuthenticationHandleStrategy){
        UsernamePasswordAuthenticationHandler upah = new UsernamePasswordAuthenticationHandler();
        upAuthenticationHandleStrategy.registerHandler(upah);
        return upah;
    }

    @Bean("usernamePasswordCredentialResolver")
    @ConditionalOnBean(AuthenticationManger.class)
    public CredentialResolver usernamePasswordCredentialResolver(AuthenticationHandleStrategy upAuthenticationHandleStrategy){
        UsernamePasswordCredentialResolver upcr = new UsernamePasswordCredentialResolver();
        upAuthenticationHandleStrategy.registerCredentialResolver(upcr);
        return upcr;
    }
}
