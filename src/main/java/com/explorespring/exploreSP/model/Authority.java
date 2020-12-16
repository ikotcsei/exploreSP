package com.explorespring.exploreSP.model;

import javax.persistence.*;

@Entity   //will be mapped to a table
@Table(name = "authorities", schema = "public")    //table name and sema req in postgres
public class Authority implements Comparable{

    @Id
    @Column(name = "username",unique=true)
    private String userName;
    @Column(name = "authority")
    private String authority;



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


    @Override
    public int compareTo(Object o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.getUserName(),((Authority)o).getUserName());
    }
}

