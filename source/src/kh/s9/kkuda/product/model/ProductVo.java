package kh.s9.kkuda.product.model;

public class ProductVo {
	private int pocket;
	private String goodsName;
	private int price;
	@Override
	public String toString() {
		return "ProductVo [pocket=" + pocket + ", goodsName=" + goodsName + ", price=" + price + "]";
	}
	public int getPocket() {
		return pocket;
	}
	public void setPocket(int pocket) {
		this.pocket = pocket;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
