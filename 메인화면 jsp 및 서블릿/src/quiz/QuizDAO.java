package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionPool;

public class QuizDAO {
	public List<QuizVO> overview(int test_code) throws Exception{
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		List<QuizVO> list = new ArrayList();
		
		try {
			con = ConnectionPool.getConnection();
			
			sql.append("select distinct quiz_sub, quiz_no ")
			   .append("from tb_test_quiz ")
			   .append("where last_no='y' and test_code = ( ")
			   .append("select test_code ")
			   .append("from tb_test ")
			   .append("where group_code = ? ")
			   .append("and rownum = 1) ")
			   .append("order by quiz_sub");
			
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, test_code);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				QuizVO vo = new QuizVO();
				
				vo.setQuiz_sub(rs.getString("quiz_sub"));
				vo.setLast_no(rs.getInt("quiz_no"));
				
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
