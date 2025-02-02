package com.example.weeklyplanner.service;

import com.example.weeklyplanner.model.Memo;
import com.example.weeklyplanner.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // ✅ 모든 메모 가져오기 (추가)
    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    // ✅ 특정 메모 가져오기
    public Optional<Memo> getMemo(Long id) {
        return memoRepository.findById(id);
    }

    // ✅ 새로운 메모 저장
    public Memo saveMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    // ✅ 메모 업데이트 (추가)
    public Memo updateMemo(Long id, Memo memoDetails) {
        return memoRepository.findById(id)
                .map(existingMemo -> {
                    existingMemo.setMemo(memoDetails.getMemo()); // 기존 메모 내용 업데이트
                    return memoRepository.save(existingMemo);
                }).orElseThrow(() -> new RuntimeException("메모를 찾을 수 없습니다."));
    }

    // ✅ 메모 삭제 (추가)
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}
