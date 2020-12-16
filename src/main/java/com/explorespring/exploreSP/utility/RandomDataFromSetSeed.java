package com.explorespring.exploreSP.utility;

import java.util.*;

public class RandomDataFromSetSeed {
    /*
           define n sets from the data gets generated
           Set1 x Set2 x ..  x Setn
    * */

    private Set<String> seed1;
    private Set<String> seed2;

    private List<Set<String>> sets;

    public RandomDataFromSetSeed() {
        sets.add(new HashSet<String>());
        sets.add(new HashSet<String>());

//        sets.get(1).add("asdf");

    }
}
