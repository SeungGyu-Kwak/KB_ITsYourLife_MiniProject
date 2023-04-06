package cafe.dto;

public class OrderDetailDto {
	
	private int orderCode; // 주문상세 코드
	private int orderNum; // 주문테이블코드(FK) 
	private String menuName;//메뉴이름
	private int isHot; // isHot(hot, ice) 1이면 hot, 2면 ice
	private int amount; // 몇잔
	private int eachPrice; // amount * price
	
	public OrderDetailDto(int orderCode, int orderNum, String menuName, int isHot, int amount, int eachPrice) {
		super();
		this.orderCode = orderCode;
		this.orderNum = orderNum;
		this.menuName = menuName;
		this.amount = amount;
		this.isHot = isHot;
		this.eachPrice = eachPrice;
		
	}
	
	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getIsHot() {
		return isHot;
	}

	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public int getEachPrice() {
		return eachPrice;
	}

	public void setEachPrice(int eachPrice) {
		this.eachPrice = eachPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailDto [orderCode=");
		builder.append(orderCode);
		builder.append(", orderNum=");
		builder.append(orderNum);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", isHot=");
		builder.append(isHot);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", eachPrice=");
		builder.append(eachPrice);
		builder.append("]");
		return builder.toString();
	}



	
	
}
