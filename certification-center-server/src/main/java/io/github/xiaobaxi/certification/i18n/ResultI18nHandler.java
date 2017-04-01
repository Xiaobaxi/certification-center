package io.github.xiaobaxi.certification.i18n;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xiaobaxi.certification.result.AjaxResult;
import io.github.xiaobaxi.certification.result.ResultCode;
import org.springframework.util.StringUtils;

/**
 * 对AjaxResult做国际化JSON处理器
 */
public class ResultI18nHandler {
    private final ObjectMapper mapper;

    public ResultI18nHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    public byte[] getJSONBytes(AjaxResult result) throws JsonProcessingException {
        if(StringUtils.isEmpty(result.getCode())){
            //如果result没有code，那不标准
            result.setCode(ResultCode.ILLEGAL_CODE.code());
        }
        if(StringUtils.isEmpty(result.getMessage())){
            //如果message已经有值了，那就不做国际化了。
            result.setMessage(I18nMessageUtils.getI18nMessage(result.getCode(), result.getMessageArgs()));
        }
        return mapper.writeValueAsBytes(result);
    }

    public String getString(AjaxResult resResult) throws JsonProcessingException {
        if(StringUtils.isEmpty(resResult.getCode())){
            resResult.setCode(ResultCode.ILLEGAL_CODE.code());
        }
        if(StringUtils.isEmpty(resResult.getMessage())){
            resResult.setMessage(I18nMessageUtils.getI18nMessage(resResult.getCode(), resResult.getMessageArgs()));
        }
        return mapper.writeValueAsString(resResult);
    }
}
