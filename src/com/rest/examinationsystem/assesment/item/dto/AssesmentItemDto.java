/**
 * 
 */
package com.rest.examinationsystem.assesment.item.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;


public class AssesmentItemDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;
	
	private String assessmentItemTopic;

	private String  assessmentItemGivenId;
	
	private String  assesmentItemType;
	
	private String  assessmentItemText;
	
	private byte[]  assessmentItemImage;
	
	private int  assessmentItemMarks;
	
	private int assessmentItemNegativeMarks;
	
	private int assesmentItemNoOfOption;
	
//	@Column(name = "photo", unique = false, nullable = false, length = 100000)
//    private byte[] photo;
//	
	private String maxTimeAllowed;
	
	private int correctOption;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAssessmentItemTopic() {
		return assessmentItemTopic;
	}

	public void setAssessmentItemTopic(String assessmentItemTopic) {
		this.assessmentItemTopic = assessmentItemTopic;
	}

	public int getAssesmentItemNoOfOption() {
		return assesmentItemNoOfOption;
	}

	public void setAssesmentItemNoOfOption(int assesmentItemNoOfOption) {
		this.assesmentItemNoOfOption = assesmentItemNoOfOption;
	}

	public int getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
}
