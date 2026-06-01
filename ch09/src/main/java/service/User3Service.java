package service;


import java.util.List;

import dao.User2DAO;
import dao.User3DAO;
import dto.User2DTO;
import dto.User3DTO;

public class User3Service {
	
	//싱글톤
	private static User3Service instance = new User3Service();
	public static User3Service getInstance() {
		return instance;
	}
	private User3Service() {}
	
	//DAO 객체 가져오기
	private User3DAO dao = User3DAO.getInstance();
	
	//DAO 호출 서비스 메서드
	public void register(User3DTO dto) {
		dao.insert(dto);
	}
	
	public User3DTO findbyID(String userid) {
		return dao.select(userid);
	}
	
	public List<User3DTO> findAll() {
		return dao.selectAll();
	}
	public void modify(User3DTO dto) {
		dao.update(dto);
	}
	
	public void remove(String userid) {
		dao.delete(userid);
	}

}
