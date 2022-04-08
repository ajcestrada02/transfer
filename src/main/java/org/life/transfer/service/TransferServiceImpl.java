package org.life.transfer.service;

import java.util.ArrayList;
import java.util.List;

import org.life.transfer.entity.CustomTyp;
import org.life.transfer.repository.CustomTypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService{
	
	@Autowired
	private CustomTypRepository customTypRepository;
	
	public List<CustomTyp> getCmpltSttsTyp() {
		
		List<CustomTyp> customTyp = new ArrayList<CustomTyp>();
		
		customTyp.add(customTypRepository.findByCstmTypId("ST_CP"));
		customTyp.add(customTypRepository.findByCstmTypId("ST_RJ"));
		customTyp.add(customTypRepository.findByCstmTypId("ST_RJT"));
		customTyp.add(customTypRepository.findByCstmTypId("ST_CN"));
		customTyp.add(customTypRepository.findByCstmTypId("ST_TD"));
		
		return customTyp;
	}

}
