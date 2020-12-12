package com.explorespring.exploreSP.utility;

public class RandomDataGenerator implements RandomItems{

    private final Integer maxNeutral;
    private final Integer minNeutral;
    private final Character maxCharacter;
    private final Character minCharacter;


    //constructors + build
    public static class Builder{
        //required fields : none
        //private final Integer

        //optional fields
        private Integer maxNeutral=0;
        private Integer minNeutral=100;
        private Character maxCharacter='z';
        private Character minCharacter='a';


        public Builder() {

        }

        public Builder maxNeutral(Integer val){
            this.maxNeutral =val;
            return this;
        }

        public Builder MinNeutral(Integer minNeutral) {
            this.minNeutral = minNeutral;
            return this;
        }

        public Builder MaxCharacter(Character maxCharacter) {
            this.maxCharacter = maxCharacter;
            return this;
        }

        public Builder MinCharacter(Character minCharacter) {
            this.minCharacter = minCharacter;
            return this;
        }

        public RandomDataGenerator build() {
            return new RandomDataGenerator(this);
        }
    }

    private RandomDataGenerator(Builder b){
        this.maxNeutral = b.maxNeutral;
        this.minNeutral = b.minNeutral;
        this.maxCharacter = b.maxCharacter;
        this.minCharacter = b.minCharacter;
    }

    @Override
    public Integer getRandomNum() {
        return null;
    }

    @Override
    public Character getRandomChar() {
        return null;
    }

    @Override
    public String getRandomString() {
        return null;
    }

    //rnd string

}
