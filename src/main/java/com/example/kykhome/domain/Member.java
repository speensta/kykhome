package com.example.kykhome.domain;


import lombok.*;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    private String memberid;
    private String name;
    private String password;
    private String url;
    private String email;
    private char isdel;
    @CreatedDate
    private LocalDateTime regdate;
    @LastModifiedBy
    private LocalDateTime moddate;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<>();



}
