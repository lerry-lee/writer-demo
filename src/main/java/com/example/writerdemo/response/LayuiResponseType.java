package com.example.writerdemo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LayuiResponseType {
    //状态码，0表示成功
    private Integer code;
    //说明
    private String msg;
    //数据量
    private Integer count;
    //数据
    private Object data;

    public static LayuiResponseType create(Integer code, String msg, Integer count, Object data) {
        LayuiResponseType layuiRequestType = new LayuiResponseType();
        layuiRequestType.setCode(code);
        layuiRequestType.setCount(count);
        layuiRequestType.setMsg(msg);
        layuiRequestType.setData(data);
        return layuiRequestType;
    }
}
