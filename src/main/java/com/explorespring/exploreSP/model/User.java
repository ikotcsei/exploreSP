package com.explorespring.exploreSP.model;

import javax.persistence.*;

@Entity   //will be mapped to a table
@Table(name = "users", schema = "public")    //table name and sema req in postgres
public class User implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="username",unique=true)
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private boolean enabled;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email",unique=true)
    private String email;


    public User(){

    }

    public User(String userName, String password, boolean enabled, String firstName,String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", first name =" + firstName +
                ", last name =" + lastName +
                ", email =" + email +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        //object type = User
        return Integer.compare(this.getId(), ((User) o).getId());
    }
}
