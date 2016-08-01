package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;



public class BookDaoTest {

	public static void main(String[] args) {

	
			testBookDaoInsert();
			testBookDaoGetList();
			
		}
		public static void testBookDaoGetList() { //select
			BookDao dao = new BookDao();
			List<BookVo> list = dao.getList();

			for (BookVo vo : list) {

				System.out.println(vo);
			}
		}


		public static void testBookDaoInsert() {//insert
		
			BookDao dao = new BookDao();
			BookVo vo = new BookVo();
			vo.setBookName("트와일라잇");
			vo.setCost(25000L);
			vo.setCategoryNo(1L);
			vo.setRate(3L);
			vo.setAuthorNo(1L);
			
			dao.insert(vo);
			
			vo = new BookVo();
			vo.setBookName("뉴문");
			vo.setCost(28000L);
			vo.setCategoryNo(1L);
			vo.setRate(2L);
			vo.setAuthorNo(1L);
			
			dao.insert(vo);
			
			
			vo = new BookVo();
			vo.setBookName("이클립스");
			vo.setCost(25000L);
			vo.setCategoryNo(1L);
			vo.setRate(4L);
			vo.setAuthorNo(1L);
			
			dao.insert(vo);
			
			vo = new BookVo();
			vo.setBookName("브레이킹던");
			vo.setCost(27000L);
			vo.setCategoryNo(1L);
			vo.setRate(4L);
			vo.setAuthorNo(1L);
			
			dao.insert(vo);
			
			vo = new BookVo();
			vo.setBookName("아리랑");
			vo.setCost(18000L);
			vo.setCategoryNo(4L);
			vo.setRate(3L);
			vo.setAuthorNo(2L);
			dao.insert(vo);
			
						
			vo = new BookVo();
			vo.setBookName("아프니까 청춘이다");
			vo.setCost(25000L);
			vo.setCategoryNo(4L);
			vo.setRate(3L);
			vo.setAuthorNo(4L);
			
			dao.insert(vo);

			vo = new BookVo();
			vo.setBookName("귀천");
			vo.setCost(25000L);
			vo.setCategoryNo(3L);
			vo.setRate(1L);
			vo.setAuthorNo(5L);
			dao.insert(vo);

	


		}

//		public static void testBookDaoDelete() {//delete
//			BookDao dao = new BookDao();
//			int count = dao.delete(7L);
	//	
//				
//			System.out.println( "삭제된 row 수:" + count );
//			
//		}
	//
//		public static void testBookDaoUpdate() {//update
//			BookVo vo = new BookVo();
	//
//			vo.setBookName("가나다라마바사");
////			vo.setpub_Date("19/02/13");
////			vo.setRate(2L);
//			vo.setAuthorNo(3L);
//			vo.setNo(7L);
//				
//			BookDao dao = new BookDao();
//			dao.update(vo);
//		}
	//

	//}

}
