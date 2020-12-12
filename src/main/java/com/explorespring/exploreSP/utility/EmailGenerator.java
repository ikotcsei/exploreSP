package com.explorespring.exploreSP.utility;

import com.mifmif.common.regex.Generex;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EmailGenerator extends Generator{
    private String validatedRegexp;
    private Integer maxLength=-1;
    private Integer minLength=-1;
    private Generex generex;

    public EmailGenerator(String regexp) throws PatternSyntaxException{
        try {
            setRegexp(regexp);
            generex= new Generex(validatedRegexp);
        }catch(Exception e){
            throw e;
        }
    }

    //Generex generex = new Generex(errorReg);

    @Override
    void setRegexp(String regexp) throws PatternSyntaxException {
        try {
            Pattern.compile(regexp);
        }catch (Exception e){
            throw e;
        }

        this.validatedRegexp = regexp;
    }

    public String getEmail(){
        return generex.random();
    }
}
