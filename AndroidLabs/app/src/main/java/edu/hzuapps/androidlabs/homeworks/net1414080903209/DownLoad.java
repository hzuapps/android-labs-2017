package edu.hzuapps.androidlabs.homeworks.net1414080903209;

/**
 * Created by Administrator on 2017/4/21.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author Administrator
 */
public class DownLoad {
    final int  THREADCOUNT = 3;
    String urlLocation;
    String filePath;
    long[] threadid;
    long contentLength;
    public DownLoad(String url,String filePath)throws IOException{
        this.urlLocation=url;
        this.filePath=filePath;
        contentLength =  DownLoadThread.getContentLength(urlLocation);
    }
    ThreadGroup tg = Thread.currentThread().getThreadGroup();
    boolean isNew = true;
    public void Start() throws IOException {
        if(isNew){
            String fileName = DownLoadThread.getFileName(urlLocation);
            RandomAccessFile accessfile = new RandomAccessFile(filePath + fileName, "rw");
            accessfile.setLength(contentLength);
        }
        long threadsize = contentLength / THREADCOUNT;
        for (int i = 0; i < THREADCOUNT; i++) {
            long start = i * threadsize;
            long end = (i + 1) * threadsize - 1;
            if (i == THREADCOUNT - 1) {
                end = contentLength - 1;
            }
            Thread downloadThread = new Thread(tg,new DownLoadThread(urlLocation, filePath, start, end, i),i+"");
            downloadThread.start();

        }
    }
    public void pause()
    {
        tg.interrupt();
    }

    public void goOn() throws IOException
    {
        this.isNew=false;
        Start();
    }

}
