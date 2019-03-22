package com.rest.examinationsystem.assesment.item.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.examination.system.util.DateUtil;
import com.rest.examination.system.util.ImageUtil;
import com.rest.examinationsystem.assesment.item.service.AssesmentItemService;
import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;


@RestController
@RequestMapping(value = "/assesmentItem")
@Transactional
public class AssesmentItemController {

	@Autowired
	private AssesmentItemService assesmentItemService;

	@RequestMapping(value = "/createAssesmentItem", method = RequestMethod.POST)
	public ResponseEntity createAssesmentItem(@RequestHeader("API-KEY") String apiKey)
			throws UnauthorizedException, ParseException, IOException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@RequestMapping(value = "/getAssesmentItemById", method = RequestMethod.GET)
	public ResponseEntity getAssesmentItemById(@RequestHeader("API-KEY") String apiKey, @RequestParam("Id") long id)
			throws UnauthorizedException, ParseException, IOException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAssesmentItem", method = RequestMethod.POST)
	public ResponseEntity updateUser(@RequestHeader("API-KEY") String apiKey)
			throws UnauthorizedException, ParseException, IOException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	
	//===================== Private Method =======================
//	private UserDto mapUserRequestDtoToUserDto(UserDto userDto, MultipartFile file, String password,
//			String emailAddress, String firstName, String middleName, String lastName, String adminId, String createdOn)
//			throws ParseException, IOException {
//		userDto.setAdminId(adminId);
//		if(createdOn!=null && createdOn.length()>0) {
//		 userDto.setCreatedOn(DateUtil.getFormattedDate(createdOn, "yyyy-MM-dd"));
//		}
//		userDto.setEmailAddress(emailAddress);
//		userDto.setFirstName(firstName);
//		userDto.setLastName(lastName);
//		userDto.setMiddleName(middleName);
//		userDto.setPassword(password);
//		if (file != null) {
//			userDto.setPhoto(ImageUtil.getByteArrayFromMaltipartFormData(file));
//		}
//		return userDto;
//	}
//
//	private UserRequestDto mapUserRequestDtoToUserDto(UserDto userDto) throws ParseException {
//		UserRequestDto userRequestDto = null;
//		if (userDto != null) {
//			userRequestDto = new UserRequestDto();
//			userRequestDto.setAdminId(userDto.getAdminId());
//			if (userDto.getCreatedOn() != null) {
//				userRequestDto
//						.setCreatedOn(DateUtil.getFormattedDateStringFromDate(userDto.getCreatedOn(), "yyyy-mm-dd"));
//			}
//			userRequestDto.setEmailAddress(userDto.getEmailAddress());
//			userRequestDto.setFirstName(userDto.getFirstName());
//			userRequestDto.setId(userDto.getId());
//			userRequestDto.setLastName(userDto.getLastName());
//			userRequestDto.setMiddleName(userDto.getMiddleName());
//			userRequestDto.setPassword(userDto.getPassword());
//			if (userDto.getPhoto() != null && userDto.getPhoto().length > 0) {
//				userRequestDto.setPhoto(ImageUtil.getBase64FromByteArray(userDto.getPhoto()));
//			}
//		}
//		return userRequestDto;
//	}
}
