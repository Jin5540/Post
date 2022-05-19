package com.jslhrd.dao;

import com.jslhrd.dto.MemberVO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class MemberDAO {
	//싱글톤
	private MemberDAO()
	{
	}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance()
	{
		return instance;
	}

	public Connection getConnection()
	{
		//옛날방식
		Connection conn = null;
		String url="jdbc:mysql://localhost:3306/yesjin";
		String db_id="yesjin";
		String db_pwd="123456";	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,db_id,db_pwd);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return conn;
		//스피링(컨넥션 풀)
	}
	
	public int insertMember(MemberVO mVo)
	{
		int result=-1; //-1 --> 1;
		String sql = "insert into m(name,userid,pwd,email,phone,admin,date) values(?,?,?,?,?,?,?)";
		Connection conn =null;
		PreparedStatement pstmt =null;
	      Date nowTime = new Date();
	      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//DB연결
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			pstmt.setString(7,sf.format(nowTime));
			result = pstmt.executeUpdate(); //1,X
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	/*p482*/
	public int userCheck(String userid, String pwd)
	{
		int result=-1;
		String sql = "select * from m where userid=?";
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd) )
				{
					result = 1; //회원가입된 상태다.
				} else {
					result = 0; //암호가 틀린거다.
				}
			} else {
				
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	/*p483*/
	public MemberVO getMember(String userid)
	{
		MemberVO mVo=null;
		String sql = "select * from m where userid=?";
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));				
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return mVo;
	}
	
	public int updateMember(MemberVO mVo)
	{
		/*p511*/
		int result=-1;
		String sql = "update m set pwd=?,email=?,";
		       sql += "phone=?,admin=? where userid=?";
		
		Connection conn=null;
		PreparedStatement pstmt =null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mVo.getPwd());
			pstmt.setString(2,mVo.getEmail());
			pstmt.setString(3,mVo.getPhone());
			pstmt.setInt(4,mVo.getAdmin());
			pstmt.setString(5,mVo.getUserid());		
			result =pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return result; //1,0
		
	}
	
	public int dropMember(String userid)
	{
		/*p511*/
		int result=-1;
		String sql = "delete from m where userid=?";
		
		Connection conn=null;
		PreparedStatement pstmt =null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);	
			result =pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return result; //1,0
		
	}
	
	public int confirmID(String userid)
	{
		
		/*p495*/
		int result=-1;
		String sql = "select userid from m where userid=?";
		
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);	
			rs =pstmt.executeQuery();
			if(rs.next())
			{
				result = 1;
				
			} else {
				
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();				
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return result; //1,0

	}
}