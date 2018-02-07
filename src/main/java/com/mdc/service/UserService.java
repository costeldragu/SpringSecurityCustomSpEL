package com.mdc.service;

import com.mdc.security.CustomUserPrincipal;
import org.springframework.stereotype.Service;

public interface UserService {
    CustomUserPrincipal getUserByName(String userName);
}
