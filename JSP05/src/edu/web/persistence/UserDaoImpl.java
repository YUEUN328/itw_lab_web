package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import edu.web.domain.User;

import static edu.web.domain.User.Entry.*;

public class UserDaoImpl implements UserDao {

	private DataSource ds;
	
	// singleton 패턴
	private static UserDaoImpl instance = null;
	
	private UserDaoImpl() {
		ds = DataSourceUtil.getDataSource(); 
	};
	
	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int update(int points, String userId) {
		System.out.println("userDaoImpl.update(" + points + ", " + userId + ") 메서드 호출");
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// Connection Pool에서 Connection 객체를 빌려옴
			conn = ds.getConnection();
			
			// DB에서 실행할 SQL 문장을 완성
			pstmt = conn.prepareStatement(SQL_UPDATE_USER_POINTS);
			System.out.println(SQL_UPDATE_USER_POINTS);
			pstmt.setInt(1, points); // SQL의 첫 번째 ?를 points(정수)로 대체
			pstmt.setString(2, userId); // SQL의 두 번째 ?를 userId(문자열)로 대체
			
			// SQL 문장 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 사용했던 리소스 반환 - Connection 객체를 Connection Pool로 반환
				DataSourceUtil. close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<User> read() {
		System.out.println("userDaoImpl.read() 메서드 호출");
		
		List<User> list = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			System.out.println(SQL_SELECT_ALL);
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String userid = rs.getString(COL_USERID);
				String pwd = rs.getString(COL_PWD);
				String email = rs.getString(COL_EMAIL);
				int points = rs.getInt(COL_POINTS);
				
				User user = new User(userid, pwd, email, points);
				
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtil.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return list;
	}

	@Override
	public int create(User user) {
		System.out.println("userDaoImpl.create(user) 메서드 호출");
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(SQL_INSERT_USER);
			System.out.println(SQL_INSERT_USER);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getEmail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 사용했던 리소스 반환 - Connection 객체를 Connection Pool로 반환
				DataSourceUtil.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public User read(String userid) {
		System.out.println("userDaoImpl.read(userid=" + userid + ") 메서드 호출");
		
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			System.out.println(SQL_SELECT_BY_USERID);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { // 검색된 결과가 있으면
				String pwd = rs.getString(COL_PWD);
				String email = rs.getString(COL_EMAIL);
				int points = rs.getInt(COL_POINTS);
				
				user = new User(userid, pwd, email, points);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtil.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
}