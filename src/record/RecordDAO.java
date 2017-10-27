package record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import common.ConnectionPool;
import quiz.ExampleVO;
import quiz.QuizVO;

public class RecordDAO {
	public Integer selectRecordNo() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		Integer rNo = null;
		try {
			con = ConnectionPool.getConnection();
			sql.append("select seq_record_no.nextval from dual");
			ptmt = con.prepareStatement(sql.toString());

			rs = ptmt.executeQuery();
			rs.next();
			rNo = rs.getInt("NEXTVAL");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.releaseConnection(con);

		}
		return rNo;
	}

	public void insertRecord(String id, int rNo, int testCode, int score) {
		Connection con = null;
		PreparedStatement ptmt = null;

		StringBuffer sql = new StringBuffer();

		try {
			con = ConnectionPool.getConnection();
			sql.append("insert into tb_record(id,test_code,score,record_no) values " + "(?,?,?,?)");
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			ptmt.setLong(2, testCode);
			ptmt.setLong(3, score);
			ptmt.setLong(4, rNo);
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.releaseConnection(con);

		}
	}

	public void insertRecordDetail(List<RecordDetailsDomain> list) {
		Connection con = null;
		PreparedStatement ptmt = null;

		StringBuffer sql = new StringBuffer();

		try {
			con = ConnectionPool.getConnection();
			sql.append("insert into tb_record_details(record_no," + " quiz_no, record_result,record_answer,"
					+ " quiz_answer) values " + "(?,?,?,?,?)");

			for (int i = 0; i < list.size(); i++) {
				ptmt = con.prepareStatement(sql.toString());
				ptmt.setInt(1, list.get(i).getRecordNo());
				ptmt.setInt(2, list.get(i).getQuizNo());
				ptmt.setString(3, list.get(i).getRecordResult());
				ptmt.setInt(4, list.get(i).getRecordAnswer());
				ptmt.setInt(5, list.get(i).getQuizAnswer());

				ptmt.executeUpdate();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionPool.releaseConnection(con);

		}

	}
}
