package edu.hzuapps.androidlabs.homeworks.net1414080903201;

public class Net1414080903201User {
    private String userName;
    private String userPassword;
    private String userSex;
  
    
    public Net1414080903201User(String userName,String userPwd,String userSex){
    	this.userName=userName;
    	this.userPwd=userPwd;
    	this.userSex=userSex;
    }
    public Net1414080903201User(){
    	
    }
    
    public String getUserName(){
    	return userName;
    }
    public void setUserName(){
    	this.userName=userName;
    }
    
    public String getUserPwd(){
    	return userPwd;
    }
    public void setUserPwd(){
    	this.userPwd=userPwd;
    }
    
    public String getUserSex(){
    	return userSex;
    }
    public void setUserSex(){
    	this.userSex=userSex;
    }
  
}
