package org.life.transfer.controller;

import java.util.List;

import org.life.transfer.entity.CustomTyp;
import org.life.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
	
	@Autowired
	private TransferService tranferService;
	
	@GetMapping(value = "/getCmpltSttsTyp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomTyp>> getCmpltSttsTyp(){
		return new ResponseEntity<List<CustomTyp>>(tranferService.getCmpltSttsTyp(),HttpStatus.OK);
	}
}
