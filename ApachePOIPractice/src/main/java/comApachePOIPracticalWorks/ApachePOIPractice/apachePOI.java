package comApachePOIPracticalWorks.ApachePOIPractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class apachePOI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			File inputFile = new File("C:\\Users\\GROSU-TI\\eclipse-workspace\\XMLPracticalWorks\\company.xml");
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        NodeList nList = doc.getElementsByTagName("department");
	        Workbook wb = new HSSFWorkbook();

		    CreationHelper createHelper = wb.getCreationHelper();
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = (Node) nList.item(temp);
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	 Element eElement = (Element) nNode;
	            	 System.out.println("Department name: " + eElement.getAttribute("name"));
	            	 System.out.println("DepartmentId: " + eElement.getAttribute("depId"));
	            	 Sheet sheet = wb.createSheet(eElement.getAttribute("name") + "," + eElement.getAttribute("depId"));
	            	 
	            	 System.out.println("EmployeeId: " + eElement.getChildNodes());

	            	 Row row = sheet.createRow(0);
	            	 Cell cellEmpId = row.createCell(0);
	            	 cellEmpId.setCellValue("Emp ID");
	            	 Cell cellLastname = row.createCell(1);
	            	 cellLastname.setCellValue("Lastname");
	            	 Cell cellFirstname = row.createCell(2);
	            	 cellFirstname.setCellValue("Firstname");
	            	 Cell cellBirthdate = row.createCell(3);

		            	 cellBirthdate.setCellValue("Birthdate");  
		            	 Cell cellPosition = row.createCell(4);
		            	 cellPosition.setCellValue("Position");
		            	 Cell cellManagerID = row.createCell(5);
		            	 cellManagerID.setCellValue("Manager ID");
		            	 Cell cellSkills  = row.createCell(6);
		            	 cellSkills.setCellValue("Skills");
		            	 
	            		
		            	 

	            	 NodeList nEmployees = eElement.getChildNodes();
	            	 int rowCount = 1;
	            	 for(int temp2 = 0; temp2 < nEmployees.getLength(); temp2++) {
	            		 Node employee = nEmployees.item(temp2);
	            		 if (employee.getNodeType() == Node.ELEMENT_NODE) {
	            			 Element eEmployee = (Element)employee;
	            			 Row row2 = sheet.createRow(rowCount++);
	            		 System.out.println("EmployeeId: " + eEmployee.getAttribute("empId"));
	            		 Cell cellEmpIdValue = row2.createCell(0);
	            		 cellEmpIdValue.setCellValue(eEmployee.getAttribute("empId"));
	            		 System.out.println("LastName: " + eEmployee.getElementsByTagName("lastName").item(0).getTextContent());
	            		 Cell cellLastnameValue = row2.createCell(1);
		            	 cellLastnameValue.setCellValue(eEmployee.getElementsByTagName("lastName").item(0).getTextContent());
	            		 System.out.println("FirstName: " + eEmployee.getElementsByTagName("firstName").item(0).getTextContent());
	            		 Cell cellFirstnameValue = row2.createCell(2);
		            	 cellFirstnameValue.setCellValue(eEmployee.getElementsByTagName("firstName").item(0).getTextContent());
		            	 sheet.autoSizeColumn(2);
	            		 System.out.println("BirthDate: " + eEmployee.getElementsByTagName("birthDate").item(0).getTextContent());
	            		 Cell cellBirthdateValue = row2.createCell(3);
	            		 CellStyle cellStyle = wb.createCellStyle();
		            	    cellStyle.setDataFormat(
		            	        createHelper.createDataFormat().getFormat("m/d/yyyy"));
		            	    cellBirthdateValue.setCellValue(eEmployee.getElementsByTagName("birthDate").item(0).getTextContent());
		            	    cellBirthdateValue.setCellStyle(cellStyle);
		            	    sheet.autoSizeColumn(3);
	            		 System.out.println("Position: " + eEmployee.getElementsByTagName("position").item(0).getTextContent());
	            		 Cell cellPositionValue = row2.createCell(4);
	            		 cellPositionValue.setCellValue(eEmployee.getElementsByTagName("position").item(0).getTextContent());
	            		 sheet.autoSizeColumn(4);
	            		 System.out.println("ManagerId: " + eEmployee.getElementsByTagName("managerId").item(0).getTextContent());
	            		 Cell cellManagerIDValue = row2.createCell(5);
	            		 cellManagerIDValue.setCellValue(eEmployee.getElementsByTagName("managerId").item(0).getTextContent());
	            		 sheet.autoSizeColumn(5);
	            		 int skillCount = 10;
	            		 String skills = "";
	            		 Cell cellSkillsValue;
	            		 for(int temp3 = 0; temp3 < eEmployee.getElementsByTagName("skill").getLength(); temp3++) {
	            			 System.out.println("Skills: " + eEmployee.getElementsByTagName("skill").item(temp3).getTextContent());
	            			 
	            			 cellSkillsValue  = row2.createCell(skillCount);
	            			 cellSkillsValue.setCellValue(eEmployee.getElementsByTagName("skill").item(temp3).getTextContent()+"\n");
	            			 sheet.autoSizeColumn(skillCount);
	            			 skills = skills + row2.getCell(skillCount).getStringCellValue() + "\n";
	            			 row2.removeCell(row2.getCell(skillCount));
	            			 
	            			 skillCount++;
	            			 
	            			
	            			 
	            		 }

	            		 cellSkillsValue = row2.createCell(6);
	            		 cellSkillsValue.setCellValue(skills);
	            		 CellStyle cs = wb.createCellStyle();  
	                     cs.setWrapText(true);  
	                     cellSkillsValue.setCellStyle(cs);  
	                     sheet.autoSizeColumn(6);
	            		 System.out.println();
	            		
	            		 
	            		 }
	            System.out.println("----------------------------");
	            	 }
	            }
	            try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
     		        wb.write(fileOut);
     		    } catch (IOException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
	        }
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	            
	}
}
		        

	        
	 



