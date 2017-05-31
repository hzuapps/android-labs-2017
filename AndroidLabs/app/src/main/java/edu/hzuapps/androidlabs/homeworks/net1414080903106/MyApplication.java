package edu.hzuapps.androidlabs.homeworks.net1414080903106;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */

public class MyApplication extends Application {
    List<Net1414080903106City> cityList;
    Net1414080903106CityDB mCityDB;
    private static Application mApp;
    @Override
    public void onCreate() {
        super.onCreate();

        mApp=this;

        mCityDB=openCityDB();
        initCityList();
    }

    public static Application getInstance(){
        return mApp;
    }

    public Net1414080903106CityDB openCityDB(){
        String path="/data"
                + Environment.getDataDirectory().getAbsolutePath()
                + File.separator+getPackageName()
                +File.separator+Net1414080903106CityDB.CITY_DB_NAME;
        File db=new File(path);
        try{
            InputStream is=getAssets().open("city.db");

            FileOutputStream fos=new FileOutputStream(db);
            int len=-1;
            byte[] buffer=new byte[1024];
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
                fos.flush();
            }
            fos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return new Net1414080903106CityDB(this,path);
    }

    private boolean prepareCityList(){
        cityList=mCityDB.getCityList();
        for(Net1414080903106City city:cityList){
            String cityName=city.getCity();
            Log.d("CityDB",cityName);
        }
        return true;
    }

    private void initCityList(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareCityList();
            }
        }).start();
    }

    public List<Net1414080903106City> getCityList(){
        return cityList;
    }
}

