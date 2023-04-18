package com.metis.nopaper.work.security.enums;

public enum ValidationType {
	
	ANONYMOUS ("Online");

    String value;

    ValidationType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
