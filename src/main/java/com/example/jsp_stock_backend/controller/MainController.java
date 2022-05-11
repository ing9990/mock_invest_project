package com.example.jsp_stock_backend.controller;

import com.example.jsp_stock_backend.domain.User;
import com.example.jsp_stock_backend.dto.AddStockDto;
import com.example.jsp_stock_backend.dto.AddUserDto;
import com.example.jsp_stock_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class MainController {

    // Dependency Injection
    private final UserService userService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }


    // -----------ADMIN GET METHOD-----------------//
    
    @GetMapping("/users") // 유저 리스트 조회
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/user/id/{id}") // 유저 아이디로 검색
    public User findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/user/name/{username}") // 유저 이름으로 검색
    public List<User> findUsersByUsername(@PathVariable String username){
        return userService.findUsersByUsername(username);
    }


    // -----------USERS GET METHOD-----------------//
    @GetMapping("") // 워드 클라우드 생성.
    public void makeWordCloud(){
        userService.makeWordCloud();
    }

    // --------------POST METHOD-------------- //
    @PostMapping("") // 유저 회원가입.
    public void addUser(@RequestBody AddUserDto addUserDto){
        userService.addUser(addUserDto);
    }

    @PostMapping("/stock")
    public List<AddStockDto> addStock(@RequestBody ArrayList<AddStockDto> addStockDto){
        return addStockDto;
    }


    // --------------PUT METHOD-------------- //
    @PutMapping("/{id}") // 유저 등급 상승.
    public User editRoleById(@PathVariable Long id){
        return userService.editRole(id);
    }



    // -------------DELETE METHOD-------------- //
    @DeleteMapping("/{id}") // 유저 퇴출.
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }


}
