package com.consy.ResourceServer.controller;

import com.consy.ResourceServer.response.UserRest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String status(){
        return "Working...";
    }

    @PreAuthorize("hasRole('developer') or #id==#jwt.subject")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return "deleted user with id "+ id;
    }

    @PostAuthorize("returnObject.userId == #jwt.getSubject")
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        return new UserRest("Shreya","Palha","f1570459-33ea-42ee-8cf1-55c8cc236c50");
    }


}
