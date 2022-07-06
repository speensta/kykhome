package com.example.kykhome.service;

import com.example.kykhome.exception.NotFoundException;
import com.example.kykhome.domain.Member;
import com.example.kykhome.dto.MemberDTO;
import com.example.kykhome.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final ModelMapper modelMapper;

    public List<MemberDTO> findAllMember() {
        List<MemberDTO> list = new ArrayList<>();
        memberRepository.findAll().forEach(member -> {
            list.add(MemberDTO.builder().memberid(member.getMemberid())
                    .name(member.getName())
                    .email(member.getEmail())
                    .password(member.getPassword())
                    .url(member.getUrl())
                    .regdate(member.getRegdate()).build());
        });
        return list;
    }

    public MemberDTO findByMemberid(@RequestBody MemberDTO memberDTO) {
        Member member = memberRepository.findByMemberid(memberDTO.getMemberid()).orElseThrow(() -> new NotFoundException("존재하지 않는 글입니다."));
        return modelMapper.map(member, MemberDTO.class);
    }

    public void create(@RequestBody MemberDTO memberDTO) {
        memberRepository.save(modelMapper.map(memberDTO, Member.class));
    }

    public void update(@RequestBody MemberDTO memberDTO) {
        modelMapper.map(memberDTO, Member.class);
    }

}
