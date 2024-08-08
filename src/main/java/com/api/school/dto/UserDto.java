package com.api.school.dto;

import com.api.school.util.Role;

public class UserDto {

    private String id;

    private String name;

    private int age;

    private int tell;
    private String email;
    private String password;
    private Role role;

    public UserDto(String id, String name, int age, int tell, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tell = tell;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDto(Object id, String jose, int age, int tell, String mail) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getTell() {
        return tell;
    }
    public void setTell(int tell) {
        this.tell = tell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCreatedAt() {

        return "";
    }
}
