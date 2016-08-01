package bookmall.vo;

public class CartVo {
	private Long cartNo;
	private Long count;
	private Long cartCost;
	private Long customNo;
	private Long bookNo;
	public Long getCartNo() {
		return cartNo;
	}
	public void setCartNo(Long cartNo) {
		this.cartNo = cartNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getCartCost() {
		return cartCost;
	}
	public void setCartCost(Long cartCost) {
		this.cartCost = cartCost;
	}
	public Long getCustomNo() {
		return customNo;
	}
	public void setCustomNo(Long customNo) {
		this.customNo = customNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	@Override
	public String toString() {
		
		return "cartNo:"+cartNo+", count:"+count+ ", cartCost:"+cartCost+ ", customNo:"+customNo + ", bookno:"+bookNo;
	}
	
	
}
