/**
 * 
 */
package com.rest.examinationsystem.assesment.item.mapper;

import org.springframework.stereotype.Component;

import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.examinationsystem.assesment.item.entity.AssesmentItem;
import com.rest.examinationsystem.util.AssesmentItemType;
import com.rest.framework.mapper.AbstractMapper;


@Component
public class AssesmentItemMapper extends AbstractMapper<AssesmentItemDto , AssesmentItem>{

	@Override
	public AssesmentItem mapDtoToEntity(AssesmentItemDto dto) {
		AssesmentItem assesmentItem = null;
		if (dto != null) {
			assesmentItem = new AssesmentItem();
			assesmentItem.setAssessmentItemGivenId(dto.getAssessmentItemGivenId());
			assesmentItem.setAssessmentItemImage(dto.getAssessmentItemImage());
			assesmentItem.setAssessmentItemMarks(dto.getAssessmentItemMarks());
			assesmentItem.setAssessmentItemNegativeMarks(dto.getAssessmentItemNegativeMarks());
			assesmentItem.setAssessmentItemText(dto.getAssessmentItemText());
			assesmentItem.setComment(dto.getComment());
			assesmentItem.setAssesmentItemType(AssesmentItemType.getAssesmentItemType(dto.getAssesmentItemType()));
			assesmentItem.setComment(dto.getComment());
			assesmentItem.setId(dto.getId());
			assesmentItem.setMaxTimeAllowed(dto.getMaxTimeAllowed());
		}
		return assesmentItem;
	}

	@Override
	public AssesmentItemDto mapEntityToDto(AssesmentItem bo) {
		AssesmentItemDto assesmentItem = null;
		if (bo != null) {
			assesmentItem = new AssesmentItemDto();
			assesmentItem.setAssessmentItemGivenId(bo.getAssessmentItemGivenId());
			assesmentItem.setAssessmentItemImage(bo.getAssessmentItemImage());
			assesmentItem.setAssessmentItemMarks(bo.getAssessmentItemMarks());
			assesmentItem.setAssessmentItemNegativeMarks(bo.getAssessmentItemNegativeMarks());
			assesmentItem.setAssessmentItemText(bo.getAssessmentItemText());
			assesmentItem.setComment(bo.getComment());
			if (AssesmentItemType.getAssesmentItemType(bo.getAssesmentItemType().getEnumValue()) != null) {
				assesmentItem.setAssesmentItemType(bo.getAssesmentItemType().getEnumValue());
			}
			assesmentItem.setComment(bo.getComment());
			assesmentItem.setId(bo.getId());
			assesmentItem.setMaxTimeAllowed(bo.getMaxTimeAllowed());
		}
		return assesmentItem;
	}	
}
