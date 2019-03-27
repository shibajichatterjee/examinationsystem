/**
 * 
 */
package com.rest.examinationsystem.assessment.item.options.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.examinationsystem.assesment.item.entity.AssesmentItem;
import com.rest.examinationsystem.util.AssesmentItemType;
import com.rest.framework.entity.AbstractIdentifierObject;

@Entity
@Table(name = "ASSESMENT_ITEM_OPTION")
public class AssesmentItemOption extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="assessment_item_id")
	private AssesmentItem assesmentItem;
	
	@Column(name="option_text")
	private String  optionText;
	
	@Lob
	@Column(name="option_image", columnDefinition = "BLOB" )
	private byte[]  optionImage;
	
	@Column(name="correct_answer")
	private String  correctAnswer;

	@Column(name="comment")
	private int  comment;

    public AssesmentItem getAssesmentItem() {
		return assesmentItem;
	}

	public void setAssesmentItem(AssesmentItem assesmentItem) {
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
