package org.zerock.mapper;

import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//여기서 함수 이름이 mapper.xml의 쿼리id로 적용된다
	public void insert(BoardVO board);
}
