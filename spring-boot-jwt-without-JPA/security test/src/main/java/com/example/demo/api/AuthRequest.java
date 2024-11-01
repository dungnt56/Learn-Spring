package com.example.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @Length(min = 5, max = 50)
    private String username;

    @Length(min = 5, max = 10)
    private String password;
}
