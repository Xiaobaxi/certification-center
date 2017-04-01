package io.github.xiaobaxi.certification.result;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author fangzhibin
 */
public enum ResultCode {
    SUCCESS("1"),
    FAIL("0"),
    ERROR("2"),

    ILLEGAL_CODE("1001"),
    INCORRECT_CREDENTIALS("1002");
    private String code;

    private ResultCode(String code) {
        this.code = code;
    }

    public String code(){
        return code;
    }

    public static String code(String name) {
        try {
            return ResultCode.valueOf(name).code;
        }catch (IllegalArgumentException e){
            return ResultCode.ILLEGAL_CODE.code;
        }
    }

    public static ResultCode fromCode(String code){
        Optional<ResultCode> optional = Stream.of(ResultCode.values()).filter(resultCode -> Objects.equals(code, resultCode.code)).findFirst();
        return optional.orElse(ResultCode.ILLEGAL_CODE);
    }

    @Override
    public String toString() {
        return name();
    }
}
