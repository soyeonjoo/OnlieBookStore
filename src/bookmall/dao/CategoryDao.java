package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;

public class CategoryDao {
	public int insert(CategoryVo vo) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "insert into category values(seq_category.nextval, ?)"; // 동적

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, vo.getCategory1());

			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return count;
	}

	public List<CategoryVo> getList() {
		List<CategoryVo> list = new ArrayList<CategoryVo>();

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비

			stmt = connection.createStatement();
			String sql = "select categoryNo, category1 from category"; // 동적

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Long categoryNo = rs.getLong(1);
				String category1 = rs.getString(2);
				
				CategoryVo vo = new CategoryVo();
				vo.setCategoryNo(categoryNo);
				vo.setCategory1(category1);
				

				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("에러" + e);
		} catch (SQLException e) {//
			System.out.println("에러" + e);
		} finally {
			try {
				if (connection != null) {

					connection.close();

				}
				if (stmt != null) {

					stmt.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int delete(Long no) {// delete
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "delete from category where categoryNo = ?"; // 동적

			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, no);

			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
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

	public int update(CategoryVo vo) {// update
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "update category set category1 =? where categoryNo =?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, vo.getCategory1());
			pstmt.setLong(2, vo.getCategoryNo());

			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {//
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return count;
	}
}
