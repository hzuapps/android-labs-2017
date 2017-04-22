package edu.hzuapps.androidlabs.homeworks.net1414080903240;

/**
 * Created by Administrator on 2017/4/22.
 */

public class order {
    private String value;
    private String data;
    private String remark;
    private String project;


    public void order(String a,String b,String c,String d){
        value=a;
        data=c;
        remark=d;
        project=b;
    }
    public String getValue() { return value;  }
    public void setValue(String a) { this.value =a;}
    public String getData() { return data;  }
    public void setData(String a) { this.data =a;}
    public String getRemark() { return remark;  }
    public void setRemark(String a) { this.remark =a;}
    public String getProject() { return project;  }
    public void setProject(String a) { this.project =a;}

}
