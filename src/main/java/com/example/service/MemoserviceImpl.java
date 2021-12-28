package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Memo;
import com.example.repository.MemoRepository;

@Service
public class MemoserviceImpl implements MemoService {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Override
	public void insert(Memo memo) {
		
		memoRepository.save(memo);
		

	}

	@Override
	public Page<Memo> findAllPage(Pageable pageable) {
		
		return memoRepository.findAll(pageable);
	}

	@Override
	public void delete(int id) {
		memoRepository.deleteById(id);
	}

}
