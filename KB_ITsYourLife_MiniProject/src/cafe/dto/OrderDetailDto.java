package cafe.dto;

public class OrderDetailDto {
	
	private int orderCode; // 주문상세 코드
	private int orderNum; // 주문테이블코드(FK) 
	private String menuName;//메뉴이름
	private int menuEA; // 몇잔
	private int kind; // kind(hot, ice) 1이면 hot, 2면 ice
	
	public OrderDetailDto(int orderCode, int orderNum, String menuName, int menuEA, int kind) {
		super();
		this.orderCode = orderCode;
		this.orderNum = orderNum;
		this.menuName = menuName;
		this.menuEA = menuEA;
		this.kind = kind;
	}
	public int getOrderDetailCode() {
		return orderCode;
	}
	public void setOrderDetailCode(int orderDetailCode) {
		this.orderCode = orderDetailCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuEA() {
		return menuEA;
	}
	public void setMenuEA(int menuEA) {
		this.menuEA = menuEA;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailDto [orderCode=");
		builder.append(orderCode);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", menuEA=");
		builder.append(menuEA);
		builder.append(", kind=");
		builder.append(kind);
		builder.append("]");
		return builder.toString();
	}
	
	
}
