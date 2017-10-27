package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.ConnectionPool;

public class MemberDAO {
	
	public void insertMember(MemberDomain domain) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into tb_member ( ")
			   .append("	id, ")
			   .append("	pass, ")
			   .append("	name ")
			   .append(") values ( ")
			   .append("	?, ?, ?")
			   .append(")	");
			   
			   pstmt = con.prepareStatement(sql.toString());
			   
			   pstmt.setString(1, domain.getId());
			   pstmt.setString(2, domain.getPass());
			   pstmt.setString(3, domain.getName());
			   
			   pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionPool.releaseConnection(con);
		}
			
	}
	
	public MemberDomain idChkMember(MemberDomain domain) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("select id ")
			   .append("	from tb_member ")
			   .append("	where id = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, domain.getId());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberDomain user = new MemberDomain();
				user.setId(domain.getId());
				return user;
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {}
			ConnectionPool.releaseConnection(con);
		}
		return null;
			
		
	}
	
	
	
}