package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo._core.utils.Resp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @GetMapping("/api/users/username-check")
    public ResponseEntity<?> usernameCheck(@RequestParam("username") String username) {
        String normalized = username == null ? "" : username.trim();
        if (normalized.isEmpty()) {
            return Resp.fail(HttpStatus.BAD_REQUEST, "username은 필수입니다.");
        }

        boolean isDuplicated = userService.usernameCheck(normalized);
        return Resp.ok(isDuplicated);
    }
}
