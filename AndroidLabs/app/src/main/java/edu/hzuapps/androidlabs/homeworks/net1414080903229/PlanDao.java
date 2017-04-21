package edu.hzuapps.androidlabs.homeworks.net1414080903229;

/**
 * Created by Administrator on 2017-4-21.
 */

public class PlanDao {
    private String planid;
    private String plananme;
    private String plantime1;
    private String plancontext1;
    private String plantime2;
    private String plancontext2;
    private String plantime3;
    private String plancontext3;

    //添加数据
    public void Insert(String p,String pt1,String pc1,String pt2,String pc2,String pt3,String pc3){
        this.plananme=p;
        this.plantime1=pt1;
        this.plancontext1=pc1;
        this.plantime2=pt2;
        this.plancontext2=pc2;
        this.plantime3=pt3;
        this.plancontext3=pc3;
    }
    //删除数据
    public void DeteleById(String planid){

    }
    //修改数据
    public void UpdateById(String planid){

    }
    //查询数据
    public void FindById(String planid){

    }
}
