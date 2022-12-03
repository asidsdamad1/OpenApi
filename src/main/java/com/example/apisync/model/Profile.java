package com.example.apisync.model;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class Profile extends BaseObject {
    @Column(name = "number")
    private String number;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "age")
    private int age;
}
