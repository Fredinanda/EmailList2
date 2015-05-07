package com.sds.icto.emaillist.dao;

import java.sql.*;
import java.util.*;


import com.sds.icto.emaillist.vo.EmailListVo;

public class EmailListDao {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
			Connection conn = null;
			//1. 드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
			//2. connection 생성
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
			return conn;
	}
		
	public void insert( EmailListVo vo) 
			throws ClassNotFoundException, SQLException{
		// Connection 생성
		Connection conn = getConnection();
			
		//2. Statement(SQL) 준비
		String sql = 
		"insert into EMAIL_LIST VALUES(email_list_no_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement( sql );
			
		//3.binding
		pstmt.setString( 1, vo.getFirst_name() );
		pstmt.setString( 2, vo.getLast_name() );
		pstmt.setString( 3, vo.getEmail() );
			
		//4. query 실행
		pstmt.executeUpdate();

		//5. 자원정리
		if( pstmt != null ) {
			pstmt.close();
		}
		
		if( conn != null ) {
			conn.close();
		}
		
	}
	
	public void delete( Long id ) throws ClassNotFoundException, SQLException{
		
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		
		//1. Connection 생성
		Connection conn = getConnection();
		//2. statment 생성
		Statement stmt = conn.createStatement();
		//3 쿼리실행
		String sql = "delete from email_list";
		stmt.executeUpdate(sql);
		
		
		//4자원정리
		if( stmt != null ) {
			stmt.close();
		}
		
		if( conn != null ) {
			conn.close();
		}

		
	}
	
 	public List<EmailListVo> fetchList() throws ClassNotFoundException, SQLException {
		List<EmailListVo> list = new ArrayList<EmailListVo>();

		//1. Connection 생성
		Connection conn = getConnection();
		
		//2. statment 생성
		Statement stmt = conn.createStatement();
			
		//3. SQL문 실행
		String sql =
			"select * from EMAIL_LIST";
		ResultSet rs = stmt.executeQuery(sql);
			
		//4. 결과 처리
		while( rs.next() ) {
			Long no = rs.getLong(1);
			String f_name = rs.getString( 2 );
			String l_name = rs.getString( 3 );
			String mail = rs.getString( 4 );
				
			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirst_name(f_name);
			vo.setLast_name(l_name);
			vo.setEmail(mail);
				
			list.add( vo );
		}
		
		//5. 자원정리
		if( rs != null ) {
			rs.close();
		}
		
		if( stmt != null ) {
			stmt.close();
		}
		
		if( conn != null ) {
			conn.close();
		}

		return list;
		
	}

}
