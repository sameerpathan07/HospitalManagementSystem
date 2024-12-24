package com.service;

import java.util.ArrayList;

import com.daolayer.DAO;
import com.pojo.Patient;

public class PatientServiceImpl implements PatientI {

	@Override
	public void regiter(Patient p) {
		DAO.insertPatientD(p);
	}

	@Override
	public  boolean IsRegisted(Patient p) {
		boolean b= DAO.checkId(p.getPid());
		return b;
	}

	@Override
	public void updateDetails(String a,int b,String c) {
		DAO.updateDetails(a,b,c);
		
	}

	@Override
	public void deleteEntry(Patient p) {
		DAO.deletePatient(p.getPid());
		
	}

	@Override
	public void viewData() {
		DAO.readDetails();		
	}

	@Override
	public ArrayList<Patient>  fetchData() {
		
		return DAO.fetchAllData();
	}

	@Override
	public ArrayList<Patient> fetchDataIdWise(Patient p) {
		
		return DAO.fetchDataIdWise(p.getPid());
	}

}
