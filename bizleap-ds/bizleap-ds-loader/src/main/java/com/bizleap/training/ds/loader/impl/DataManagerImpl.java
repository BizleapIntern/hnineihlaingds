package com.bizleap.training.ds.loader.impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.commons.domain.Company;
import com.bizleap.commons.domain.Employee;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.AssociationMapper;
import com.bizleap.training.ds.loader.CompanySaver;
import com.bizleap.training.ds.loader.DataLoader;
import com.bizleap.training.ds.loader.DataManager;

@Service("dataManager")
public class DataManagerImpl implements DataManager {
	List<Employee> employeeList=new ArrayList<Employee>();
	List<Company> companyList=new ArrayList<Company>();
	
	@Autowired
	private DataLoader dataLoader;
	
	@Autowired
	CompanySaver companySaver;
	
	@Autowired
	private AssociationMapper associationMapper;
	
	public void load() throws IOException, ServiceUnavailableException {
		//load the data
		dataLoader.loadData();
		//build the association
		associationMapper.buildAssociations();
		companySaver.setCompanyList(companyList);
		companySaver.savePass1();
	}

	public void print() {
		for(Employee employee:employeeList) {
			System.out.println(employee);
		}
		for(Company company:companyList) {
			System.out.println(company);
		}
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Company> getCompanyList() {
		return companyList;
	}
}
