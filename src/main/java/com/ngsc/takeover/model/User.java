package com.ngsc.takeover.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "유저 이름이 필요합니다.")
    private String username;

    @NotBlank(message = "암호가 필요합니다.")
    private String password;

    @Email
    @NotEmpty(message = "이메일이 필요합니다.")
    private String email;

    private Instant created;

    private boolean enabled;
}
