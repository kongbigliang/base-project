package com.kongbig.word.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kongbig
 * @date 2020/3/18 21:21
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private int code;
    private String msg;
    private Object data;

    public static ResultDto ok(String msg) {
        return new ResultDto(Constants.ResultCode.OK, msg, null);
    }

    public static ResultDto ok(Object data) {
        return new ResultDto(Constants.ResultCode.OK, "success", data);
    }

    public static ResultDto fail(String msg) {
        return new ResultDto(Constants.ResultCode.FAIL, msg, null);
    }

}
