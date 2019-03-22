package com.rest.examinationsystem.assesment.item.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.examinationsystem.assesment.item.dao.AssesmentItemDao;
import com.rest.examinationsystem.assesment.item.entity.AssesmentItem;
import com.rest.framework.dao.impl.AbstractDAO;

@Repository
@Transactional
public class AssesmentItemDaoImpl extends AbstractDAO<AssesmentItem> implements AssesmentItemDao{

	 
}
