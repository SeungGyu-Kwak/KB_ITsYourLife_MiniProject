package cafe.dto;

import java.util.List;

public class OrderDto {
	private int orderNumSeq; // 주문번호
	private int G_H;// 포장여부
	private String orderDate;//주문날짜
	private int totalPrice;// 총결제금액
	
	private List <OrderDetailDto> orderDetailList; // 주문 상세정보 저장

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

	public int getG_H() {
		return G_H;
	}

	public void setG_H(int g_H) {
		G_H = g_H;
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
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", G_H=");
		builder.append(G_H);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", orderDetailList=");
		builder.append(orderDetailList);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

