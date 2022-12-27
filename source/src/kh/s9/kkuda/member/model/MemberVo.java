package kh.s9.kkuda.member.model;


public class MemberVo {
//	ID       NOT NULL VARCHAR2(30) 
//	PASSWD   NOT NULL VARCHAR2(30) 
//	NAME     NOT NULL VARCHAR2(20) 
//	TEL      NOT NULL NUMBER       
//	BRITHDAY NOT NULL NUMBER       
//	GENDER   NOT NULL CHAR(1)
	private String id;
	private String passwd;
	private String name;
	private int tel;
	private int brithday;
	private String gender;
	
	public MemberVo() {
		super();
	}
	public MemberVo(String id, String passwd, String name, int tel, int brithday, String gender) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.tel = tel;
		this.brithday = brithday;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", tel=" + tel + ", brithday="
				+ brithday + ", gender=" + gender + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getBrithday() {
		return brithday;
	}
	public void setBrithday(int brithday) {
		this.brithday = brithday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
