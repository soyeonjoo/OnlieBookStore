package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CustomerVo;
import bookmall.vo.OrdersVo;

public class OrderDao {
	public int insert(OrdersVo vo) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "insert into orders values(seq_orders.nextval, ?, ?, ?, ?)"; // 동적

			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setString(3, vo.getAddress());
			pstmt.setLong(4, vo.getCustomNo());
		
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

	public List<OrdersVo> getList() {
		List<OrdersVo> list = new ArrayList<OrdersVo>();

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
			String sql = "select ordersNo, orderNo, price, address, customNo from orders"; // 동적

			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				Long ordersNo = rs.getLong(1);
				Long orderNo = rs.getLong(2);
				Long price = rs.getLong(3);
				String address = rs.getString(4);
				Long customNo = rs.getLong(5);
				
				
				
				OrdersVo vo = new OrdersVo();
				vo.setOrdersNo(ordersNo);
				vo.setOrderNo(orderNo);
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setCustomNo(customNo);
				
				
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
	 String sql = "delete from orders where ordersNo = ?"; // 동적
	
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
	 
	 public int update(OrdersVo vo) {//update
	 int count = 0;
	 Connection connection = null;
	 PreparedStatement pstmt = null;
	 try {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	
	 // 2. 연결얻어오기
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
	 connection = DriverManager.getConnection(url, "skudb", "skudb");
	
	 // 3. statement준비
	 String sql = "update orders set orderNo = ?, price = ?, address =?, customNo = ? where ordersNo =?";
	
	 pstmt = connection.prepareStatement(sql);
	
	 pstmt.setLong(1, vo.getOrderNo());
	 pstmt.setLong(2, vo.getPrice());
	 pstmt.setString(3, vo.getAddress());
	 pstmt.setLong(4, vo.getCustomNo());
	 pstmt.setLong(5, vo.getOrdersNo());
	
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
