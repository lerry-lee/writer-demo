package com.example.writerdemo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/01
 * writer通用返回类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WriterResponseType {
    //状态码：0表示失败，1表示成功
    private Integer code;
    //状态说明
    private String msg;
    //返回数据内容
    private Object data;

    public static WriterResponseType success() {
        WriterResponseType responseType = new WriterResponseType();
        responseType.setCode(1);
        responseType.setMsg("成功");
        return responseType;
    }

    public static WriterResponseType success(String msg, Object data) {
        WriterResponseType responseType = new WriterResponseType();
        responseType.setCode(1);
        responseType.setMsg(msg);
        responseType.setData(data);
        return responseType;
    }

    public static WriterResponseType failed() {
        WriterResponseType responseType = new WriterResponseType();
        responseType.setCode(0);
        responseType.setMsg("失败");
        return responseType;
    }

    public static WriterResponseType failed(String msg, Object data) {
        WriterResponseType responseType = new WriterResponseType();
        responseType.setCode(0);
        responseType.setMsg(msg);
        responseType.setData(data);
        return responseType;
    }

}
