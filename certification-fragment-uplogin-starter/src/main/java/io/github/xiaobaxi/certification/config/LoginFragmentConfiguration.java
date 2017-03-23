package io.github.xiaobaxi.certification.config;

import io.github.xiaobaxi.certification.core.AuthenticationHandler;
import io.github.xiaobaxi.certification.core.AuthenticationManger;
import io.github.xiaobaxi.certification.core.CredentialResolver;
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

    @Bean("usernamePasswordAuthenticationHandler")
    @ConditionalOnBean(AuthenticationManger.class)
    public AuthenticationHandler usernamePasswordAuthenticationHandler(AuthenticationManger authenticationManger){
        UsernamePasswordAuthenticationHandler upah = new UsernamePasswordAuthenticationHandler();
        authenticationManger.registerHandler(upah);
        return upah;
    }

    @Bean("usernamePasswordCredentialResolver")
    @ConditionalOnBean(AuthenticationManger.class)
    public CredentialResolver usernamePasswordCredentialResolver(AuthenticationManger authenticationManger){
        UsernamePasswordCredentialResolver upcr = new UsernamePasswordCredentialResolver();
        authenticationManger.registerCredentialResolver(upcr);
        return upcr;
    }
}
