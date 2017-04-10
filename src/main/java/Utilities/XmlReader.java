package Utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlReader {

    public static void main (String args[]) {
        readConnect();
    }

    private static void readConnect() {
        System.out.println("Reading Xml...");
        try {

            File file = new File("src\\main\\resources\\connect.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Location");

            System.out.println("\n----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Define : " + eElement.getAttribute("Define"));
                    System.out.println("Environment : " + eElement.getAttribute("Environment"));

                    System.out.println("---Info---");
                    System.out.println("Class : " + eElement.getElementsByTagName("info").item(0).getAttributes().getNamedItem("Class").getNodeValue());
                    System.out.println("Factory : " + eElement.getElementsByTagName("info").item(0).getAttributes().getNamedItem("Factory").getNodeValue());
                    // System.out.println( eElement.getAttribute("test"));
                    // System.out.println( eElement.getElementsByTagName("transport").item(0).getTextContent());

                    System.out.println("---Services---");

                    NodeList serviceNodes = eElement.getElementsByTagName("services");
                    for (int i = 0; i < serviceNodes.getLength(); i++) {
                        Node sNode = serviceNodes.item(i);
                        if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element sElement = (Element) sNode;
                            System.out.println("key : " + sElement.getElementsByTagName("add").item(0).getAttributes().getNamedItem("key").getNodeValue());
                            System.out.println("name : " + sElement.getElementsByTagName("add").item(0).getAttributes().getNamedItem("name").getNodeValue());
                        }
                    }
                }
                System.out.println("\n-----------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ending...");
    }
}
