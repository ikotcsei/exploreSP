package com.explorespring.exploreSP.auth.modelTypes.onetoone;

import javax.persistence.*;


@Entity
@Table(name = "peoples")
public class People {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id",insertable = false)
        private Long id;

        @Column(name = "row_name",columnDefinition = " varchar(49) not null UNIQUE")   // will be "name" in database
        private String name;

//        @ManyToOne
//        @JoinColumn(name = "address_id", insertable = false, updatable = false)
//        private Address address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }


}
