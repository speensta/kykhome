package com.example.kykhome.controller;

import com.example.kykhome.dto.MemberDTO;
import com.example.kykhome.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberRestController {
    private final MemberService memberService;

    @PostMapping("/find-member-all")
    public ResponseEntity<List<MemberDTO>> findAllMember() {
        return new ResponseEntity<>(memberService.findAllMember(), HttpStatus.OK);
    }

    @PostMapping("/find-member-detail")
    public ResponseEntity<MemberDTO> findByMemberid(@RequestBody MemberDTO memberDTO) {
        MemberDTO resultDTO = memberService.findByMemberid(memberDTO);
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }

    @PutMapping("/create-member")
    public void create(@RequestBody MemberDTO memberDTO) {
        memberService.create(memberDTO);
    }

    @PutMapping("/update-member")
    public void update(@RequestBody MemberDTO memberDTO) {
        memberService.update(memberDTO);
    }

}
