package com.explorespring.exploreSP.utility;

import java.util.regex.PatternSyntaxException;

abstract class Generator {
    private String regexp;

    abstract void setRegexp(String regexp) throws PatternSyntaxException;

}
