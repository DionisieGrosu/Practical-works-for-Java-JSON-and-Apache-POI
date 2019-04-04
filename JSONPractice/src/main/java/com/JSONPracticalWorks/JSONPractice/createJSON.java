package com.JSONPracticalWorks.JSONPractice;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class createJSON {

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject employee1D1Values = new JSONObject();
		JSONObject employee1D1 = new JSONObject();
		JSONObject employee2D1Values = new JSONObject();
		JSONObject employee2D1 = new JSONObject();
		JSONObject employee3D1Values = new JSONObject();
		JSONObject employee3D1 = new JSONObject();
		JSONObject department1 = new JSONObject();
		JSONArray Skills1D1 = new JSONArray();
		Skills1D1.add("Communication");
		Skills1D1.add("Java");
		JSONArray Skills2D1 = new JSONArray();
		Skills2D1.add("C++");
		Skills2D1.add("Phyton");
		JSONArray Skills3D1 = new JSONArray();
		Skills3D1.add("Automation Testing");
		Skills3D1.add("Java");
		JSONArray department = new JSONArray();
		department.add(addEmployeeValuesJSON(employee1D1Values,employee1D1,"Smith","Liam","02.12.1990","Department Manager",Skills1D1,"0"));
		department.add(addEmployeeValuesJSON(employee2D1Values,employee2D1,"Johnson","Logan","10.03.1993","Developer",Skills2D1,"001"));
		department.add(addEmployeeValuesJSON(employee3D1Values,employee3D1,"Davis","Lucas","25.06.1994","Tester",Skills3D1,"001"));
		department1.put("department",department);
		JSONObject employee1D2 = new JSONObject();
		JSONObject employee1D2Values = new JSONObject();
		JSONObject employee2D2 = new JSONObject();
		JSONObject employee2D2Values = new JSONObject();
		JSONObject employee3D2 = new JSONObject();
		JSONObject employee3D2Values = new JSONObject();
		JSONArray department2Array = new JSONArray();
		JSONArray Skills1D2 = new JSONArray();
		Skills1D2.add("Communication");
		Skills1D2.add("Accounting");
		JSONArray Skills2D2 = new JSONArray();
		Skills2D2.add("Accounting");
		Skills2D2.add("Business and Management");
		Skills2D2.add("Legal Right");
		JSONArray Skills3D2 = new JSONArray();
		Skills3D2.add("Beautiful");
		Skills3D2.add("Java");
		Skills3D2.add("Manual Testing");
		department2Array.add(addEmployeeValuesJSON(employee1D2Values,employee1D2,"Taylor","Jacob","22.09.1995","Department Manager",Skills1D2,"0"));
		department2Array.add(addEmployeeValuesJSON(employee2D2Values,employee2D2,"Harris","Luke","20.11.1992","Accountant",Skills2D2,"004"));
		department2Array.add(addEmployeeValuesJSON(employee3D2Values,employee3D2,"Bennett","Ellie","19.10.1990","Secretary",Skills3D2,"004"));
		JSONObject department2 = new JSONObject();
		department2.put("department", department2Array);
		JSONArray companyArray = new JSONArray();
		companyArray.add(department1);
		companyArray.add(department2);
		JSONObject company = new JSONObject();
		company.put("company",companyArray);
		
		 try (FileWriter file = new FileWriter("company.json")) {

	            file.write(company.toJSONString());
	            file.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		System.out.println(company);

	}
		public static JSONObject addEmployeeValuesJSON(JSONObject employeeValues, JSONObject employee, String lastName,String firstName, String birthDate, String position, JSONArray skills,  String managerId) {
			employeeValues.put("lastName",lastName);
			employeeValues.put("firstName",firstName);
			employeeValues.put("birthDate",birthDate);
			employeeValues.put("position",position);
			employeeValues.put("skills",skills);
			employeeValues.put("managerId",managerId);
			employee.put("employee",employeeValues);
			return employee;
			
		}

}
