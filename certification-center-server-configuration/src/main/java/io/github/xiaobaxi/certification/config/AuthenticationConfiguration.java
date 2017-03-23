package io.github.xiaobaxi.certification.config;

import io.github.xiaobaxi.certification.auth.AuthenticationManagerImpl;
import io.github.xiaobaxi.certification.core.AuthenticationManger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fangzhibin
 */
@Configuration
public class AuthenticationConfiguration {

    @Bean("authenticationManager")
    @ConditionalOnMissingBean(name = {"authenticationManager"})
    public AuthenticationManger authenticationManger(){
        return new AuthenticationManagerImpl();
    }
}
