package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrdersVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		//testOrderDaoInsert();
		testOrderDaoGetList();
	}

	public static void testOrderDaoGetList() { // select
		OrderDao dao = new OrderDao();
		List<OrdersVo> list = dao.getList();

		for (OrdersVo vo : list) {

			System.out.println(vo);
		}
	}

	public static void testOrderDaoInsert() {// insert

		OrderDao dao = new OrderDao();
		OrdersVo vo = new OrdersVo();
		vo.setOrderNo(201608012435L);
		vo.setPrice(127000L);//일단 만들기
		vo.setAddress("경기도 안양시 어쩌구저쩌구..");
		vo.setCustomNo(1L);
		dao.insert(vo);

	}
}
