package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.Board;

@Repository // 스프링 프레임워크에게 영속 계층(persistence layer)의 컴포넌트(DAO)임을 알려주는 어노테이션
// root-context.xml 파일에서 <context:component-scan>에 의해서 Java bean이 생성, 관리됨
public class BoardDaoImpl implements BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	private static final String BOARD_NAMESPACE = "edu.spring.ex02.mapper.BoardMapper";
	
	// root-context.xml로 관리되고 있는 Java bean 객체를 주입(injection)받음
	@Autowired private SqlSession sqlSession;
	
	@Override
	public List<Board> read() {
		logger.info("boardDaoImpl.read() 호출");
		
		return sqlSession.selectList(BOARD_NAMESPACE + ".selectAll");
	}

}
