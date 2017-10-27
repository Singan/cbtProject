package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionPool;

public class TestDAO {
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
			// TODO Auto-generated catch block
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public List<TestVO> subject(int code) throws Exception {
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
			// TODO Auto-generated catch block
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
	}
}
