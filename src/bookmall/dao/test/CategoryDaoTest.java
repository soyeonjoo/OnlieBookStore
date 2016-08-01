package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;



public class CategoryDaoTest {

	public static void main(String[] args) {
		
		
			testCategoryDaoInsert();
			testCategoryDaoGetList();
		}
		public static void testCategoryDaoGetList() { //select
			CategoryDao dao = new CategoryDao();
			List<CategoryVo> list = dao.getList();

			for (CategoryVo vo : list) {

				System.out.println(vo);
			}
		}


		public static void testCategoryDaoInsert() {//insert
		
			CategoryDao dao = new CategoryDao();
			CategoryVo vo = new CategoryVo();
			vo.setCategory1("소설");
			dao.insert(vo);
			
			vo = new CategoryVo();
			vo.setCategory1("수필");
			dao.insert(vo);
			
			
			vo = new CategoryVo();
			vo.setCategory1("컴퓨터/IT");
			dao.insert(vo);
			
			vo = new CategoryVo();
			vo.setCategory1("인문");
			dao.insert(vo);
			
			vo = new CategoryVo();
			vo.setCategory1("경제");
			dao.insert (vo);
			
			
			
			vo = new CategoryVo();
			vo.setCategory1("예술");
			dao.insert(vo);
			
			

		}

//		public static void testCategoryDaoDelete() {//delete
//			CategoryDao dao = new CategoryDao();
//			int count = dao.delete(7L);
	//	
//				
//			System.out.println( "삭제된 row 수:" + count );
//			
//		}
	//
//		public static void testCategoryDaoUpdate() {//update
//			CategoryVo vo = new CategoryVo();
	//
//			vo.setCategoryName("가나다라마바사");
////			vo.setpub_Date("19/02/13");
////			vo.setRate(2L);
//			vo.setAuthor_no(3L);
//			vo.setNo(7L);
//				
//			CategoryDao dao = new CategoryDao();
//			dao.update(vo);
//		}
	//

	//}
		
	}


