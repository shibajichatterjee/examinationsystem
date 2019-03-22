package com.rest.examinationsystem.assesment.item.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AssesmentItemRequestDto {
	
private String  assessmentItemGivenId;
	
	private String  assesmentItemType;
	
	private String  assessmentItemText;
	
	private byte[]  assessmentItemImage;
	
	private int  assessmentItemMarks;
	
	private int assessmentItemNegativeMarks;
	
//	@Column(name = "photo", unique = false, nullable = false, length = 100000)
//    private byte[] photo;
//	
	private String maxTimeAllowed;
	
	private String comment;

	public String getAssessmentItemGivenId() {
		return assessmentItemGivenId;
	}

	public void setAssessmentItemGivenId(String assessmentItemGivenId) {
		this.assessmentItemGivenId = assessmentItemGivenId;
	}

	public String getAssesmentItemType() {
		return assesmentItemType;
	}

	public void setAssesmentItemType(String assesmentItemType) {
		this.assesmentItemType = assesmentItemType;
	}

	public String getAssessmentItemText() {
		return assessmentItemText;
	}

	public void setAssessmentItemText(String assessmentItemText) {
		this.assessmentItemText = assessmentItemText;
	}

	public byte[] getAssessmentItemImage() {
		return assessmentItemImage;
	}

	public void setAssessmentItemImage(byte[] assessmentItemImage) {
		this.assessmentItemImage = assessmentItemImage;
	}

	public int getAssessmentItemMarks() {
		return assessmentItemMarks;
	}

	public void setAssessmentItemMarks(int assessmentItemMarks) {
		this.assessmentItemMarks = assessmentItemMarks;
	}

	public int getAssessmentItemNegativeMarks() {
		return assessmentItemNegativeMarks;
	}

	public void setAssessmentItemNegativeMarks(int assessmentItemNegativeMarks) {
		this.assessmentItemNegativeMarks = assessmentItemNegativeMarks;
	}

	public String getMaxTimeAllowed() {
		return maxTimeAllowed;
	}

	public void setMaxTimeAllowed(String maxTimeAllowed) {
		this.maxTimeAllowed = maxTimeAllowed;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//private String createdOn;
}
