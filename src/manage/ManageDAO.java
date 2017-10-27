package manage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionPool;

public class ManageDAO {
	
	PreparedStatement ptmt;
	ResultSet rs;
	
	// ========== 회원 ==========
	//TODO 회원 전체 목록 (가입일자 최근순)
	public List<MemberDomain> listMember() throws Exception {
		List<MemberDomain> res = new ArrayList<MemberDomain>();
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select * from tb_member"
				+ " order by reg_date desc");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				MemberDomain member = new MemberDomain();
				
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setAdmin(rs.getString("admin"));
				member.setRegdate(rs.getTimestamp("reg_date"));
				
				res.add(member);
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		
		return res;
	}
	
	//TODO 회원 상세
	public MemberDomain detailMember(String id) throws Exception {
		MemberDomain res = new MemberDomain();
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select * from tb_member"
				+ " where id = ?");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res.setId(id);
				res.setPass(rs.getString("pass"));
				res.setName(rs.getString("name"));
				res.setAdmin(rs.getString("admin"));
				res.setRegdate(rs.getTimestamp("reg_date"));
				
				return res;
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		return null;
	}
	
	//TODO 회원 수정
	public void modifyMember(MemberDomain member) throws Exception {
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("update tb_member set pass = ?, name = ?, admin = ?"
				+ " where id = ?");
		
		try {
			
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			int index=1;
			ptmt.setString(index++, member.getPass());
			ptmt.setString(index++, member.getName());
			ptmt.setString(index++, member.getAdmin());
			
			ptmt.setString(index++, member.getId());
			
			ptmt.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
	}
	
	//TODO 회원 삭제
	public void deleteMember(String id) throws Exception {
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("delete from tb_member"
				+ " where id = ?");
		
		try {
			
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			
			ptmt.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
	}
	
	// ========== 시험 ==========
	//TODO 시험 목록 (그룹코드, 정렬기준 필드)
	public List<TestDomain> listTest(int groupCode, String field) throws Exception {
		List<TestDomain> res = new ArrayList<TestDomain>();
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select * from tb_test"
				+ " where group_code = ?"
				+ " order by "+field);
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, groupCode);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				TestDomain test = new TestDomain();
				
				test.setTestCode(rs.getInt("test_code"));
				test.setTestName(rs.getString("test_name"));
				test.setGroupCode(rs.getInt("group_code"));
				test.setTestDate(rs.getDate("test_date"));
				
				res.add(test);
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		
		return res;
	}
	
	//TODO 시험 추가
	public void insertTest(TestDomain test) throws Exception {
		Connection con = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into tb_test (test_code, test_name, group_code, test_date)"
				+" values (seq_test_code.nextval , ?, ?, ?)");
		
		try {
			con = ConnectionPool.getConnection();
			
			ptmt = con.prepareStatement(sql.toString());
			
			//java.util.date를 java.sql.date로 변환
			java.util.Date utilDate = test.getTestDate();
			java.sql.Date testDate = null;
			
			if(utilDate!=null) {
				 testDate = new java.sql.Date(test.getTestDate().getTime());
			}
				
			int index=1;
			ptmt.setString(index++, test.getTestName());
			ptmt.setInt(index++, test.getGroupCode());
			ptmt.setDate(index++, testDate);
			
			ptmt.executeUpdate();
			
		}catch (Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
	}
	
	// ========== 문제 ==========
	//TODO 과목 목록, 해당 과목 문제 개수
	public List<TestQuizDomain> listSub(int testCode) throws Exception {
		List<TestQuizDomain> res = new ArrayList<TestQuizDomain>();
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select quiz_sub, quiz_no"
				+ " from tb_test_quiz"
				+ " where test_code = ? and last_no = 'Y'"
				+ " order by quiz_code");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, testCode);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				TestQuizDomain quiz = new TestQuizDomain();
				
				quiz.setQuizSub(rs.getString("quiz_sub"));
				quiz.setQuizNo(rs.getInt("quiz_no"));
				
				res.add(quiz);
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		
		return res;
	}
	
	
	//TODO 문제 목록
	public List<TestQuizDomain> listQuiz(int testCode, String quizSub) throws Exception {
		List<TestQuizDomain> res = new ArrayList<TestQuizDomain>();
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select *"
				+ " from tb_test_quiz"
				+ " where test_code = ? and quiz_sub = ?"
				+ " order by quiz_code");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			ptmt.setInt(index++, testCode);
			ptmt.setString(index++, quizSub);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				TestQuizDomain quiz = new TestQuizDomain();
				
				quiz.setTestCode(rs.getInt("test_code"));
				quiz.setQuizSub(rs.getString("quiz_sub"));
				quiz.setQuizNo(rs.getInt("quiz_no"));
				quiz.setQuizQuestion(rs.getString("quiz_question"));
				quiz.setQuizAnswer(rs.getInt("quiz_answer"));
				quiz.setQuizScore(rs.getInt("quiz_score"));
				quiz.setLastNo(rs.getString("last_no"));
				quiz.setQuizCode(rs.getInt("quiz_code"));
				
				quiz.setExample1(rs.getString("example_1"));
				quiz.setExample2(rs.getString("example_2"));
				quiz.setExample3(rs.getString("example_3"));
				quiz.setExample4(rs.getString("example_4"));
				quiz.setExample5(rs.getString("example_5"));
				
				res.add(quiz);
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		
		return res;
	}
	
	//TODO 문제 수정
	public void modifyQuiz(TestQuizDomain quiz) throws Exception {
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("update tb_test_quiz"
				+ " set quiz_question = ?,"
				+ " example_1 = ?, example_2 = ?, example_3 = ?, example_4 = ?, example_5 = ?,"
				+ " quiz_answer = ?, quiz_score = ?"
				+ " where test_code = ? and quiz_code = ?");
		
		try {
			
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			int index=1;
			ptmt.setString(index++, quiz.getQuizQuestion());
			ptmt.setString(index++, quiz.getExample1());
			ptmt.setString(index++, quiz.getExample2());
			ptmt.setString(index++, quiz.getExample3());
			ptmt.setString(index++, quiz.getExample4());
			ptmt.setString(index++, quiz.getExample5());
			
			ptmt.setInt(index++, quiz.getQuizAnswer());
			ptmt.setInt(index++, quiz.getQuizScore());
			
			ptmt.setInt(index++, quiz.getTestCode());
			ptmt.setInt(index++, quiz.getQuizCode());
			
			ptmt.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
	}
	
	//TODO QuizCode 최대값 확인 (과목추가전 startcode 설정) 
	public int selectMaxQuizCode(int testCode) throws Exception {
		int res = 0;
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("select nvl(max(quiz_code), 0) as startcode from tb_test_quiz where test_code = ?");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			ptmt.setInt(1, testCode);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt("startcode");
				
				return res;
			}
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
		
		return res;
	}
	
	//TODO 과목추가
	public void insertQuiz(TestQuizDomain quiz, int startCode, int lastNo) throws Exception {
		Connection con = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into tb_test_quiz"
				+ " (test_code, quiz_sub, quiz_no, quiz_question,"
				+ " quiz_answer, quiz_score, quiz_code, last_no)"
				+ " values (?, ?, ?, '문제', 1, 0, ?, ?)");
		try {
			con = ConnectionPool.getConnection();
			
			String isLastNo = null;
			
			for (int i = 1; i <= lastNo; i++) {	
				ptmt = con.prepareStatement(sql.toString());
				
				if(i == lastNo) {
					isLastNo = "Y";
				}
					
				int index=1;
				ptmt.setInt(index++, quiz.getTestCode());
				ptmt.setString(index++, quiz.getQuizSub());
				ptmt.setInt(index++, i);
				ptmt.setInt(index++, startCode+i);
				ptmt.setString(index++, isLastNo);
				
				ptmt.executeUpdate();
			}
			
		}catch (Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
	}
	
	//해당 회차의 마지막 과목명 확인 (충돌 방지용, 삭제할 과목명 지정)
	//아직 사용하지 않음
	
	/*select quiz_sub from tb_test_quiz
	where test_code=6 and quiz_code = (select max(quiz_code) from tb_test_quiz);*/
	
	//TODO 과목삭제
	public void deleteSub(int testCode, String quizSub) throws Exception {
		Connection con = null;
		StringBuffer sql = new StringBuffer();
	
		sql.append("delete from tb_test_quiz"
				+ " where test_code = ? and quiz_sub = ?");
		
		try {
			con = ConnectionPool.getConnection();
			ptmt = con.prepareStatement(sql.toString());
			
			int index=1;
			ptmt.setInt(index++, testCode);
			ptmt.setString(index++, quizSub);
			
			ptmt.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			ConnectionPool.releaseConnection(con);
			close();
		}
	}
	
	
	//TODO 클로즈
	public void close() {
		if(rs!=null) try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {}
	}
}
