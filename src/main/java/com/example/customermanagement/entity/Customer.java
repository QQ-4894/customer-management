package com.example.customermanagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "名前は必須です")
    private String name;
    
    @Email(message = "メールアドレスの形式が正しくありません")
    @NotBlank(message = "メールアドレスは必須です")
    private String email;

    @NotBlank(message = "携帯番号は必須です")
    private String phone;

    @NotBlank(message = "住所は必須です")
    private String address;
    
    private LocalDateTime registered;

    public Customer() {
        this.registered = LocalDateTime.now();
    }
}
