package edu.hzuapps.androidlabs.homeworks.net1414080903104;

public class Sentence {
	public String name;
	public String time;
	public String offer;
	public String toString() {
		return name+"/n"+time+"/n"+offer;
		
	}
	public void setName(String name){this.name=name;}
	public String getName(){
		return name;
	}
	public void setTime(String time){this.time=time;}
	public String getTime(){
		return time;
	}
	public void setOffer(String offer){this.offer=offer;}
	public String getOffer(){
		return offer;
	}

}
