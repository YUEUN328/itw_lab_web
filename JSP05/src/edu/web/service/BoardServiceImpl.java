package edu.web.service;

import java.util.List;

import edu.web.domain.Board;
import edu.web.persistence.BoardDao;
import edu.web.persistence.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;
	
	// Singleton 패턴 적용
	private static BoardServiceImpl instance = null;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if (instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<Board> select() {
		System.out.println("boardServiceImpl.select() 메서드 호출");
		return boardDao.read();
	}

	@Override
	public int registerNewBoard(Board board) {
		System.out.println("boardServiceImpl.registerNewBoard(board) 메서드 호출");
		
		// TODO
		// boardDao의 메서드를 사용해서 boards 테이블에 새 글을 입력(insert)
		// userDao의 메서드를 사용해서 users 테이블의 해당 userId의 points를 10 증가
		
		return 0;
	}

}
