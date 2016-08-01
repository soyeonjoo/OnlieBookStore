package bookmall.vo;

public class CategoryVo {
  private Long categoryNo;
  private String category1;
  
  
public String getCategory1() {
	return category1;
}
public void setCategory1(String category1) {
	this.category1 = category1;
}
public Long getCategoryNo() {
	return categoryNo;
}
public void setCategoryNo(Long categoryNo) {
	this.categoryNo = categoryNo;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "no:"+categoryNo + ", category: "+category1;
}

  
}
