package io.github.xiaobaxi.certification.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.annotation.PostConstruct;

/**
 * @author fangzhibin
 */
public class I18nMessageUtils {
    private static I18nMessageUtils i18nMessageUtils;

    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init(){
        i18nMessageUtils = this;
        i18nMessageUtils.messageSource = this.messageSource;
    }

    public static String getI18nMessage(String messageCode, Object[] args){
        return i18nMessageUtils.messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }
}
