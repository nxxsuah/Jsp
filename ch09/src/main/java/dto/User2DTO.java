package dto;

/*
 * 		DTO Data Transfer Object
 * 		 - MVC 컴포넌트 간 데이터 교환을 위한 객체
 * 		 - 데이터 테이블 튜플 객체 (Entity)
 */


public class User2DTO {
	
	private String userid;
	private String name;
	private String birth;
	private String addr;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User2DTO [userid=" + userid + ", name=" + name + ", birth=" + birth + ", addr=" + addr + "]";
	}
	
	
	

}
