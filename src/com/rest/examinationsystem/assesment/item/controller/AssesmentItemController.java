package com.rest.examinationsystem.assesment.item.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.examinationsystem.assesment.item.service.AssesmentItemService;
import com.rest.examinationsystem.assessment.item.options.dto.AssesmentItemOptionDto;
import com.rest.examinationsystem.assessment.item.options.service.AssesmentItemOptionService;
import com.rest.examinationsystem.util.DateUtil;
import com.rest.examinationsystem.util.ExcelUtil;
import com.rest.examinationsystem.util.ImageUtil;
import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/assesmentItem")
@Api(value = "Excel Upload", description = "Operations For Excel Upload")

@Transactional
public class AssesmentItemController {

	@Autowired
	private AssesmentItemService assesmentItemService;
	@Autowired
	private AssesmentItemOptionService assesmentItemOptionService;

	@Value("${assesmentFilePath}")
	private String assesmentFilePath;

	@Autowired
	private ExcelUtil excelUtil;

	@ApiOperation(value = "Create Assesment Item with option")
	@RequestMapping(value = "/createAssesmentItem", method = RequestMethod.POST)
	public ResponseEntity createAssesmentItem(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("excel") MultipartFile file) throws UnauthorizedException, ParseException, IOException {

		ResponseBean responseBean = new ResponseBean();
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		InputStream targetStream=new BufferedInputStream(file.getInputStream());
		InputStream targetStream1=new BufferedInputStream(file.getInputStream());

		Map<AssesmentItemDto, List<AssesmentItemOptionDto>> assesmentItemDtoMap= excelUtil.convertExcelToItemObject(targetStream,targetStream1);
		
		for(AssesmentItemDto assesmentItemDto:assesmentItemDtoMap.keySet())
		{
			Long assesmentItemId =  (Long)assesmentItemService.create(assesmentItemDto);
			assesmentItemDto.setId(assesmentItemId);
			for(AssesmentItemOptionDto assesmentItemOptionDto:assesmentItemDtoMap.get(assesmentItemDto))
			{   assesmentItemOptionDto.setAssesmentItem(assesmentItemDto);
				assesmentItemOptionService.create(assesmentItemOptionDto);
			}

		}

		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/getAssesmentItemById", method =
	 * RequestMethod.GET) public ResponseEntity
	 * getAssesmentItemById(@RequestHeader("API-KEY") String
	 * apiKey, @RequestParam("Id") long id) throws UnauthorizedException,
	 * ParseException, IOException, NoRecordsFoundException { if
	 * (!apiKey.equals(MessageEnum.API_KEY)) { throw new
	 * UnauthorizedException(MessageEnum.unathorized); } ResponseBean
	 * responseBean = new ResponseBean(); return new
	 * ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK); }
	 * 
	 * @RequestMapping(value = "/updateAssesmentItem", method =
	 * RequestMethod.POST) public ResponseEntity
	 * updateUser(@RequestHeader("API-KEY") String apiKey) throws
	 * UnauthorizedException, ParseException, IOException,
	 * NoRecordsFoundException {
	 * 
	 * if (!apiKey.equals(MessageEnum.API_KEY)) { throw new
	 * UnauthorizedException(MessageEnum.unathorized); } ResponseBean
	 * responseBean = new ResponseBean(); return new
	 * ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK); }
	 */

}
