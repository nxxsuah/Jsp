package kr.co.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.jboard.dto.CommentDTO; 
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class CommentDAO extends DBHelper {
	
	// 싱글톤
	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	private CommentDAO() {}
	
	
	// 기본 CRUD 메서드
	public CommentDTO select(String cno) {
		
		// 반환용 DTO
		CommentDTO dto = null;
		
		try {
			conn = getConnection();						
			psmt = conn.prepareStatement(SQL.SELECT_COMMENT);
			psmt.setString(1, cno);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				
				
			}			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<CommentDTO> selectAll() {
		
		// 반환용 List
		List<CommentDTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ALL_COMMENT);
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setcno(rs.getInt(1));
				dto.setType(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dtoList.add(dto);
			}
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void insert(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getcno());
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String cno) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, cno);
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}