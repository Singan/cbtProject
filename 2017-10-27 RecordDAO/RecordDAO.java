package manage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionPool;

public class RecordDAO {
	
	PreparedStatement ptmt;
	ResultSet rs;
	
	// ========== 기록 ==========
	//TODO 기록 목록
	public List<RecordDomain> listRecord(String id) throws Exception {
		List<RecordDomain> res = new ArrayList<RecordDomain>();
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select * from tb_record"
				+ " where id = ?"
				+ " order by record_no desc");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setString(1, id);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				RecordDomain record = new RecordDomain();
				
				record.setRecordNo(rs.getInt("record_no"));
				record.setId(id);
				record.setTestCode(rs.getInt("test_code"));
				record.setScore(rs.getInt("score"));
				record.setRecordDate(rs.getTimestamp("record_date"));
				
				res.add(record);
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		
		return res;
	}
	
	//TODO 기록 상세
		public List<RecordDetailsDomain> listRecordDetails(int record_no) throws Exception {
			List<RecordDetailsDomain> res = new ArrayList<RecordDetailsDomain>();
			Connection con = null;
			StringBuffer sql = new StringBuffer();
		
			sql.append("select * from tb_record_details"
					+ " where record_no = ?"
					+ " order by quiz_no");
			
			try {
				con = ConnectionPool.getConnection();
				ptmt = con.prepareStatement(sql.toString());
				
				ptmt.setInt(1, record_no);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					RecordDetailsDomain recordDetails = new RecordDetailsDomain();
					
					recordDetails.setRecordNo(rs.getInt("record_no"));
					recordDetails.setQuizNo(rs.getInt("quiz_no"));
					recordDetails.setRecordResult(rs.getString("record_result"));
					recordDetails.setRecordAnswer(rs.getInt("record_answer"));
					recordDetails.setQuizAnswer(rs.getInt("quiz_answer"));
					
					res.add(recordDetails);
				}
			}catch(Exception e){
				throw e;
			}finally{
				ConnectionPool.releaseConnection(con);
				close();
			}
			
			return res;
		}
	
	//TODO 클로즈
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {}
	}
}
