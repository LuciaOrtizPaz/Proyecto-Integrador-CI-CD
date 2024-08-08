package com.api.school.dto.auth;


public class RegisterDto {
    private String name;
    private int age;
    private int tell;
    private String email;
    private String password;

    public RegisterDto( String name, int age, int tell, String email, String password) {
        this.name = name;
        this.age = age;
        this.tell = tell;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTell() {
        return tell;
    }

    public void setTell(int tell) {
        this.tell = tell;
    }
}
