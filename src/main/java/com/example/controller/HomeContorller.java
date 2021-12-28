package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Memo;
import com.example.service.MemoService;

@Controller
public class HomeContorller {
	
	@Autowired
	MemoService memoService;
	
	@GetMapping("/")
	public String index(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
		
		Page<Memo> memoList = memoService.findAllPage(pageable);
		ArrayList<Integer> idx = new ArrayList<Integer>();
		int totalPage = memoList.getTotalPages();
		for(int i = 0; i < totalPage; i++) {
			idx.add(i);
		}
		System.out.println();
		model.addAttribute("memoList", memoList);
		model.addAttribute("idx", idx);
		
		
		
		
		return "index";
	}
	
	@PostMapping("/insert")
	public String insert(Memo memo) {
			if(memo.getName() == "") {
				memo.setName("Anonymous");
			}
			memoService.insert(memo);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("mNo")int mNo) {
		
		memoService.delete(mNo);
		
		return "redirect:/";
	}
}
