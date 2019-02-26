package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	//�Լ��̸��� xml���� �������� id , ���� ������ ������ �ȿ� ���� ��
	public List<BoardVO> getList();



	public void insert(BoardVO board);

	public Integer insertSelectKey(BoardVO board);

	public BoardVO get(Long bno); 

	public int delete(Long bno);

	public int update(BoardVO board);

	public int getTotal();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	//public int getTotalCount(Long bno);

	public int getTotalCount(Criteria cri);
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);

}