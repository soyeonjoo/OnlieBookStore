package bookmall.vo;

public class BookVo {
	private Long bookNo;
	private String bookName;
	private Long cost;
	private Long categoryNo;
	private Long rate;
	private Long authorNo;
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
	public Long getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}
	@Override
	public String toString() {
		return "no:"+ bookNo +" 책 제목:" + bookName +", 가격:"+cost+", 카테고리:"+categoryNo+", rate:"+rate +", 저자 :"+ authorNo;
		}


	
}
