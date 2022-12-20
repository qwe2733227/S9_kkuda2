package kh.s9.kkuda.pocket.model;

import java.sql.Date;

public class PocketVo {
	private String id;
	private int pocket;
	private Date times;
	@Override
	public String toString() {
		return "PocketVo [id=" + id + ", pocket=" + pocket + ", times=" + times + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPocket() {
		return pocket;
	}
	public void setPocket(int pocket) {
		this.pocket = pocket;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	
	
}
