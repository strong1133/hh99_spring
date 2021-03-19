package com.hh99_spring.week03.service;


import com.hh99_spring.week03.domain.Memo;
import com.hh99_spring.week03.domain.MemoRepository;
import com.hh99_spring.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        memo.update(memoRequestDto);
        return memo.getId();
    }
}
