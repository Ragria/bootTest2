package com.example.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.Memo;

public interface MemoService {
	
	public Page<Memo> findAllPage(Pageable pageable);
	
	public void insert(Memo memo);
	
	public void delete(int mNo);

}
