package org.ekujo.gesellschaft.auth.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {
    public static final String LOGIN_SUCCESSFUL = "Login successful";
    public static final String LOGIN_FAILED = "Login failed";
    public static final String LOGOUT_SUCCESSFUL = "Logout successful";
}
