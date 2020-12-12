package com.explorespring.exploreSP.utility;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class NameGenerator extends Generator {
    private String validatedRegexp;
    private Integer maxLength;
    private Integer minLength;

    @Override
    void setRegexp(String regexp) throws PatternSyntaxException {
        try {
            Pattern.compile(regexp);
        }catch (Exception e){
            throw e;
        }

        this.validatedRegexp = regexp;
    }


}
