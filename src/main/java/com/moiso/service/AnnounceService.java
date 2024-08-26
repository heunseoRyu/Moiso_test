package com.moiso.service;

import com.moiso.dto.AnnounceList;
import com.moiso.dto.AnnounceRes;
import com.moiso.dto.ApplyReq;
import com.moiso.dto.RegisterReq;
import com.moiso.entity.Announce;
import com.moiso.entity.user.User;
import com.moiso.repository.AnnounceRepository;
import com.moiso.repository.ApplyRepository;
import com.moiso.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnounceService {
    private final AnnounceRepository announceRepository;
    private final UserRepository userRepository;
    private final ApplyRepository applyRepository;

    public void register(RegisterReq req) {
        announceRepository.save(req.toEntity());
    }


    public void apply(ApplyReq req) {
        applyRepository.save(req.toEntity());
    }

    public List<AnnounceList> announceList() {
        List<Announce> list = announceRepository.findAll();

        // Announce 객체를 변환해 새로운 리스트로 반환

        return list.stream()
                .map(AnnounceList ::of)
                .collect(Collectors.toList());
    }

    public List<AnnounceList> announceSearch(String title) {
        List<Announce> list = announceRepository.findByTitle(title);

        // Announce 객체를 변환해 새로운 리스트로 반환

        return list.stream()
                .map(AnnounceList ::of)
                .collect(Collectors.toList());
    }

    public AnnounceRes announceInfo(Long id) {
        Announce announce = announceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 값"));

        User user = userRepository.findById(announce.getUserId())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 유저"));

        return AnnounceRes.of(announce,user);
    }
}
