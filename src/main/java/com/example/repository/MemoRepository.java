package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer>{

}
