package com.example.kykhome.dto;

import lombok.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Builder
@Getter
@Service
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberDTO {
    private String memberid;
    private String name;
    private String password;
    private String url;
    private String email;
    private char isdel;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
}
