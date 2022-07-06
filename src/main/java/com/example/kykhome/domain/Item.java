package com.example.kykhome.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "itemid")
    private Long id;
    private String name;
    private String price;
    private char isdel;
    @CreatedDate
    private LocalDateTime regdate;
    @LastModifiedBy
    private LocalDateTime moddate;
}
