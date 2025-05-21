package org.ekujo.gesellschaft.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSuccessResponse {
    private Long id;
    private String username;
    private String role;
}
