package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CustomerDao;
import bookmall.vo.CustomerVo;



public class CustomerDaoTest {

	public static void main(String[] args) {
		//testCustomerDaoInsert();
		testCustomerDaoGetList();
	}
	public static void testCustomerDaoGetList() { //select
		CustomerDao dao = new CustomerDao();
		List<CustomerVo> list = dao.getList();

		for (CustomerVo vo : list) {

			System.out.println(vo);
		}
	}


	public static void testCustomerDaoInsert() {//insert
	
		CustomerDao dao = new CustomerDao();
		CustomerVo vo = new CustomerVo();
		vo.setCustomName("주소연");
		vo.setPhn("003-004-1153");
		vo.setEmail("ddssd@d.net");
		vo.setPw("aaa3aaa");
		dao.insert(vo);
		
		

	}


	}


