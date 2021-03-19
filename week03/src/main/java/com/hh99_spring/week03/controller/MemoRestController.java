package com.hh99_spring.week03.controller;

import com.hh99_spring.week03.domain.Memo;
import com.hh99_spring.week03.domain.MemoRepository;
import com.hh99_spring.week03.domain.MemoRequestDto;
import com.hh99_spring.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoRestController {
    private final MemoRepository memoRepository;
    private final MemoService  memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemo(){
        return memoRepository.findAll();
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto){
        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto){
        return memoService.update(id, memoRequestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }


}
