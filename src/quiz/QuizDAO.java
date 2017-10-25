package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionPool;

public class QuizDAO {
	public List<QuizVO> listBoard(int testCode, int pageNo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs;
		StringBuffer sql = new StringBuffer();
		List<QuizVO> list = new ArrayList();
		try {
			con = ConnectionPool.getConnection();
			sql.append("select * from (select rownum rb,tb.* from (select * from tb_test_quiz order by quiz_code) tb)"
					+ " where TEST_CODE = ? and rb between ? and ? order by rb");
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setLong(1, testCode);
			ptmt.setLong(2, (pageNo - 1) * 6 + 1);
			ptmt.setLong(3, (pageNo) * 6);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				QuizVO quiz = new QuizVO();
				quiz.setTestCode(rs.getInt("test_code"));
				quiz.setQuizSub(rs.getString("quiz_sub"));
				quiz.setQuizNo(rs.getInt("quiz_no"));
				quiz.setQuizQue(rs.getString("quiz_question"));
				quiz.setQuizAnswer(rs.getInt("quiz_answer"));
				quiz.setQuizCode(rs.getInt("quiz_code"));
				int i = 1;
				while (i < 6) {
					if (rs.getString("example_" + i) == null) {

						break;
					}
					ExampleVO ev = new ExampleVO();
					ev.setExample(rs.getString("example_" + i));
					ev.setNo(i);
					quiz.setExamples(ev);
					i++;
				}
				list.add(quiz);
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
		return list;

	}
	public List<QuizVO> listBoard(int testCode) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs;
		StringBuffer sql = new StringBuffer();
		List<QuizVO> list = new ArrayList();
		try {
			con = ConnectionPool.getConnection();
			sql.append("select * from (select rownum rb,tb.* from (select * from tb_test_quiz order by quiz_code) tb)"
					+ " where TEST_CODE = ?");
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setLong(1, testCode);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				QuizVO quiz = new QuizVO();
				quiz.setTestCode(rs.getInt("test_code"));
				quiz.setQuizSub(rs.getString("quiz_sub"));
				quiz.setQuizNo(rs.getInt("quiz_no"));
				quiz.setQuizQue(rs.getString("quiz_question"));
				quiz.setQuizAnswer(rs.getInt("quiz_answer"));
				quiz.setQuizCode(rs.getInt("quiz_code"));
				quiz.setQuizScore(rs.getInt("quiz_score"));
				int i = 1;
				while (i < 6) {
					if (rs.getString("example_" + i) == null) {

						break;
					}
					ExampleVO ev = new ExampleVO();
					ev.setExample(rs.getString("example_" + i));
					ev.setNo(i);
					quiz.setExamples(ev);
					i++;
				}
				list.add(quiz);
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
		return list;

	}
	public List<AnswerVO> answerList(int testCode) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs;
		StringBuffer sql = new StringBuffer();
		List<AnswerVO> list = new ArrayList();
		try {
			con = ConnectionPool.getConnection();
			sql.append(
					"select quiz_code quizcode,quiz_answer answer,quiz_score score,quiz_no no,quiz_question que from tb_test_quiz where TEST_CODE = ? order by quizcode");
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setLong(1, testCode);

			rs = ptmt.executeQuery();
			while (rs.next()) {
				AnswerVO vo = new AnswerVO();
				vo.setQuizCode(rs.getInt("quizcode"));
				vo.setAnswer(rs.getInt("answer"));
				vo.setQuizNo(rs.getInt("no"));
				vo.setScore(rs.getInt("score"));
				vo.setAnsQue(rs.getString("que"));
				list.add(vo);
			}

		} catch (

		Exception e) {
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
		return list;

	}
	public Integer tbSize(int testCode) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs;
		StringBuffer sql = new StringBuffer();
		Integer size = null;
		try {
			con = ConnectionPool.getConnection();
			sql.append(
					"select count(*) si from tb_test_quiz where TEST_CODE = ?");
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setLong(1, testCode);

			rs = ptmt.executeQuery();
			rs.next();
			size=rs.getInt("si");
			
			

		} catch (

		Exception e) {
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
		return size;

	}
}
