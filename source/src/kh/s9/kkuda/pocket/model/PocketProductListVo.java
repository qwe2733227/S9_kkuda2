package kh.s9.kkuda.pocket.model;

import java.sql.Date;

public class PocketProductListVo {
	private String id;
	private Date times;
	private int pocket;
	private String goodsName;
	private int price;
	private String productimg;
	@Override
	public String toString() {
		return "PocketProductListVo [id=" + id + ", times=" + times + ", pocket=" + pocket + ", goodsName=" + goodsName
				+ ", price=" + price + ", productimg=" + productimg + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
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
