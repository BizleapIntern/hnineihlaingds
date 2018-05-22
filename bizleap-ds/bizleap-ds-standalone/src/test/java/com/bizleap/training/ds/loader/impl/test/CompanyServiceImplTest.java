package com.bizleap.training.ds.loader.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.impl.test.DataManagerImplTest;
import com.bizleap.training.ds.loader.impl.test.ServiceTest;
import com.bizleap.training.ds.service.CompanyService;

public class CompanyServiceImplTest extends ServiceTest {
	static Logger logger=Logger.getLogger(DataManagerImplTest.class);
	
	@Autowired
	protected CompanyService companyService;
	
	//@Ignore
	@Test
	
	public void testFindByCompanyBoId()throws ServiceUnavailableException, IOException{
		assertNotNull(companyService.findByCompanyBoId("COMP01"));
		logger.info("Company List:"+companyService.findByCompanyBoId("COMP01"));
		assertTrue(CollectionUtils.isNotEmpty(companyService.findByCompanyBoId("COMP01")));
	}	
	
	@Ignore
	@Test
	public void testgetAllCompany()throws ServiceUnavailableException{
		assertNotNull(companyService.getAllCompany());
		logger.info("Employee List:"+companyService.getAllCompany());
		assertTrue(CollectionUtils.isNotEmpty(companyService.getAllCompany()));
		assertEquals(3,companyService.getAllCompany().size());
	}
	

}
