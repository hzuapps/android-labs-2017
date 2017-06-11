//操作数据库时存放数据的类
package edu.hzuapps.androidlabs.homeworks.net1414080903224;

public class N1414080903224Address {
    private Long id;
    private  String url;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public  String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public N1414080903224Address(String url){
        super();
        this.url=url;
    }
}
