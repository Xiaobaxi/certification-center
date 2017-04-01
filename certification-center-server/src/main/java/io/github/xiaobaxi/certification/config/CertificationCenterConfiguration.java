package io.github.xiaobaxi.certification.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.xiaobaxi.certification.i18n.I18nMessageUtils;
import io.github.xiaobaxi.certification.i18n.I18MessageConverter;
import io.github.xiaobaxi.certification.i18n.ResultI18nHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author fangzhibin
 */
@Configuration
@AutoConfigureAfter(LocaleConfiguration.class)
public class CertificationCenterConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    @Bean
    public ResultI18nHandler resultI18nHandler(){
        return new ResultI18nHandler(objectMapper());
    }

    @Bean
    public I18MessageConverter i18MessageConverter(){
        return new I18MessageConverter(resultI18nHandler());
    }

    @Autowired
    private MessageSource messageSource;

    @Bean
    public I18nMessageUtils i18nMessageUtils(){
        I18nMessageUtils i18nMessageUtils = new I18nMessageUtils();
        i18nMessageUtils.setMessageSource(messageSource);
        return i18nMessageUtils;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, i18MessageConverter());
    }
}
