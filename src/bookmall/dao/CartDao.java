package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao {
	public int insert(CartVo vo) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "insert into cart values(seq_cart.nextval, ?, ?, ?, ?)"; // 동적

			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getCount());
			pstmt.setLong(2, vo.getCartCost());
			pstmt.setLong(3, vo.getCustomNo());
			pstmt.setLong(4, vo.getBookNo());

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

	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();

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
			String sql = "select cartNo, count, cartCost, customNo, bookNo from cart"; // 동적

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Long cartNo = rs.getLong(1);
				Long count = rs.getLong(2);
				Long cartCost = rs.getLong(3);
				Long customNo = rs.getLong(4);
				Long bookNo = rs.getLong(5);

				CartVo vo = new CartVo();
				vo.setCartNo(cartNo);
				vo.setCount(count);
				vo.setCartCost(cartCost);
				vo.setCustomNo(customNo);
				vo.setBookNo(bookNo);
				;

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
			String sql = "delete from cart where cartNo = ?"; // 동적

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

	public int update(CartVo vo) {// update
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "update cart set count =?, cartCost=?, customNo=?, bookNo=? where cartNo =?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getCount());
			pstmt.setLong(2, vo.getCartCost());
			pstmt.setLong(3, vo.getCustomNo());
			pstmt.setLong(4, vo.getBookNo());
			pstmt.setLong(5, vo.getCartNo());

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
