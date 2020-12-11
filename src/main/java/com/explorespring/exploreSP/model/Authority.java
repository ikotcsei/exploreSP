package com.explorespring.exploreSP.model;

import javax.persistence.*;

@Entity   //will be mapped to a table
@Table(name = "authorities", schema = "public")    //table name and sema req in postgres
public class Authority {

    @Id
    @Column(name = "username")
    private String userName;
    @Column(name = "authority")
    private String authority;


//    @OneToOne(mappedBy = "auth")
//    private User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}

