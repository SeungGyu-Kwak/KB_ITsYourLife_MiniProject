package cafe.dto;

public class CoffeeDto {
	private int beverageCode; // 음료코드 (PK)
	private String beverageName; // 음료이름
	private int hotPrice; // hot 가격
	private int icePrice; // Ice 가격
	
	public CoffeeDto() {};
	public CoffeeDto(int beverageCode, String beverageName, int hotPrice, int icePrice) {
		super();
		this.beverageCode = beverageCode;
		this.beverageName = beverageName;
		this.hotPrice = hotPrice;
		this.icePrice = icePrice;
	}
	
	public int getBeverageCode() {
		return beverageCode;
	}
	public void setBeverageCode(int beverageCode) {
		this.beverageCode = beverageCode;
	}
	public String getBeverageName() {
		return beverageName;
	}
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}
	public int getHotPrice() {
		return hotPrice;
	}
	public void setHotPrice(int hotPrice) {
		this.hotPrice = hotPrice;
	}
	public int getIcePrice() {
		return icePrice;
	}
	public void setIcePrice(int icePrice) {
		this.icePrice = icePrice;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeDto [beverageCode=");
		builder.append(beverageCode);
		builder.append(", beverageName=");
		builder.append(beverageName);
		builder.append(", hotPrice=");
		builder.append(hotPrice);
		builder.append(", icePrice=");
		builder.append(icePrice);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
