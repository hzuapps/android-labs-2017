package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils
 * Class describe: MD5加密类
 * Author: cheng
 * Create time: 2017/5/31 16:54
 */
public class MD5Util {

    public static String getMD5Key(String value){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(value.getBytes("UTF-8"));
            byte[]result=messageDigest.digest();
            String key=getString(result);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getString(byte[] result) {
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            int i = b & 0xff;
            if (i <= 0xf) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toLowerCase();
    }
}
