package io.github.xiaobaxi.certification.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xiaobaxi.certification.exception.CertificateException;
import io.github.xiaobaxi.certification.exception.CertificationCenterException;
import io.github.xiaobaxi.certification.i18n.I18nMessageUtils;
import io.github.xiaobaxi.certification.result.ResultCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangzhibin
 */
@ControllerAdvice
public class CertificationCenterControllerAdvice {
    private final ObjectMapper mapper;

    public CertificationCenterControllerAdvice(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 对异常处理的国际化
     * @param request
     * @param response
     * @param e
     * @return
     * @throws IOException
     */
    @ExceptionHandler(CertificationCenterException.class)
    public String handle(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr, CertificateException e) throws IOException {
        List<CertificationCenterException> exs = e.getHandlerErrors();
        Map<String, Object> result;
        if(exs == null || exs.size() == 0) {
            result = getAjaxResultJSON(ResultCode.ILLEGAL_CODE.code(), null, null, ResultCode.FAIL.code());
        }else if(exs.size() == 1){
            CertificationCenterException ae = exs.get(0);
            result = getAjaxResultJSON(ae.getCode(), ae.getMessage(), ae.getArgs(), ResultCode.FAIL.code());
        }else {
            result = new HashMap<>();
            for (int i = 0; i < exs.size(); i++) {
                CertificationCenterException ae = exs.get(i);
                result.put("result"+i, getAjaxResultJSON(ae.getCode(), ae.getMessage(), ae.getArgs(), ResultCode.FAIL.code()));
            }
        }
        //ajax请求
        String XRequest = request.getHeader("X-Requested-With");
        if (XRequest != null && "XMLHttpRequest".equals(XRequest)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(mapper.writeValueAsString(result));
            response.getWriter().flush();
            return null;
        }
        attr.addAttribute("result",result);
        attr.addFlashAttribute("result", result);
        return "redirect:error";
    }

    private Map<String, Object> getAjaxResultJSON(String code, String message, Object[] args, String result){
        if(StringUtils.isEmpty(code)){
            code = ResultCode.ILLEGAL_CODE.code();
        }
        if(StringUtils.isEmpty(message)){
            message = I18nMessageUtils.getI18nMessage(code, args);
        }
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", code);
        map.put("message", message);
        map.put("result", result);
        return map;
    }
}
