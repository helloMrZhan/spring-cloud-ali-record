package com.zjq.producerservice.entity;

/**
 * <p>用户实体</p>
 *
 * @Author zjq
 * @Date 2021/11/19
 */
public class User {

    /**
     *client端需要有这个无参构造不然会报错no Creators, like default constructor, exist): cannot deserialize from Object
     */
    public User() {
    }

    public User(String username, String password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    private String username;

    private String password;

    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
