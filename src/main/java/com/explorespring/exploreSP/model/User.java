package com.explorespring.exploreSP.model;

import javax.persistence.*;

@Entity   //will be mapped to a table
@Table(name = "users", schema = "public")    //table name and sema req in postgres
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private boolean enabled;

    public User(){

    }

    public User(String userName, String password, boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

//    @JoinColumn
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "authorities_username",referencedColumnName = "username")
//    private Authority auth;

//    private String roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }


}
