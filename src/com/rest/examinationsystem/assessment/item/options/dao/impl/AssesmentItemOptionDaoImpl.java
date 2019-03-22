package com.rest.examinationsystem.assessment.item.options.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.examinationsystem.assessment.item.options.dao.AssesmentItemOptionDao;
import com.rest.examinationsystem.assessment.item.options.entity.AssesmentItemOption;
import com.rest.framework.dao.impl.AbstractDAO;

@Repository
@Transactional
public class AssesmentItemOptionDaoImpl extends AbstractDAO<AssesmentItemOption> implements AssesmentItemOptionDao{

	 
}
