package cafe.dto;

import java.util.List;

/**
 * OrderDto 주문테이블에 넣기 위한 Dto
 * @작성자 : 곽승규 
 * 
 * */
public class OrderDto {
	private int orderNumSeq; // 주문번호
	private int isToGo;// 포장여부
	private String orderDate;//주문날짜
	private int totalPrice;// 총결제금액
	
	private List <OrderDetailDto> orderDetailList; // 주문 상세정보 저장(중요)
	
	public OrderDto(int orderNumSeq, int isToGo, String orderDate, int totalPrice) {
		super();
		this.orderNumSeq = orderNumSeq;
		this.isToGo = isToGo;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;

	}

	public int getOrderNumSeq() {
		return orderNumSeq;
	}

	public void setOrderNumSeq(int orderNumSeq) {
		this.orderNumSeq = orderNumSeq;
	}


	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}



	public int getIsToGo() {
		return isToGo;
	}

	public void setIsToGo(int isToGo) {
		this.isToGo = isToGo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderDetailDto> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailDto> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDto [orderNumSeq=");
		builder.append(orderNumSeq);
		builder.append(", isToGo=");
		builder.append(isToGo);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", orderDetailList=");
		builder.append(orderDetailList);
		builder.append("]");
		return builder.toString();
	}


	
	
}

