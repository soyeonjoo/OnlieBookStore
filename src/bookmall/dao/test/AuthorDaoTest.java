package bookmall.dao.test;

import java.util.List;

import bookmall.dao.AuthorDao;
import bookmall.vo.AuthorVo;



public class AuthorDaoTest {
	public static void main(String[] args) {
		testAuthorDaoInsert();
		testAuthorDaoGetList();
			
		}

		
		public static void testAuthorDaoGetList() { //select
			AuthorDao dao = new AuthorDao();
			List<AuthorVo> list = dao.getList();

			for (AuthorVo vo : list) {

				System.out.println(vo);
			}
		}

		public static void testAuthorDaoInsert() {//insert
			AuthorDao dao = new AuthorDao();
			
			AuthorVo vo = new AuthorVo();
			vo.setAuthorName("스테파니메이어");//1
			vo.setDescription("");
			dao.insert(vo);
			
			vo = new AuthorVo(); //2
			vo.setAuthorName("조정래");
			vo.setDescription("");
			dao.insert(vo);
			
			vo = new AuthorVo();//3
			vo.setAuthorName("김동인");
			vo.setDescription("");
			dao.insert(vo);
			
			vo = new AuthorVo();//4
			vo.setAuthorName("김난도");
			vo.setDescription("");
			dao.insert(vo);
			
			vo = new AuthorVo();//5
			vo.setAuthorName("천상병");
			vo.setDescription("");
			dao.insert(vo);
			
			vo = new AuthorVo();//6
			vo.setAuthorName("원수연");
			vo.setDescription("");
			dao.insert(vo);
			
		
		}
		
	
}
