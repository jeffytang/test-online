package com.douma.util;

import com.douma.entity.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ApiResultHandler {

    public static ApiResult success(Object object){
        // 到时候改一下试试能不能用注解创建对象
        ApiResult apiResult = new ApiResult();
        apiResult.setData(object);
        apiResult.setCode(200);
        apiResult.setMessage("请求成功！");
        return apiResult;
    }

    public static ApiResult success(){
        return success(null);
    }

    public  static <T> ApiResult buildApiResult(Integer code, String message, T data){
        ApiResult apiResult = new ApiResult();

        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }


}
