package com.rest.examinationsystem.assessment.item.options.dto;

import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;

public class AssesmentItemOptionRequestDto {
	
	private String assessmentItemGivenId;

	private static final long serialVersionUID = 1L;

	private AssesmentItemDto assesmentItem;

	private String optionText;

	private byte[] optionImage;

	private String correctAnswer;

	private int comment;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//private String createdOn;
}
