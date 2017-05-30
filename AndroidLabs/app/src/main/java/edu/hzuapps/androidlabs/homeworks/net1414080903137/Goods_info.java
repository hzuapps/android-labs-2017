package edu.hzuapps.androidlabs.homworks.net1414080903137;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/30.
 */

public class Goods_info implements Serializable{
    private int goodsid;
    private String goodsname;
    private String goodsnumber;
    public int getGoodsid(){
        return goodsid;
    }
    public void setGoodsid(int goodsid){
        this.goodsid=goodsid;
    }
    public String getGoodsname(){
        return goodsname;
    }
    public void setGoodsname(String goodsname){
        this.goodsname=goodsname;
    }
    public String getGoodsnumber(){
        return goodsnumber;
    }
    public void setGoodsnumber(String goodsnumber){
        this.goodsnumber=goodsnumber;
    }
}
