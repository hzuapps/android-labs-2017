package edu.hzuapps.androidlabs.homeworks.net1414080903116;


public class Net1414080903116TextDynamic {
    private Long id;
    private String promulgator;
    private String text_dynamic;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getPromulgator(){
        return promulgator;
    }
    public void setPromulgator(String promulgator){
        this.promulgator=promulgator;
    }
    public String getText_dynamic(){
        return text_dynamic;
    }
    public void setText_dynamic(String text_dynamic){
        this.text_dynamic=text_dynamic;
    }
    public Net1414080903116TextDynamic(long id,String promulgator,String text_dynamic){
        super();
        this.id=id;
        this.promulgator=promulgator;
        this.text_dynamic=text_dynamic;
    }
    public Net1414080903116TextDynamic(String promulgator,String text_dynamic){
        super();
        this.promulgator=promulgator;
        this.text_dynamic=text_dynamic;
    }
    public Net1414080903116TextDynamic(){
        super();
    }
}
