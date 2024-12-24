package com.service;

import java.util.ArrayList;

import com.pojo.Patient;

public interface PatientI {
public void regiter(Patient p);
public boolean IsRegisted(Patient p);
public void updateDetails(String a,int b,String c);
public void deleteEntry(Patient p);
public void viewData();
public ArrayList<Patient> fetchData();
public ArrayList<Patient> fetchDataIdWise(Patient p);
}
