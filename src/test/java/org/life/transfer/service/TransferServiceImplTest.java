package org.life.transfer.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.life.transfer.entity.CustomTyp;
import org.life.transfer.repository.CustomTypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TransferServiceImplTest {
	
	@Autowired
	private CustomTypRepository customTypRepository;
	
	@Autowired
	private TransferService transferService;
	
	@Test
	void getCmpltSttsTyp_success_has_ST_CN() {
		CustomTyp customTyp = new CustomTyp();
		customTyp.setAdmDsplyLblTxt(null);
		customTyp.setCstmGrpId("ST");
		customTyp.setCstmGrpTxt("Status Type");
		customTyp.setCstmTypDtlTxt("Completed");
		customTyp.setCstmTypId("Completed");
		customTyp.setCstmTypId("ST_CN");
		customTypRepository.save(customTyp);
		
		var actual = transferService.getCmpltSttsTyp();
		
		var expected = false;
		for(CustomTyp c: actual) {
			if( c != null && c.getCstmTypId().equals("ST_CN")) {
				expected = true;
			}
		}
				
		Assert.isTrue(expected);
	}
	
	@Test
	void getCmpltSttsTyp_success_has_ST_CP() {
		CustomTyp customTyp = new CustomTyp();
		customTyp.setAdmDsplyLblTxt(null);
		customTyp.setCstmGrpId("ST");
		customTyp.setCstmGrpTxt("Status Type");
		customTyp.setCstmTypDtlTxt("Completed");
		customTyp.setCstmTypId("Completed");
		customTyp.setCstmTypId("ST_CP");
		customTypRepository.save(customTyp);
		
		var actual = transferService.getCmpltSttsTyp();
		
		var expected = false;
		for(CustomTyp c: actual) {
			if( c != null && c.getCstmTypId().equals("ST_CP")) {
				expected = true;
			}
		}
				
		Assert.isTrue(expected);
	}
	
	@Test
	void getCmpltSttsTyp_fail_ST_CP() {
		CustomTyp customTyp = new CustomTyp();
		customTyp.setAdmDsplyLblTxt(null);
		customTyp.setCstmGrpId("ST");
		customTyp.setCstmGrpTxt("Status Type");
		customTyp.setCstmTypDtlTxt("Completed");
		customTyp.setCstmTypId("Completed");
		customTyp.setCstmTypId("ST_RJ");
		customTypRepository.save(customTyp);
		
		var actual = transferService.getCmpltSttsTyp();
		
		var expected = false;
		for(CustomTyp c: actual) {
			if( c != null && c.getCstmTypId().equals("ST_CP")) {
				expected = true;
			}
		}
				
		Assert.isTrue(!expected);
	}

}
