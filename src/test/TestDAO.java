package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionPool;

public class TestDAO {
	//TODO Object 리스트를 구하는 메소드
	public String nowtest(int testcode) throws Exception {
		String now = "";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			con = ConnectionPool.getConnection();
			
			sql.append("select test_name from tb_test where test_code = ?");
			
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, testcode);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				now = rs.getString("test_name");
			}
			
			return now;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public List<TestVO> object() throws Exception {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			con = ConnectionPool.getConnection();
			sql.append("select * ")
			   .append("from tb_test ")
			   .append("where group_code = 0");
			
			ptmt = con.prepareStatement(sql.toString());
			
			rs = ptmt.executeQuery();
			List list = new ArrayList<>();
			while(rs.next()) {
				TestVO vo = new TestVO();
				
				vo.setCode(rs.getInt("test_code"));
				vo.setObject(rs.getString("test_name"));
				
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public List<TestVO> subject(int code) throws Exception {
		//TODO subject의 리스트를 구하는 메소드, turn도 subject와 같은 방식
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			con = ConnectionPool.getConnection();
			sql.append("select * from tb_test where group_code = ?");
			
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, code);
			
			rs = ptmt.executeQuery();
			List<TestVO> list = new ArrayList<>();
			while(rs.next()) {
				TestVO vo = new TestVO();
				
				vo.setCode(rs.getInt("test_code"));
				vo.setSubject(rs.getString("test_name"));
				
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public List<TestVO> mocklist(int testCode, int groupCode) throws Exception{
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		List<TestVO> list = new ArrayList();
		
		try {
			con = ConnectionPool.getConnection();
			
			sql.append("select * ")
			   .append("from tb_test ")
			   .append(" where test_date>=(")
			   .append("select test_date ")
			   .append("from tb_test ")
			   .append("where test_code = ?)")
			   .append(" and group_code = ?");
			
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, testCode);
			ptmt.setInt(2, groupCode);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				TestVO vo = new TestVO();
				
				vo.setTurn(rs.getString("test_name"));
				vo.setCode(rs.getInt("test_code"));
				
				list.add(vo);
			}
			
			return list;
		} catch (Exception e) {
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
		
		
	}
}
