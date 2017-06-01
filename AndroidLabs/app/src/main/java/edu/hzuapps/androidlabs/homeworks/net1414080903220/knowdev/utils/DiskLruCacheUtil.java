package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.jakewharton.disklrucache.DiskLruCache;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.KnowApplication;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils
 * Class describe:封装DiskLruCache，进行缓存管理
 * Author: cheng
 * Create time: 2017/5/31 16:06
 */
public class DiskLruCacheUtil {

    private static String TAG="DiskLruCacheUtil";
    private static String WRITE_SUCCESS="写入成功";
    private static String WRITE_ERROR="写入失败";
    private static String READ_SUCCESS="读取成功";
    private static String READ_ERROR="读取失败";

    private static DiskLruCache diskLruCache;
    private DiskLruCache.Editor cacheEditor = null;
    private DiskLruCache.Snapshot cacheSnapshot=null;
    public DiskLruCacheUtil(Context context,String uniqueName){
        try {
        if(diskLruCache!=null) {
            diskLruCache.close();
            diskLruCache = null;
            }
            File cachePath=getDiskCachePath(context,uniqueName);
            Log.i("THE PATH IS",""+cachePath);

            diskLruCache=DiskLruCache.open(cachePath, KnowApplication.getAppVersion(),1,1024*1024);
        } catch (IOException e) {
                e.printStackTrace();
            }
        }


     /**
      * Method:  getDiskCacheDir
      * desription: 获取缓存路径
      * @Param:
      * @return:
      */
    public File getDiskCachePath(Context context, String uniqueName){
        String cachePath=null;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())|| !Environment.isExternalStorageRemovable()){
            cachePath=context.getExternalCacheDir().getPath();
        }else{
            cachePath=context.getCacheDir().getPath();
        }
        return new File(cachePath+File.separator+uniqueName);
    }

     /**
      * Method:  cacheEdit
      * desription: 实例化DiskLruCache.Editor：执行缓存的写入对象
      * @Param:
      * @return:
      */
    private DiskLruCache.Editor getCacheEdit(String key) throws IOException {
        key=MD5Util.getMD5Key(key);
        if(key!=null){
            Log.i("THE key is",key);
            if(diskLruCache!=null){
                cacheEditor=diskLruCache.edit(key);
            }

        }
        return cacheEditor;
    }

    private DiskLruCache.Snapshot getSnapshot(String key) throws IOException {
        if(diskLruCache!=null){
            cacheSnapshot=diskLruCache.get(key);

        }
        return cacheSnapshot;
    }

     /**
      * Method:  writeCache
      * desription: 写入缓存
      * @Param:
      * @return:
      */
    public void writeCache(String key,String value) throws IOException {
        DiskLruCache.Editor editor = null;
        BufferedWriter writer=null;
        try {
            editor=getCacheEdit(key);
            if(editor==null){
                return;
            }
            OutputStream os=editor.newOutputStream(0);
            writer=new BufferedWriter(new OutputStreamWriter(os));
            writer.write(value);
            editor.commit();
            Log.i(TAG,WRITE_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,WRITE_ERROR);
            if(editor!=null){
                editor.abort();
            }
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }

     /**
      * Method:  readCache
      * desription: 读取缓存
      * @Param:
      * @return:
      */
    public String readCache(String key){
        InputStream is=getCacheInputStream(key);
        if(is==null){
            return null;
        }
        try {
            return inputStreamToString(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private InputStream getCacheInputStream(String key){
        key=MD5Util.getMD5Key(key);
        InputStream is=null;
        try {
            DiskLruCache.Snapshot snapshot=getSnapshot(key);
            if(snapshot==null){
                return null;
            }
            is=snapshot.getInputStream(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

    private String inputStreamToString(InputStream is)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

     /**
      * Method:  writeJsonObjectCache
      * desription: 写入jsonObject对象
      * @Param:
      * @return:
      */
    public void writeJsonObjectCache(String key, JSONObject value) throws IOException{
        writeCache(key,value.toString());
    }

     /**
      * Method:  readJsonObjectCache
      * desription: 读取jsonobject对象
      * @Param:
      * @return:
      */
    public JSONObject readJsonObjectCache(String key)throws IOException{
        String json=readCache(key);
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeJsonArrayCache(String key,String value)throws IOException{
        writeCache(key,value.toString());
    }

    public JSONArray readJsonArrayCache(String key)throws IOException{
        String json=readCache(key);
        try {
            return new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

     /**
      * Method:  writeObject
      * desription: 写入序列化后的对象
      * @Param:
      * @return:
      */
    public void writeObject(String key, Serializable object){
        ObjectOutputStream oos=null;
        DiskLruCache.Editor editor=null;
        try {
            editor=getCacheEdit(key);
            if(editor==null){
                return;
            }
            oos=new ObjectOutputStream(editor.newOutputStream(0));
            oos.writeObject(object);
            oos.flush();
            editor.commit();
            Log.i(TAG,WRITE_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            if(editor!=null){
                try {
                    editor.abort();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    Log.i(TAG,WRITE_ERROR);
                }
            }
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


     /**
      * Method: readObject
      * desription: 读取对象
      * @Param:
      * @return:
      */
    public <T>T readObject(String key){
        T object=null;
        ObjectInputStream ois=null;
        InputStream is=getCacheInputStream(key);
        if(is==null){
            return null;
        }
        try {
            ois=new ObjectInputStream(is);
            object=(T)ois.readObject();
            Log.i(TAG,READ_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.i(TAG,READ_ERROR);
        }
        return object;

    }

    //用来同步
    public static void flush(){
        if(diskLruCache!=null){
            try {
                diskLruCache.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
