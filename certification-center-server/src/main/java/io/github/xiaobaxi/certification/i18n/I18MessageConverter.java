package io.github.xiaobaxi.certification.i18n;

import io.github.xiaobaxi.certification.result.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 对于ResResult类做json序列化时的处理
 */
public class I18MessageConverter extends AbstractHttpMessageConverter<AjaxResult> {
    private final ResultI18nHandler resultI18nHandler;

    @Autowired
    public I18MessageConverter(ResultI18nHandler resultI18nHandler) {
        super(Charset.forName("UTF-8"), MediaType.APPLICATION_JSON);
        this.resultI18nHandler = resultI18nHandler;
    }
    @Override
    protected boolean supports(Class<?> aClass) {
        return AjaxResult.class.isAssignableFrom(aClass);
    }

    @Override
    protected AjaxResult readInternal(Class<? extends AjaxResult> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(AjaxResult ajaxResult, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        httpOutputMessage.getBody().write(resultI18nHandler.getJSONBytes(ajaxResult));
        httpOutputMessage.getBody().flush();
    }
}
