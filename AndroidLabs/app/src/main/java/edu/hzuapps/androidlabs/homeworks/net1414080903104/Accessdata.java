package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * 实现记录信息数据化，基于对象对数据库关系表进行操作
 * 一个javabean类，定义的变量均为卡牌的内容
 * 
 */
public class Accessdata {
	private int id;//定义私有变量id，
	private String name,level,background;//定义私有变量名字name、等级level、背景资料background
	private String strength,defensive,hp;//定义私有变量力量值strength、防御值defensive、血量值hp
	public Accessdata(){}
	public Accessdata(int id,String name,String level,String background,String strength,String defensive,String hp){
		setId(id);
		setName(name);
		setLevel(level);
		setBackground(background);
		setStrength(strength);
		setDefensive(defensive);
		setHp(hp);
	}
	public Accessdata(int id,String name,String level){
		setId(id);
		setName(name);
		setLevel(level);
	}
	public int getId(){return id;}
	public void setId(int id){this.id=id;}
	public String getName(){return name;}
	public void setName(String name){this.name=name;}
	public String getLevel(){return level;}
	public void setLevel(String level){this.level=level;}
	public String getBackground(){return background;}
	public void setBackground(String background){this.background=background;}
	public String getStrength(){return strength;}
	public void setStrength(String strength){this.strength=strength;}
	public String getDefensive(){return defensive;}
	public void setDefensive(String defensive){this.defensive=defensive;}
	public String getHp(){return hp;}
	public void setHp(String hp){this.hp=hp;}
}
