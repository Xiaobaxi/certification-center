package io.github.xiaobaxi.certification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author fangzhibin
 */
@SpringBootApplication
public class CertificationCenterApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CertificationCenterApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CertificationCenterApplication.class, args);
    }
}
