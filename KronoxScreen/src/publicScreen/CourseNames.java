package publicScreen;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

//import org.w3c.dom.NodeList;

public class CourseNames {

	//public ArrayList<String> courseList()
	public ArrayList<LectureInformationBox> courseNames(ArrayList<LectureInformationBox> courses)
    {
		ArrayList<String> courseListy = new ArrayList<String>();
		ArrayList<String> nameListy = new ArrayList<String>();
		String kod = "";
		String namn = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=d&intervallAntal=1&forklaringar=true&sokMedAND=false&sprak=SV&resurser=l.NI%3AA0301%2Cl.NI%3AA0304%2Cl.NI%3AA0305%2Cl.NI%3AA0306%2Cl.NI%3AA0307%2Cl.NI%3AA0311%2Cl.NI%3AA0314%2Cl.NI%3AA0318%2Cl.NI%3AA0322%2Cl.NI%3AA0401%2Cl.NI%3AA0404%2Cl.NI%3AA0405%2Cl.NI%3AA0406%2Cl.NI%3AA0407%2Cl.NI%3AA0411%2Cl.NI%3AA0414%2Cl.NI%3AA0418%2Cl.NI%3AA0422%2Cl.NI%3AA0502%2Cl.NI%3AA0506%2Cl.NI%3AA0507%2Cl.NI%3AA0510%2Cl.NI%3AA0513%2Cl.NI%3AA0515%2Cl.NI%3AA0602%2Cl.NI%3AA0606%2Cl.NI%3AA0607%2Cl.NI%3AA0611%2Cl.NI%3AA0614%2Cl.NI%3AB0203%2Cl.NI%3AB0303%2Cl.NI%3AB0305%2Cl.NI%3AB0308%2Cl.NI%3AB0314%2Cl.NI%3AB0321%2Cl.NI%3AB0E07%2Cl.NI%3AB0E15%2Cl.NI%3AC0205%2Cl.NI%3AC0301%2Cl.NI%3AC0305%2Cl.NI%3AC0306%2Cl.NI%3AC0309%2Cl.NI%3AC0312%2Cl.NI%3AC0315%2Cl.NI%3AC0319%2Cl.NI%3AC0325%2Cl.NI%3AC0401%2Cl.NI%3AC0E11%2C");
			NodeList bookings = doc.getElementsByTagName("forklaringsrader");
			for(int i = 0; i < bookings.getLength(); i++){
				Node p = bookings.item(i);
				Element e = (Element) p;
				String hej = e.getAttribute("rubrik");
				if(hej.contains("Kurser")){
				if(p.getNodeType() == Node.ELEMENT_NODE){
					Element doc1 = (Element) p;
				NodeList items2 = doc1.getElementsByTagName("rad");	            
	            for (int t = 0; t < items2.getLength(); t++)
	            {
	                Node n1 = items2.item(t);
	                
				if(n1.getNodeType() == Node.ELEMENT_NODE){
					Element booking = (Element) n1;
					NodeList resource = booking.getElementsByTagName("kolumn");
					for(int j = 0; j < resource.getLength(); j++){
						Node n = resource.item(j);
						if(n.getNodeType() == Node.ELEMENT_NODE){
							Element classType = (Element) n;
							String id = classType.getAttribute("rubrik");
							if(id.contains("Id")){
								kod = classType.getTextContent().replace("&#228;", "ä").replace("&#246;", "ö").replace("&#229;", "å");
								
							}
							if(id.contains("KursNamn_SV")){
								namn = classType.getTextContent().replace("&#228;", "ä").replace("&#246;", "ö").replace("&#229;", "å");
								
							}
							
						}
						
					}
				
					}
				
				courseListy.add(kod);
				nameListy.add(namn);
				
			}
		
				}
				}
				
			}
			
		}
		catch (Exception e)
        {
            e.printStackTrace();
        }
		for(int i = 0; i < courses.size(); i++){
			for(int j = 0 ; j<courseListy.size(); j++){
			if(courses.get(i).getCourse().equals(courseListy.get(j))){
				courses.get(i).setCourse(nameListy.get(j));
			}
			}
		}
		
		return courses;
    }
	
    }
