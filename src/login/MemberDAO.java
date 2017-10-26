package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.ConnectionPool;

public class MemberDAO {
	public MemberVO login(MemberVO vo) throws Exception {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			con = ConnectionPool.getConnection();
			
			sql.append("select * from tb_member where id = ? and pass = ?");
			
			ptmt=con.prepareStatement(sql.toString());
			
			ptmt.setString(1, vo.getId());
			ptmt.setString(2, vo.getPass());
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setAdmin(rs.getString("admin"));
				
				return vo;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			ConnectionPool.releaseConnection(con);
		}
		
		
		
		return null;
	}
}
