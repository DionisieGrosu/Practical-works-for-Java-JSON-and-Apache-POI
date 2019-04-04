package com.JSONPracticalWorks.JSONPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParse {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
		// TODO Auto-generated method stub

		JSONParser parser = new JSONParser();

        

            Object obj = parser.parse(new FileReader("company.json"));

            JSONObject jsonObject =  (JSONObject) obj;
            int counter = 1;
            JSONArray company = (JSONArray)jsonObject.get("company");
            for(int i = 0; i < company.size();i++) {
            	JSONObject deparmtnets = (JSONObject)company.get(i);
            	JSONArray  deparmtnetsArray = (JSONArray)deparmtnets.get("department");
            	for(int j = 0; j < deparmtnetsArray.size(); j++) {
            		JSONObject employees = (JSONObject)deparmtnetsArray.get(j);

            		JSONObject emp = (JSONObject)employees.get("employee");

            		System.out.println("Employee: " + counter++);
            		System.out.printf("LastName: %s%n",emp.get("lastName"));
            		System.out.printf("FirstName: %s%n",emp.get("firstName"));
            		System.out.printf("BirthDate: %s%n",emp.get("birthDate"));
            		System.out.printf("Position: %s%n",emp.get("position"));   		
            		JSONArray skills = (JSONArray)emp.get("skills");

            		for(int f = 0; f < skills.size(); f++) {
           			
            			System.out.printf("Skill: %s%n",skills.get(f));
            		}
            		System.out.printf("managerId: %s%n",emp.get("managerId"));
            		System.out.println();
       
            	}

            }
	   }
	}

