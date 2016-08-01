package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.AuthorVo;


public class AuthorDao {
	public int insert(AuthorVo vo) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "insert into author values(seq_author.nextval, ?,?)"; // 동적

			pstmt = connection.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getAuthorName());
			pstmt.setString(2, vo.getDescription());

			// 5. query 실행
			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return count;
	}

	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			stmt = connection.createStatement();

			// 5. sql 날리기

			String sql = "select authorNo, authorName, description from author"; // ; 붙여주면안됨
																		// 다음
																		// 라인을
																		// 기다리기떄문에
			rs = stmt.executeQuery(sql);

			// 6. 결과처리

			while (rs.next()) {
				Long authorNo = rs.getLong(1);
				String authorName = rs.getString(2);
				String description = rs.getString(3);

				AuthorVo vo = new AuthorVo();
				vo.setAuthorNo(authorNo);
				vo.setAuthorName(authorName);
				vo.setDescription(description);

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error" + e);
		}

		catch (ClassNotFoundException e) {

			System.out.println("드라이버 로딩 실패 :" + e);
		} finally {
			try {
				// 7. 자원정리
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				System.out.println("error" + e);
			}

		}

		return list;

	}

	public int delete(Long no) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
		
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 연결얻어오기 connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection = DriverManager.getConnection(url, "skudb", "skudb");

		// 3. statement준비
		String sql = "delete from author where authorNo = ?";
		pstmt = connection.prepareStatement(sql);
		
		
		//4. 바인딩
		pstmt.setLong(1, no);
		
		
		//5. sql 실행
		count = pstmt.executeUpdate(); //완벽한 쿼리를 만든게아니라서 sql 보내는게 아님 
		
		
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	
	}
	
	public int update(AuthorVo vo) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
		
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 연결얻어오기 connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection = DriverManager.getConnection(url, "skudb", "skudb");

		// 3. statement준비
		String sql = "update author set authorName = ?, description= ?, where authorNo = ?";
		pstmt = connection.prepareStatement(sql);
		
		
		//4. 바인딩
		pstmt.setString(1, vo.getAuthorName());
		pstmt.setString(2, vo.getDescription());
		pstmt.setLong(3, vo.getAuthorNo());
		
		
		//5. sql 실행
		count = pstmt.executeUpdate(); //완벽한 쿼리를 만든게아니라서 sql 보내는게 아님 
		
		
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	
	}
	
	public int delete() { //모두 삭제 
		int count = 0;
		Connection connection = null;
		Statement stmt = null;
		try{
		
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 연결얻어오기 connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection = DriverManager.getConnection(url, "skudb", "skudb");

		// 3. statement준비
		String sql = "delete from author";
		stmt = connection.createStatement();
		
		//4. 바인딩 -필요없음		
		//5. sql 실행
		count = stmt.executeUpdate(sql); //완벽한 쿼리를 만든게아니라서 sql 보내는게 아님 
		
		
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if (stmt != null) {
					stmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return count;
	
	}
}
