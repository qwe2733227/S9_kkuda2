package kh.s9.kkuda.product.model;

public class ProductVo {
	private int pocket;
	private String goodsName;
	private int price;
	private String productimg;
	public ProductVo() {
		super();
	}
	public ProductVo(int pocket, String goodsName, int price, String productimg) {
		super();
		this.pocket = pocket;
		this.goodsName = goodsName;
		this.price = price;
		this.productimg = productimg;
	}
	@Override
	public String toString() {
		return "ProductVo [pocket=" + pocket + ", goodsName=" + goodsName + ", price=" + price + ", productimg="
				+ productimg + "]";
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
	public String getProductimg() {
		return productimg;
	}
	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}
	
	
	
	
	
}
