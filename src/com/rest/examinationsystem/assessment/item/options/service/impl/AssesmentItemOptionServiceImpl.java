package com.rest.examinationsystem.assessment.item.options.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.examinationsystem.assesment.item.dao.AssesmentItemDao;
import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.examinationsystem.assesment.item.entity.AssesmentItem;
import com.rest.examinationsystem.assesment.item.mapper.AssesmentItemMapper;
import com.rest.examinationsystem.assesment.item.service.AssesmentItemService;
import com.rest.examinationsystem.assessment.item.options.dao.AssesmentItemOptionDao;
import com.rest.examinationsystem.assessment.item.options.dto.AssesmentItemOptionDto;
import com.rest.examinationsystem.assessment.item.options.entity.AssesmentItemOption;
import com.rest.examinationsystem.assessment.item.options.mapper.AssesmentItemOptionMapper;
import com.rest.examinationsystem.assessment.item.options.service.AssesmentItemOptionService;
import com.rest.framework.service.impl.AbstractService;


@Service
@Transactional
public class AssesmentItemOptionServiceImpl extends AbstractService<AssesmentItemOptionDao, AssesmentItemOptionDto, AssesmentItemOptionMapper, AssesmentItemOption>  implements AssesmentItemOptionService{

	
}
