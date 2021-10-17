package com.hengailu.backend.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
@RestController
//to allow from other servers
@CrossOrigin
public class AppUserController {
    @Autowired
    AppUserService appUserService;

    @GetMapping("/fetchAllUsers")
    public Set<String> getAllUsers() {
        //TODO: make secure
        return appUserService.fetchAllUserIds();
    }

    @GetMapping("/setReceiver/{userName}")
    public ResponseEntity<Void> fetchReceiverByEmail(@PathVariable String userName) {
        //TODO: make secure
        try {
            appUserService.loadUserByUsername(userName);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
