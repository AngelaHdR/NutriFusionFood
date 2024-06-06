package com.fpmislata.NutriFusionFood.common;

import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public Integer getCurrentUserId() {
        return Auth.getUser().getId();
    }
}

