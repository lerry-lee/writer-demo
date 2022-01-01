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

    public static WriterResponseType success(Object data) {
        WriterResponseType responseType = new WriterResponseType();
        responseType.setCode(1);
        responseType.setData("成功");
        responseType.setData(data);
        return responseType;
    }

    public static WriterResponseType failed(Object data) {
        WriterResponseType responseType = new WriterResponseType();
        responseType.setCode(0);
        responseType.setData("失败");
        responseType.setData(data);
        return responseType;
    }

}
