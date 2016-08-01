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


public class CustomerDao {
	
	public int insert(CustomerVo vo) {
		int count = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement준비
			String sql = "insert into customer values(seq_customer.nextval, ?, ?, ?, ?)"; // 동적

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, vo.getCustomName());
			pstmt.setString(2, vo.getPhn());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPw());
		
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

	public List<CustomerVo> getList() {
		List<CustomerVo> list = new ArrayList<CustomerVo>();

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
			String sql = "select customNo, customName, phn, email, pw from customer"; // 동적

			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				Long customNo = rs.getLong(1);
				String customName = rs.getString(2);
				String phn = rs.getString(3);
				String email = rs.getString(4);
				String pw = rs.getString(5);
				
				
				CustomerVo vo = new CustomerVo();
				vo.setCustomNo(customNo);
				vo.setCustomName(customName);
				vo.setPhn(phn);
				vo.setEmail(email);
				vo.setPw(pw);
				
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

	 
	 


}
