/**
 * 
 */
package com.rest.examinationsystem.assessment.item.options.dto;

import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.framework.dto.AbstractIdentifierDTO;


public class AssesmentItemOptionDto extends AbstractIdentifierDTO{
	
	private static final long serialVersionUID = 1L;

	private AssesmentItemDto assesmentItem;
	
	private String  optionText;

	private byte[]  optionImage;

	private String  correctAnswer;

	private int  comment;

	public AssesmentItemDto getAssesmentItem() {
		return assesmentItem;
	}

	public void setAssesmentItem(AssesmentItemDto assesmentItem) {
		this.assesmentItem = assesmentItem;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public byte[] getOptionImage() {
		return optionImage;
	}

	public void setOptionImage(byte[] optionImage) {
		this.optionImage = optionImage;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
