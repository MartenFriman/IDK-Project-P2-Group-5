package publicScreen;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class kronoxParser {
	public ArrayList<LectureInformationBox> parseFromKronox(int hours, int minutes) {

		ArrayList<String> time = new ArrayList<String>();

		ArrayList<LectureInformationBox> superDone = new ArrayList<LectureInformationBox>();
		String room = "";
		String course = "";
		String startTid = "";
		String slutTid = "";
		CourseNames names = new CourseNames();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=d&intervallAntal=1&sokMedAND=false&sprak=SV&resurser=l.NI%3AA0301%2Cl.NI%3AA0304%2Cl.NI%3AA0305%2Cl.NI%3AA0306%2Cl.NI%3AA0307%2Cl.NI%3AA0311%2Cl.NI%3AA0314%2Cl.NI%3AA0318%2Cl.NI%3AA0322%2Cl.NI%3AA0401%2Cl.NI%3AA0404%2Cl.NI%3AA0405%2Cl.NI%3AA0406%2Cl.NI%3AA0407%2Cl.NI%3AA0411%2Cl.NI%3AA0414%2Cl.NI%3AA0418%2Cl.NI%3AA0422%2Cl.NI%3AA0502%2Cl.NI%3AA0506%2Cl.NI%3AA0507%2Cl.NI%3AA0510%2Cl.NI%3AA0513%2Cl.NI%3AA0515%2Cl.NI%3AA0602%2Cl.NI%3AA0606%2Cl.NI%3AA0607%2Cl.NI%3AA0611%2Cl.NI%3AA0614%2Cl.NI%3AB0203%2Cl.NI%3AB0303%2Cl.NI%3AB0305%2Cl.NI%3AB0308%2Cl.NI%3AB0314%2Cl.NI%3AB0321%2Cl.NI%3AB0E07%2Cl.NI%3AB0E15%2Cl.NI%3AC0205%2Cl.NI%3AC0301%2Cl.NI%3AC0305%2Cl.NI%3AC0306%2Cl.NI%3AC0309%2Cl.NI%3AC0312%2Cl.NI%3AC0315%2Cl.NI%3AC0319%2Cl.NI%3AC0325%2Cl.NI%3AC0401%2Cl.NI%3AC0E11%2C");
			NodeList bookings = doc.getElementsByTagName("schemaPost");
			for (int i = 0; i < bookings.getLength(); i++) {
				boolean incorrectTime = false;
				Node p = bookings.item(i);
				room = "";
				course = "";
				startTid = "";
				slutTid = "";
				if (p.getNodeType() == Node.ELEMENT_NODE) {
					Element doc1 = (Element) p;
					NodeList items2 = doc1.getElementsByTagName("bokadeDatum");
					for (int t = 0; t < items2.getLength(); t++) {
						Node n1 = items2.item(t);
						if (n1.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) n1;
							Node node3 = eElement.getFirstChild();
							Node node4 = node3.getAttributes().getNamedItem("startTid");
							Node node5 = node3.getAttributes().getNamedItem("slutTid");

							startTid = node4.getNodeValue();
							slutTid = node5.getNodeValue();
							
							int upperTimeBoundraryH = hours + 1;
							//int upperTimeBoundraryM = minutes;
							int lowerTimeBoundraryH = hours;
							//int lowerTimeBoundraryM = minutes;
							/*
							if (minutes - 45 < 0) {
								lowerTimeBoundraryH-=1;
								lowerTimeBoundraryM = 60 + (minutes-45);
							} else {
								lowerTimeBoundraryM = minutes-45;
							}
							*/
							//System.out.println(lowerTimeBoundraryM);	
							String[] parts = startTid.split(Pattern.quote(":"));
							int startTimme = Integer.parseInt(parts[0]);
							int startMinut = Integer.parseInt(parts[1]);
							if (startTimme < hours-1 || startTimme == hours-1 && startMinut < minutes ||
									startTimme > hours+1 || startTimme == hours+1 && startMinut > minutes) {
								incorrectTime = true;
								break;
							} else {
							  time.add(startTid + " - " + slutTid);	
							}
							
						}
					}
				}
				if (incorrectTime == false) {
				if (p.getNodeType() == Node.ELEMENT_NODE) {
					Element booking = (Element) p;
					NodeList resource = booking.getElementsByTagName("resursNod");
					for (int j = 0; j < resource.getLength(); j++) {
						Node n = resource.item(j);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element classType = (Element) n;
							String id = classType.getAttribute("resursTypId");
							NodeList classResource = classType.getElementsByTagName("resursId");
							for (int k = 0; k < classResource.getLength(); k++) {
								Node specifiedClass = classResource.item(k);
								if (specifiedClass.getNodeType() == Node.ELEMENT_NODE) {
									Element name = (Element) specifiedClass;
									if (id.contains("UTB_KURSINSTANS_GRUPPER")) {
										course = name.getTextContent();

									}
									if (id.contains("RESURSER_LOKALER")) {
										room = name.getTextContent();
									}
									

								}
								
							}
						}
						
					}
				}
				
				if(course.length() > 0){
				superDone.add(new LectureInformationBox(room, course, startTid));
			
				}	
				}
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		superDone = names.courseNames(superDone);
		return superDone;

	}

}


