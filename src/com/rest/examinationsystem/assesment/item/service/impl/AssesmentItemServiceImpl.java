package com.rest.examinationsystem.assesment.item.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.examinationsystem.assesment.item.dao.AssesmentItemDao;
import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.examinationsystem.assesment.item.entity.AssesmentItem;
import com.rest.examinationsystem.assesment.item.mapper.AssesmentItemMapper;
import com.rest.examinationsystem.assesment.item.service.AssesmentItemService;
import com.rest.framework.service.impl.AbstractService;


@Service
@Transactional
public class AssesmentItemServiceImpl extends AbstractService<AssesmentItemDao, AssesmentItemDto, AssesmentItemMapper, AssesmentItem>  implements AssesmentItemService{

	
}
