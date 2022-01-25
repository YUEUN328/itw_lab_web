package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Board;

// CRUD(Create, Read, Update, Delete)
public interface BoardDao {
	
	public List<Board> read();
	Board read(int bno);
	int create(Board board); 
	int update(Board board);
	int update(int bno);
	int delete(int bno);

}
