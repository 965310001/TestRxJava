/*
package example.com.testrxjava.Volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import example.com.testrxjava.Aop.MyApplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class HttpUtil {

    private static HttpUtil mHttpUtil;
    private Gson mGson;

    //请求连接的前缀
    private static final String BASE_URL = "";

    //连接超时时间
    private static final int REQUEST_TIMEOUT_TIME = 60 * 1000;

    //volley请求队列
    public static RequestQueue mRequestQueue;
    private String mUrl;
    */
/*private Map<String, String> mParam;*//*



    private HttpUtil() {
        mGson = new Gson();
        //这里使用Application创建全局的请求队列
        mRequestQueue = Volley.newRequestQueue(MyApplication.myApplication);
    }

    public static HttpUtil getInstance() {
        if (mHttpUtil == null) {
            synchronized (HttpUtil.class) {
                if (mHttpUtil == null) {
                    mHttpUtil = new HttpUtil();
                }
            }
        }
        return mHttpUtil;
    }

    */
/**
     * http POST请求
     *
     * @param url          http地址（后缀）
     * @param param        参数
     * @param httpCallBack 回调
     *//*

    public <T> void request(String url, final Map<String, String> param, final HttpCallBack<T> httpCallBack) {
        request(url, param, httpCallBack, true);
    }

    */
/**
     * http get请求
     *
     * @param url
     * @param param
     * @param httpCallBack
     * @param flag
     * @param <T>
     *//*

    public <T> void request(String url, final Map<String, String> param, final HttpCallBack<T> httpCallBack, boolean flag) {
        show(url, param, httpCallBack, flag);
    }

    HttpCallBack httpCallBack;

    <T> void show(String url, final Map<String, String> param, final HttpCallBack<T> httpCallBack, boolean flag) {
        if (!flag) {//get
            StringBuffer stringBuffer = new StringBuffer(url);
            for (Map.Entry<String, String> stringStringEntry : param.entrySet()) {
                if (!stringBuffer.toString().contains(stringStringEntry.getKey())) {
                    stringBuffer.append(stringStringEntry.getKey() + "=" + stringStringEntry.getValue() + "&");
                }
            }
            mUrl = stringBuffer.substring(0, stringBuffer.length() - 1);
        }

        */
/*this.httpCallBack=httpCallBack;*//*


        */
/*StringRequest stringRequest = new StringRequest(flag ? Request.Method.POST : Request.Method.GET,
                BASE_URL + mUrl, this, this);*//*


        StringRequest stringRequest = null;
        if (flag) {//post
            stringRequest = new StringRequest(Request.Method.POST, BASE_URL + mUrl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (httpCallBack == null) {
                                return;
                            }
                            Type type = getTType(httpCallBack.getClass());
                            if (response.contains("<!DOCTYPE html>")) {
                                httpCallBack.onSuccess((T) response);
                            } else {
                                HttpResult httpResult = mGson.fromJson(response, HttpResult.class);
                                if (httpResult != null) {
                                    if (httpResult.getCode() != 200) {//失败
                                        httpCallBack.onFail(httpResult.getMsg());
                                    } else {//成功
                                        //获取data对应的json字符串
                                        String json = mGson.toJson(httpResult.getData());
                                        if (type == String.class) {//泛型是String，返回结果json字符串
                                            httpCallBack.onSuccess((T) json);
                                        } else {//泛型是实体或者List<>
                                            T t = mGson.fromJson(json, type);
                                            httpCallBack.onSuccess(t);
                                        }
                                    }
                                }
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (httpCallBack == null) {
                        return;
                    }
                    String msg = error.getMessage();
                    httpCallBack.onFail(msg);
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    //请求参数
                    return param;
                }

            };
        } else {
            stringRequest = new StringRequest(Request.Method.POST, BASE_URL + mUrl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (httpCallBack == null) {
                                return;
                            }
                            Type type = getTType(httpCallBack.getClass());
                            if (response.contains("<!DOCTYPE html>")) {
                                httpCallBack.onSuccess((T) response);
                            } else {
                                HttpResult httpResult = mGson.fromJson(response, HttpResult.class);
                                if (httpResult != null) {
                                    if (httpResult.getCode() != 200) {//失败
                                        httpCallBack.onFail(httpResult.getMsg());
                                    } else {//成功
                                        //获取data对应的json字符串
                                        String json = mGson.toJson(httpResult.getData());
                                        if (type == String.class) {//泛型是String，返回结果json字符串
                                            httpCallBack.onSuccess((T) json);
                                        } else {//泛型是实体或者List<>
                                            T t = mGson.fromJson(json, type);
                                            httpCallBack.onSuccess(t);
                                        }
                                    }
                                }
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (httpCallBack == null) {
                        return;
                    }
                    String msg = error.getMessage();
                    httpCallBack.onFail(msg);
                }
            });
        }

        //设置请求超时和重试
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(REQUEST_TIMEOUT_TIME, 1, 1.0f));
        //加入到请求队列
        if (mRequestQueue != null)
            mRequestQueue.add(stringRequest.setTag(mUrl));
    }


    private Type getTType(Class<?> clazz) {
        Type mySuperClassType = clazz.getGenericSuperclass();
        Type[] types = ((ParameterizedType) mySuperClassType).getActualTypeArguments();
        if (types != null && types.length > 0) {
            //T
            return types[0];
        }
        return null;
    }

   */
/* @Override
    public void onResponse(String response) {
        if (httpCallBack == null) {
            return;
        }
        Type type = getTType(httpCallBack.getClass());
        if (response.contains("<!DOCTYPE html>")) {
            httpCallBack.onSuccess((T) response);
        } else {
            HttpResult httpResult = mGson.fromJson(response, HttpResult.class);
            if (httpResult != null) {
                if (httpResult.getCode() != 200) {//失败
                    httpCallBack.onFail(httpResult.getMsg());
                } else {//成功
                    //获取data对应的json字符串
                    String json = mGson.toJson(httpResult.getData());
                    if (type == String.class) {//泛型是String，返回结果json字符串
                        httpCallBack.onSuccess((T) json);
                    } else {//泛型是实体或者List<>
                        T t = mGson.fromJson(json, type);
                        httpCallBack.onSuccess(t);
                    }
                }
            }
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (httpCallBack == null) {
            return;
        }
        String msg = error.getMessage();
        httpCallBack.onFail(msg);
    }*//*

}*/
