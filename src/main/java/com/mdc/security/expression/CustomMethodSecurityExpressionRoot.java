package com.mdc.security.expression;

import com.mdc.model.UserModel;
import com.mdc.security.CustomUserPrincipal;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import java.util.concurrent.atomic.AtomicBoolean;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean hasPermission(String permission) {
        UserModel user = ((CustomUserPrincipal) this.getPrincipal()).getUser();
        AtomicBoolean hasPermission = new AtomicBoolean(false);
        user.getRoles().forEach(role -> {
            role.getPermissions().forEach(currentPermission -> {
                if(permission.equals(currentPermission.getName())) {
                    hasPermission.set(true);
                }

            });
        });
        return hasPermission.get();
    }

    @Override
    public void setFilterObject(Object o) {

    }

    @Override
    public Object getFilterObject() {
        return null;
    }

    @Override
    public void setReturnObject(Object o) {

    }

    @Override
    public Object getReturnObject() {
        return null;
    }

    @Override
    public Object getThis() {
        return null;
    }


}
