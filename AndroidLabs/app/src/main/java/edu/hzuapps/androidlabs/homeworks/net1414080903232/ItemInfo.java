package homeworks.androidlabs.hzuapps.edu.net141408090323.cn.itcast.domain;

import java.io.Serializable;

/**
 * Created by pc on 2017/4/16.
 */

public class ItemInfo implements Serializable {
    private Long id;
    private String name;
    private String TB_name;
    private String time;
    private String address;
    private String phone_number;
    private String detail;
   public ItemInfo(String name, String TB_name, String time, String address, String phone_number, String detail){
       this.address = address;
       this.detail = detail;
       this.name = name;
       this.phone_number = phone_number;
       this.TB_name = TB_name;
       this.time = time;
   }
    public  void setId(Long id){this.id=id;}
    public Long getId(){return id;}
    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getTime() {
        return time;
    }

    public String getTB_name() {
        return TB_name;
    }

}
