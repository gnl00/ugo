package com.boot.ugo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * ReturnResult 返回值封装类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResult {

    private Result result;

    public static Result ok() {
        return new Result(true, StatusCode.OK, "操作成功", null);
    }

    public static Result ok(Object data) {
        return new Result(true, StatusCode.OK, "操作成功", data);
    }

    public static Result ok(String msg, Object data) {
        return new Result(true, StatusCode.OK, msg, data);
    }

    public static Result fail(int code, String msg) {
        return new Result(false, code, msg, null);
    }

}
