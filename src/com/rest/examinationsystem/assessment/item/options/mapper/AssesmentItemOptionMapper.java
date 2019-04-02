/**
 * 
 */
package com.rest.examinationsystem.assessment.item.options.mapper;

import org.springframework.stereotype.Component;

import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.examinationsystem.assesment.item.entity.AssesmentItem;
import com.rest.examinationsystem.assessment.item.options.dto.AssesmentItemOptionDto;
import com.rest.examinationsystem.assessment.item.options.entity.AssesmentItemOption;
import com.rest.examinationsystem.util.AssesmentItemType;
import com.rest.framework.mapper.AbstractMapper;


@Component
public class AssesmentItemOptionMapper extends AbstractMapper<AssesmentItemOptionDto , AssesmentItemOption>{

	@Override
	public AssesmentItemOption mapDtoToEntity(AssesmentItemOptionDto dto) {
		AssesmentItemOption assesmentItemOption = null;
		AssesmentItem assesmentItem = null;
		if (dto != null) {
			assesmentItemOption = new AssesmentItemOption();
			assesmentItemOption.setComment(dto.getComment());
			assesmentItemOption.setCorrectAnswer(dto.getCorrectAnswer());
			assesmentItemOption.setId(dto.getId());
			assesmentItemOption.setOptionImage(dto.getOptionImage());
			assesmentItemOption.setOptionText(dto.getOptionText());
			assesmentItemOption.setComment(dto.getComment());
			if(dto.getAssesmentItem()!=null) {
				assesmentItem = new AssesmentItem();
				assesmentItem.setAssessmentItemGivenId(dto.getAssesmentItem().getAssessmentItemGivenId());
				assesmentItem.setAssessmentItemImage(dto.getAssesmentItem().getAssessmentItemImage());
				assesmentItem.setAssessmentItemMarks(dto.getAssesmentItem().getAssessmentItemMarks());
				assesmentItem.setAssessmentItemNegativeMarks(dto.getAssesmentItem().getAssessmentItemNegativeMarks());
				assesmentItem.setAssessmentItemText(dto.getAssesmentItem().getAssessmentItemText());
				assesmentItem.setComment(dto.getAssesmentItem().getComment());
				assesmentItem.setAssesmentItemType(AssesmentItemType.getAssesmentItemType(dto.getAssesmentItem().getAssesmentItemType()));
				assesmentItem.setComment(dto.getAssesmentItem().getComment());
				assesmentItem.setId(dto.getAssesmentItem().getId());
				assesmentItem.setMaxTimeAllowed(dto.getAssesmentItem().getMaxTimeAllowed());
				assesmentItemOption.setAssesmentItem(assesmentItem);
			}
		}
		return assesmentItemOption;
	}

	@Override
	public AssesmentItemOptionDto mapEntityToDto(AssesmentItemOption bo) {
		AssesmentItemOptionDto assesmentItemOption = null;
		AssesmentItemDto assesmentItem = null;
		if (bo != null) {
			assesmentItemOption = new AssesmentItemOptionDto();
			assesmentItemOption.setComment(bo.getComment());
			assesmentItemOption.setCorrectAnswer(bo.getCorrectAnswer());
			assesmentItemOption.setId(bo.getId());
			assesmentItemOption.setOptionImage(bo.getOptionImage());
			assesmentItemOption.setOptionText(bo.getOptionText());
			assesmentItemOption.setComment(bo.getComment());
			if(bo.getAssesmentItem()!=null) {
				assesmentItem = new AssesmentItemDto();
				assesmentItem.setAssessmentItemGivenId(bo.getAssesmentItem().getAssessmentItemGivenId());
				assesmentItem.setAssessmentItemImage(bo.getAssesmentItem().getAssessmentItemImage());
				assesmentItem.setAssessmentItemMarks(bo.getAssesmentItem().getAssessmentItemMarks());
				assesmentItem.setAssessmentItemNegativeMarks(bo.getAssesmentItem().getAssessmentItemNegativeMarks());
				assesmentItem.setAssessmentItemText(bo.getAssesmentItem().getAssessmentItemText());
				assesmentItem.setComment(bo.getAssesmentItem().getComment());
				if (AssesmentItemType.getAssesmentItemType(bo.getAssesmentItem().getAssesmentItemType().getEnumValue()) != null) {
					assesmentItem.setAssesmentItemType(bo.getAssesmentItem().getAssesmentItemType().getEnumValue());
				}
				assesmentItem.setComment(bo.getAssesmentItem().getComment());
				assesmentItem.setId(bo.getAssesmentItem().getId());
				assesmentItem.setMaxTimeAllowed(bo.getAssesmentItem().getMaxTimeAllowed());
				assesmentItemOption.setAssesmentItem(assesmentItem);
			}
		}
		return assesmentItemOption;
	}	
}
