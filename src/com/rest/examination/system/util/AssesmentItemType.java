package com.rest.examination.system.util;

public enum AssesmentItemType {
	
	Multiple_Choice_Text("Multiple_Choice_Text"),
	Multiple_Choice_Image("Multiple_Choice_Image"),
	Multiple_Response_Text("Multiple_Response_Text"),
	Multiple_Response_Image("Multiple_Response_Image"),
	True_False("True_False"),
	Fill_In_The_Blank("Fill_In_The_Blank");
	
	public String enumValue;
	
	AssesmentItemType(String enumValue){
		this.enumValue = enumValue;
	}
	
	public String getEnumValue() {
		return enumValue;
	}
	
	public static AssesmentItemType getAssesmentItemType(String enumValue){
		
		for(AssesmentItemType assesmentItemType : AssesmentItemType.values()) {
			if(assesmentItemType.getEnumValue().equals(enumValue)) {
				return assesmentItemType;
			}
		}
		return null;
	}
	

}
