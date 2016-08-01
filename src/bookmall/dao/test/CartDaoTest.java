package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		testCartDaoInsert();
		testCartDaoGetList();
	}
	public static void testCartDaoGetList() { //select
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList();

		for (CartVo vo : list) {

			System.out.println(vo);
		}
	}


	public static void testCartDaoInsert() {//insert
	
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
//		vo.setCount(3L);
//		vo.setCartCost(75000L);
//		vo.setCustomNo(1L);
//		vo.setBookNo(3L);
//		dao.insert(vo);
//		
		vo = new CartVo();
		vo.setCount(1L);
		vo.setCartCost(25000L);
		vo.setCustomNo(1L);
		vo.setBookNo(6L);
		dao.insert(vo);
		
		vo = new CartVo();
		vo.setCount(1L);
		vo.setCartCost(27000L);
		vo.setCustomNo(1L);
		vo.setBookNo(4L);
		dao.insert(vo);
		
		

	}

	}


