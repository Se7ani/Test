import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathExpression;


public class XPathSearch {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("test.xml"));
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            XPath xPath = XPathFactory.newInstance().newXPath();

            XPathExpression expr = xPath.compile(input);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);


                System.out.println("===================");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node n = nodeList.item(i);

                    System.out.println(n.getNodeName() + ": " + n.getTextContent());
                    System.out.println("===================");

                }

            } catch(ParserConfigurationException ex){
                    ex.printStackTrace(System.out);
            } catch(SAXException ex){
                    ex.printStackTrace(System.out);
            } catch(IOException ex){
                    ex.printStackTrace(System.out);
            } catch (XPathExpressionException ex){
                    ex.printStackTrace(System.out);
        }
    }
}