package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net;

import com.google.gson.internal.$Gson$Types;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net
 * Class describe:OKHttp请求回调类，此类的编写参考了网上的部分写法
 * Author: cheng
 * Create time: 2017/6/2 13:32
 */
public abstract class BaseCallback<T> {
    public Type mType;

    static Type getSuperclassTypeParameter(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();//获得带有泛型的父类
        if (superclass instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;////ParameterizedType参数化类型，即泛型
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]); //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
    }


    public BaseCallback()
    {
        mType = getSuperclassTypeParameter(getClass());
    }



    public  abstract void onBeforeRequest(Request request);


    public abstract  void onFailure(Request request, Exception e) ;



    public abstract  void onResponse(Response response);


    public abstract void onSuccess(Response response,T t) ;


    public abstract void onError(Response response, int code, Exception e) ;
}
