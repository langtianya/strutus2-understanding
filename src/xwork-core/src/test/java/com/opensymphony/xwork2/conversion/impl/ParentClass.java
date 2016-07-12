package com.opensymphony.xwork2.conversion.impl;

/**
 * <code>ParentClass</code>
 *
 * @author <a href="mailto:hermanns@aixcept.de">Rainer Hermanns</a>
 * @version $Id: ParentClass.java 894087 2009-12-27 18:00:13Z martinc $
 */
public class ParentClass {

    public enum NestedEnum {
        TEST,
        TEST2,
        TEST3
    }


    private NestedEnum value;

    public void setValue(NestedEnum value) {
        this.value = value;
    }

    public NestedEnum getValue() {
        return value;
    }
}
