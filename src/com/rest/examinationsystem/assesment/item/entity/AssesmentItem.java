/**
 * 
 */
package com.rest.examinationsystem.assesment.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.rest.examinationsystem.util.AssesmentItemType;
import com.rest.framework.entity.AbstractIdentifierObject;

@Entity
@Table(name = "ASSESMENT_ITEM")
public class AssesmentItem extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@Column(name="assessment_item_topic")
	private String  assessmentItemTopic;
	
	@Column(name="assessment_item_given_id")
	private String  assessmentItemGivenId;
	
	@Column(name="assessment_item_type")
	@Enumerated(EnumType.ORDINAL)
	private AssesmentItemType  assesmentItemType;
	
	@Column(name="assessment_item_text")
	private String  assessmentItemText;
	
	@Lob
	@Column(name="assessment_item_image", columnDefinition = "BLOB" )
	private byte[]  assessmentItemImage;
	
	@Column(name="assessment_item_marks")
	private int  assessmentItemMarks;
	
	@Column(name="assessment_item_negative_marks")
	private int assessmentItemNegativeMarks;
	
	@Column(name="assessment_item_no_of_option")
	private int assesmentItemNoOfOption;
	
	@Column(name="correct_option")
	private int correctOption;
	
	
//	@Column(name = "photo", unique = false, nullable = false, length = 100000)
//    private byte[] photo;
//	
	@Column(name="max_time_allowed")
	private String maxTimeAllowed;
	
	@Column(name="comment")
	private String comment;

	public String getAssessmentItemGivenId() {
		return assessmentItemGivenId;
	}

	public void setAssessmentItemGivenId(String assessmentItemGivenId) {
		this.assessmentItemGivenId = assessmentItemGivenId;
	}

	public AssesmentItemType getAssesmentItemType() {
		return assesmentItemType;
	}

	public void setAssesmentItemType(AssesmentItemType assesmentItemType) {
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

	public int getAssesmentItemNoOfOption() {
		return assesmentItemNoOfOption;
	}

	public void setAssesmentItemNoOfOption(int assesmentItemNoOfOption) {
		this.assesmentItemNoOfOption = assesmentItemNoOfOption;
	}

	public String getAssessmentItemTopic() {
		return assessmentItemTopic;
	}

	public void setAssessmentItemTopic(String assessmentItemTopic) {
		this.assessmentItemTopic = assessmentItemTopic;
	}

	public int getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}

}
