package bookmall.vo;

public class OrdersVo {
	private Long ordersNo; //기본키
	private Long orderNo;
	private Long price;
	private String address;
	private Long customNo;
	public Long getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCustomNo() {
		return customNo;
	}
	public void setCustomNo(Long customNo) {
		this.customNo = customNo;
	}
	@Override
	public String toString() {
		return "OrdersVo [ordersNo=" + ordersNo + ", orderNo=" + orderNo + ", price=" + price + ", address=" + address
				+ ", customNo=" + customNo + "]";
	}
	
	
	
}
