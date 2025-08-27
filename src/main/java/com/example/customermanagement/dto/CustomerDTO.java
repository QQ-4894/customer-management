package com.example.customermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotBlank(message = "名前は必須です")
    private String name;

    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "メールアドレスの形式が正しくありません")
    private String email;
    
    @NotBlank(message = "携帯番号は必須です")
    private String phone;

    @NotBlank(message = "住所は必須です")
    private String address;
}
