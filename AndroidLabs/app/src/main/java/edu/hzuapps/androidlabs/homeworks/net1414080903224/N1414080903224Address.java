//操作数据库时存放数据的类
package edu.hzuapps.androidlabs.homeworks.net1414080903224;

public class N1414080903224Address {
    private Long id;
    private  String path;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public  String getPath(){
        return path;
    }
    public void setPath(String url){
        this.path=path;
    }
    public N1414080903224Address(String path){
        super();
        this.path=path;
    }
}
