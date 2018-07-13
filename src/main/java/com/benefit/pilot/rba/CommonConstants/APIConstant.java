package com.benefit.pilot.rba.CommonConstants;

public enum APIConstant {
	
	SUCCESS(200),
	FAILURE(0),
	INTERNAL_SERVER_ERROR(500);
	
	int value;
    String stringVal;

    private APIConstant(int value) {
        this.value = value;
        this.stringVal = String.valueOf(value);
    }
     public int intValue() {
        return this.value;
    }
    public String stringValue() {
        return this.stringVal;
    }

}
