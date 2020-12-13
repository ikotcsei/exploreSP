package com.explorespring.exploreSP.utility;

import com.mifmif.common.regex.Generex;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class NameGenerator extends Generator {
    private String validatedRegexp;
    private Integer maxLength;
    private Integer minLength;
    private Generex generex;

    public NameGenerator(String regexp) throws PatternSyntaxException{
        try {
            setRegexp(regexp);
            generex= new Generex(validatedRegexp);
        }catch(Exception e){
            throw e;
        }
    }

    public NameGenerator(String regexp, Integer min, Integer max) throws PatternSyntaxException{
        this(regexp);
        this.minLength = min;
        this.maxLength = max;
    }

    @Override
    void setRegexp(String regexp) throws PatternSyntaxException {
        try {
            Pattern.compile(regexp);
        }catch (Exception e){
            throw e;
        }

        this.validatedRegexp = regexp;
    }

    public String getRandomName(){

        //max length is set
        if(maxLength != -1){
            return generex.random(minLength,maxLength);
        }

        return generex.random();
    }


}
