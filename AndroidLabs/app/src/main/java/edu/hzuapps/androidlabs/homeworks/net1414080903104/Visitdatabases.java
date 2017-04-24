package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * 实现封装基本的数据库操作的类
 * 代码参考javaweb应用开发教材中“数据库访问javabean的设计”
 * (待测)
 */
import java.sql.*;
import java.util.*;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Linkdatabases;

public class Visitdatabases {
	public Accessdata findonecard(int id)throws Exception{//响应“抽卡”按钮的实现过程中的根据id访问数据库并获取相关数据
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Accessdata onecard=null;
		try {
			conn = Linkdatabases.getConnection();
			String sql = "select *from cardgames where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				onecard=new Accessdata();
				onecard.setId(rs.getInt(1));
				onecard.setName(rs.getString(2));
				onecard.setLevel(rs.getString(3));
				onecard.setBackground(rs.getString(4));
				onecard.setStrength(rs.getString(5));
				onecard.setDefensive(rs.getString(6));
				onecard.setHp(rs.getString(7));
			}
		}finally {Linkdatabases.free(rs, ps, conn);}
		return onecard;
	}
	public List<Accessdata> Querycard()throws Exception{//响应“查看每日卡牌池”按钮的实现过程中的访问数据库内所有卡牌的id、name、level
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Accessdata> cardList=new ArrayList<Accessdata>();
		try {
			conn = Linkdatabases.getConnection();
			String sql = "select id name level from cardgames";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				Accessdata allcard=new Accessdata();
				allcard.setId(rs.getInt(1));
				allcard.setName(rs.getString(2));
				allcard.setLevel(rs.getString(3));
				cardList.add(allcard);
			}
		}finally {Linkdatabases.free(rs, ps, conn);}
		return cardList;
	}

}
