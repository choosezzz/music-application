package com.example.musicapplication.utils;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.MapUtils;
import com.blankj.utilcode.util.StringUtils;

import org.json.JSONObject;

import java.util.Map;

import io.realm.internal.android.JsonUtils;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author choosezzz
 * @date 3/28/21 12:54 AM
 */
public class HttpUtil {

    private static final LoggerFactory.Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static final MediaType JSON_MEDIA = MediaType.parse("application/json; charset=utf-8");

    public static void get(String url, Map<String, Object> header, Map<String, Object> params, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        if (MapUtils.isNotEmpty(params)) {
            url = url + "?" + join(params);
        }
        Request request = new Request.Builder().url(url).headers(getHeaders(header)).build();
        client.newCall(request).enqueue(callback);
    }

    public static void postJson(String url, Map<String, Object> header, Map<String, Object> params, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).post(getJsonRequestBody(params)).headers(getHeaders(header)).build();
        client.newCall(request).enqueue(callback);
    }

    private static String join(Map<String, Object> maps) {
        return join(maps, "&");
    }
    private static String join(Map<String, Object> maps, String joiner) {

        StringBuilder sb = new StringBuilder(joiner);
        for (Map.Entry<String, Object> entry : maps.entrySet()) {
            sb.append(entry.getKey()).append(joiner).append(entry.getValue());
        }
        return sb.delete(0, joiner.length()).toString();
    }
    private static Headers getHeaders(Map<String, Object> header) {
        Headers headers = new Headers.Builder().build();
        if (MapUtils.isNotEmpty(header)) {
            header.putAll(header);
        }
        return headers;
    }
    private static RequestBody getJsonRequestBody(Map<String, Object> body) {
        return RequestBody.create(JSON.toJSONString(body), JSON_MEDIA);
    }
}
