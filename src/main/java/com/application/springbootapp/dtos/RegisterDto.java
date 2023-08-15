package com.application.springbootapp.dtos;

import com.application.springbootapp.models.user.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
}
