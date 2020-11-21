package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "answers")
@Getter
@Setter
public class Answer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String content;

}
