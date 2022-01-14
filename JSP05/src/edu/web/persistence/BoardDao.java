package edu.web.persistence;

import static edu.web.domain.Board.Entry.*;

import java.util.List;

import edu.web.domain.Board;

// CRUD(Create/Read/Update/Delete)
public interface BoardDao {

	// 전체 검색: select * from boards order by bno desc;
	String SQL_SELECT_ALL = String.format(
			"select * from %S order by %S desc", 
			TABLE_BOARD, COL_BNO);
	/**
	 * DB BOARDS 테이블에서 전체 검색 결과를 리턴하는 메서드.
	 * 
	 * @return Board 객체를 원소로 갖는 ArrayList.
	 */
	List<Board> read();
	
	// 새 글 작성: insert into boards (title, content, userid) values (?, ?, ?);
	String SQL_INSERT_BOARD = String.format(
			"insert into %S (%S, %S, %S) values (?, ?, ?)", 
			TABLE_BOARD, COL_TITLE, COL_CONTENT, COL_USERID);
	/**
	 * DB boards 테이블에 새 레코드를 삽입.
	 * 
	 * @param board boards 테이블에 insert할 title, content, userid를 갖고 있는 객체.
	 * @return insert 성공하면 1, 실패하면 0.
	 */
	int create(Board board);
}
