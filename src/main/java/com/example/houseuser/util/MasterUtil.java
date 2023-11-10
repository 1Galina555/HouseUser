package com.example.houseuser.util;

import com.example.houseuser.model.User;
import com.example.houseuser.service.master.MasterUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class MasterUtil {
    public User getUserMaster() {
        return ((MasterUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}
