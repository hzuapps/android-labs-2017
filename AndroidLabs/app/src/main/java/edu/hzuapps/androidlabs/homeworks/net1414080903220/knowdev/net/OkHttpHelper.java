package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net
 * Class describe:封装的网络请求类
 * Author: cheng
 * Create time: 2017/6/2 11:14
 */
public class OkHttpHelper {

    public static final String TAG="OkHttpHelper";

    private static OkHttpHelper okInstance;
    private OkHttpClient okHttpClient;
    private Gson gson;
    private Handler handler;

    //单例模式，官方推荐的写法
    static {
        okInstance=new OkHttpHelper();
    }
    public static OkHttpHelper getOkInstance(){
        return okInstance;
    }

    public OkHttpHelper(){
        okHttpClient=new OkHttpClient();
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(10,TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(30,TimeUnit.SECONDS);
        gson=new Gson();
        handler=new Handler(Looper.getMainLooper());
    }


   //自定义的get方法
    public void get(String apiSource,String url, Map<String,String>params, BaseCallback callBack){
        Request request=buildRequest(apiSource,url,"GET",params);
        request(request,callBack);
    }


    //自定义的post方法
    public void post(String apiSource,String url, BaseCallback callBack, Map<String,String>params){
        Request request=buildRequest(apiSource,url,"GET",params);
        request(request,callBack);
    }

     /**
      * Method:  request
      * desription: 执行网络请求
      * @Param:
      * @return:
      */
    public void request(final Request request,final BaseCallback callBack){
        callBack.onBeforeRequest(request);
        okHttpClient.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {

        }

        @Override
        public void onResponse(Response response) throws IOException {
            callBack.onResponse(response);
            if(response.isSuccessful()){
                String result=response.body().string();
                Log.i(TAG,result);
                if(callBack.mType==String.class){
                    requestSuccess(callBack,response,result);
                }else {

                    Object object=gson.fromJson(result,callBack.mType);
                    requestSuccess(callBack,response,object);
                }
            }
            else{
                Looper.prepare();
                callBack.onError(response,response.code(),null);
                Looper.loop();
            }
        }
    });
}

     /**
      * Method:  requestSuccess
      * desription: 处理请求成功后的结果
      * @Param:
      * @return:
      */
    private void requestSuccess(final BaseCallback callback, final Response response, final Object obj ){
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response,obj);
            }
        });
    }

    private void callError(final BaseCallback callBack,final Response response,final Exception e ){
        handler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onError(response,response.code(),e);
            }
        });
    }
     /**
      * Method:  buildRequest
      * desription: 构建请求对象Request
      * @Param:
      * @return:
      */
    private Request buildRequest(String source,String url,String type,Map<String,String>params){
        Request.Builder builder=new Request.Builder().url(url);
        if(type.equals("GET")){
            String encodeParams=buildGetParams(source,params);
            url=url+encodeParams;
            Log.i(TAG,url);
            builder.url(url);
            builder.get();
        }else if(type.equals("POST")){
            RequestBody requestBody=buildPostParams(params);
            builder.post(requestBody);
        }
        return builder.build();
    }


     /**
      * Method:  buildGetParams
      * desription: 对get方法的参数进行格式化,由于两个是不同的接口，因此分别处理
      * @Param:
      * @return:
      */
    private String buildGetParams(String source,Map<String,String>params){
        String formatParams="";
        if(source.equals("tx")){
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey() + "=" + entry.getValue());
                sb.append("&");
            }
            formatParams = sb.toString();
            if (formatParams.endsWith("&")) {
                formatParams = formatParams.substring(0, formatParams.length() - 1);
            }
            formatParams="?"+formatParams;
        }
        else if(source.equals("gank")){

            for (Map.Entry<String, String> entry : params.entrySet()) {
                String p=entry.getValue();
                formatParams=formatParams+"/"+p;
            }
        }
        return formatParams;
    }


     /**
      * Method:  buildFormParams
      * desription: 进行post参数的添加,暂时用不到
      * @Param:
      * @return:
      */
    private RequestBody buildPostParams(Map<String,String>params){
        FormEncodingBuilder encodingBuilder=new FormEncodingBuilder();
        if(params!=null){
            for(Map.Entry<String,String>entry:params.entrySet()){
                encodingBuilder.add(entry.getKey(),entry.getValue());
            }
        }
        return encodingBuilder.build();
    }





/*    public Request buildGetRequest(String url){
        return null;
    }

    public Request buildPostRequest(String url,Map<String,String> params){
        return null;
    }*/









}
