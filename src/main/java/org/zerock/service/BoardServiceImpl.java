package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		logger.info("log...추가");
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		int num = mapper.update(board);
		boolean flag = false;
		if(num==1) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean remove(Long bno) {
		int num = mapper.delete(bno);
		boolean flag = false;
		if(num==1) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		 return mapper.getTotal();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		System.out.println("서비스 페이지에서의 타입 : "+cri.getType());
		return mapper.getListWithPaging(cri);
	}

	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}


}
