package edu.hzuapps.androidlabs.homeworks.net1414080903209;

/**
 * Created by Administrator on 2017/4/21.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public class Position {
    public static long readPosition(String filePath, int threadID) throws IOException {
        long position = 0;
        File file = new File(filePath + threadID + ".txt");
        if (file.exists() && file.length() > 0) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(fis));
            String lastPosition = buf.readLine();
            fis.close();
        }
        return position;
    }

    public static boolean writePosition(String filePath, int threadID, long position) throws IOException {
        RandomAccessFile saveRaf = new RandomAccessFile(filePath + threadID + ".txt", "rwd");
        saveRaf.write(String.valueOf(position).getBytes());
        saveRaf.close();
        return true;
    }

    public static boolean delPosition(String filePath, int threadID) throws IOException {
        File delfile = new File(filePath + threadID + ".txt");
        delfile.delete();
        return true;
    }
}