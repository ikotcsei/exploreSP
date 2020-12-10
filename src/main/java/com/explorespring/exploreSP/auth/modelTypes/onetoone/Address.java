package com.explorespring.exploreSP.auth.modelTypes.onetoone;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "address")
        private String address;

//        @OneToMany
//        @JoinColumn(name = "people_id") // we need to duplicate the physical information
//        private Set<People> people;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public People getPeople() {
//        return people;
//    }
//
//    public void setPeople(People people) {
//        this.people = people;
//    }



}

