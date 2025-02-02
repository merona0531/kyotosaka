package com.example.weeklyplanner.controller;

import com.example.weeklyplanner.model.Memo;
import com.example.weeklyplanner.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/memo")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    // ✅ 모든 메모 리스트 가져오기
    @GetMapping
    public List<Memo> getAllMemos() {
        return memoService.getAllMemos();
    }

    // ✅ 특정 ID의 메모 가져오기
    @GetMapping("/{id}")
    public Optional<Memo> getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    // ✅ 메모 저장 (새로운 메모 추가)
    @PostMapping
    public Memo saveMemo(@RequestBody Memo memo) {
        return memoService.saveMemo(memo);
    }

    // ✅ 메모 업데이트 기능 추가
    @PutMapping("/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody Memo memoDetails) {
        return memoService.updateMemo(id, memoDetails);
    }

    // ✅ 메모 삭제 기능 추가
    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }
}
