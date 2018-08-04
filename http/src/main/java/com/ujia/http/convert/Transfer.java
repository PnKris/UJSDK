package com.ujia.http.convert;

import com.ujia.http.HttpError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 统一处理 json 返回值
 * {"code":1,"msg":"ok", "data":"{...}"}
 */
public class Transfer extends ITransfer {

    @Override
    public void convert(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            int code = jsonObject.optInt("code");
            if (code != 1) {
                String msg = jsonObject.optString("msg");
                isSuccess = false;
                error = new HttpError(code, msg);
            } else {
                isSuccess = true;
                result = jsonObject.optString("data");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            error = new HttpError(-1, e.getMessage());
        }
    }
}
