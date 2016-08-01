package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;


public class BookDao {
	// 대여 하고 싶은 책의 번호를 입력하세요.:6
		// 젊은그들이(가) 대여 됐습니다.

	

		public int insert(BookVo vo) {
			int count = 0;
			Connection connection = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				// 2. 연결얻어오기
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				connection = DriverManager.getConnection(url, "skudb", "skudb");

				// 3. statement준비
				String sql = "insert into book values(seq_book.nextval, ?, ?, ?, ?, ?)"; // 동적

				pstmt = connection.prepareStatement(sql);

				pstmt.setString(1, vo.getBookName());
				pstmt.setLong(2, vo.getCost());
				pstmt.setLong(3, vo.getCategoryNo());
				pstmt.setLong(4, vo.getRate());
				pstmt.setLong(5, vo.getAuthorNo());

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

		public List<BookVo> getList() {
			List<BookVo> list = new ArrayList<BookVo>();

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
				String sql = "select bookNo, bookName, cost, categoryNo, rate, authorNo from book"; // 동적

				
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Long bookNo = rs.getLong(1);
					String bookName = rs.getString(2);
					Long cost = rs.getLong(3);
					Long categoryNo = rs.getLong(4);
					Long rate = rs.getLong(5);
					Long authorNo = rs.getLong(6);
					
					BookVo vo = new BookVo();
					vo.setBookNo(bookNo);
					vo.setBookName(bookName);
					vo.setCost(cost);
					vo.setCategoryNo(categoryNo);
					vo.setRate(rate);
					vo.setAuthorNo(authorNo);
					
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
		 String sql = "delete from book where bookNo = ?"; // 동적
		
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
		 
		 
		 
		 public int update(BookVo vo) {//update
		 int count = 0;
		 Connection connection = null;
		 PreparedStatement pstmt = null;
		 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 // 2. 연결얻어오기
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 connection = DriverManager.getConnection(url, "skudb", "skudb");
		
		 // 3. statement준비
		 String sql = "update book set bookName = ?, cost = ?, categoryNo =?, rate=?, authorNo =? where bookNo =?";
		
		 pstmt = connection.prepareStatement(sql);
		
		 pstmt.setString(1, vo.getBookName());
		 pstmt.setLong(2, vo.getCost());
		 pstmt.setLong(3, vo.getCategoryNo());
		 pstmt.setLong(4, vo.getRate());
		 pstmt.setLong(5, vo.getAuthorNo());
		 pstmt.setLong(6, vo.getBookNo());
		
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
