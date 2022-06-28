package com.futcleats.http.controllers;

import com.futcleats.http.dto.response.CreateUserRoleResponse;
import com.futcleats.http.dto.request.UserRequest;
import com.futcleats.http.dto.response.UserResponse;
import com.futcleats.http.mapper.UserMapper;
import com.futcleats.model.UserModel;
import com.futcleats.services.RoleService;
import com.futcleats.services.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    private final RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> findALL(){
        return ResponseEntity.ok().body(UserMapper.toResponseList(userService.findAll()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findByID(@PathVariable String userId){
        return ResponseEntity.ok().body(UserMapper.toResponse(userService.findById(Long.valueOf(userId))));
    }
    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(UserMapper.toResponse(userService.save(UserMapper.toModel(userRequest))));
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> upDate(@PathVariable String userId, @Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(UserMapper.toResponse(userService.upDate(UserMapper.toModel(userRequest), Long.valueOf(userId))));
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Long> delete(@PathVariable String userId){
        return ResponseEntity.ok().body(userService.delete(Long.valueOf(userId)));
    }

    @PostMapping("/role")
    public UserModel role(@RequestBody CreateUserRoleResponse createUserRoleResponse){
        return roleService.execute(createUserRoleResponse);
    }

}
