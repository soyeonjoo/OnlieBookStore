package bookmall.app;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.dao.CustomerDao;
import bookmall.vo.CategoryVo;
import bookmall.vo.CustomerVo;

public class BookMall {

	public static void main(String[] args) {
		

		testCustomerDaoGetList();// 1. 회원 리스트
		testCategoryDaoGetList();// 2. 카테고리 리스트
		testBookDaoGetList();// 3. 상품리스트
		testCartDaoGetList();// 4. 카트 리스트
		testOrderDaoGetList(); // 5. 주문 리스트
		testBookOrderDaoGetList();// 6. 주문 도서 리스트

	}

	public static void testCustomerDaoGetList() { // select
		System.out.println("1. 사용자 리스트");

		CustomerDao dao = new CustomerDao();
		List<CustomerVo> list = dao.getList();

		for (CustomerVo vo : list) {

			System.out.println(vo);
		}
	}

	public static void testCategoryDaoGetList() { // select
		System.out.println();
		System.out.println("================");
		System.out.println("2. 카테고리 리스트");

		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();

		for (CategoryVo vo : list) {

			System.out.println(vo);
		}
	}

	public static void testBookDaoGetList() { // select
		System.out.println();
		System.out.println("================");
		System.out.println("3. 상품 리스트");

		CustomerDao dao = new CustomerDao();
		List<CustomerVo> list = dao.getList();

		for (CustomerVo vo : list) {

			System.out.println(vo);
		}
	}

	public static void testCartDaoGetList() { // select
		System.out.println("1. 사용자 리스트");

		CustomerDao dao = new CustomerDao();
		List<CustomerVo> list = dao.getList();

		for (CustomerVo vo : list) {

			System.out.println(vo);
		}
	}

	public static void testOrderDaoGetList() { // select
		System.out.println("1. 사용자 리스트");

		CustomerDao dao = new CustomerDao();
		List<CustomerVo> list = dao.getList();

		for (CustomerVo vo : list) {

			System.out.println(vo);
		}
	}

	public static void testBookOrderDaoGetList() { // select
		System.out.println("1. 사용자 리스트");

		CustomerDao dao = new CustomerDao();
		List<CustomerVo> list = dao.getList();

		for (CustomerVo vo : list) {

			System.out.println(vo);
		}
	}

}
