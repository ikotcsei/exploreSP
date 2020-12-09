package com.explorespring.exploreSP.auth.modelTypes.onetoone;

import javax.persistence.*;
import java.util.Set;


/*  ONE-TO-ONE relationship (uni, bidirectional, shared private key, join table)

https://www.baeldung.com/jpa-one-to-one

 UNIDIRECT one-to-one:
 create onetoone column :

        @OneToOne(mappedBy = "column variable name")

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id", referencedColumnName = "id")
        private Address address;

 BIDIRECTtional one-to-one  (uni + ):


  SHARED PK Primary Key (People - Address)
        Entity People :
            @OneToOne(mappedBy = "people", cascade = CascadeType.ALL)
            @PrimaryKeyJoinColumn
            private Address address;

        Entry Address :
            @OneToOne
            @MapsId
            @JoinColumn(name = "people_id")
            private People people;

  WITH JOIN table :
        Entity People :
            @OneToOne(cascade = CascadeType.ALL)
            @JoinTable(name = "ppl_addr",           //table name, columns: ppl_id, addr_id
                joinColumns =
                        { @JoinColumn(name = "ppl_id", referencedColumnName = "id") },
                inverseJoinColumns =
                        { @JoinColumn(name = "addr_id", referencedColumnName = "id") })
            private Address address;


        Entry Address :
            @OneToOne(mappedBy = "address")
            private People people;

ONE TO MANY :(one ppl many address)
        Entity People :
            @OneToMany(mappedBy="people")
            private Set<Address> address;

        Entry Address :
            @ManyToOne
            @JoinColumn(name="people_id", nullable=false)
            private People people;

MANY TO ONE :(many cart owns one item)
        Entity People :
            @ManyToOne
            @JoinColumn(name = "cart_id", insertable = false, updatable = false)
            private CartOIO cart;

        Entry Address :
            @OneToMany
            @JoinColumn(name = "cart_id") // we need to duplicate the physical information
            private Set<ItemsOIO> items;

https://www.baeldung.com/jpa-many-to-many
MANY TO MANY :(mininal join table)
        Entity People :
            @ManyToMany
            Set<Address> addresses;

        Entry Address :
            @ManyToMany
            Set<People> peoples;

MANY TO MANY :(composite join table)
        Entity People :
            @ManyToMany
            Set<Address> addresses;

        Entry Address :
            @ManyToMany
            Set<People> peoples;
MANY TO MANY :(composite join table)
        Entity People :
            @ManyToMany
            Set<Address> addresses;

        Entry Address :
            @ManyToMany
            Set<People> peoples;




 */

@Entity
@Table(name = "peoples")
public class People {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "Name")   // will be "name" in database
        private String name;

        @ManyToOne
        @JoinColumn(name = "address_id", insertable = false, updatable = false)
        private Address address;

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
