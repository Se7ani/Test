import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class DOMParser {
    public static void main(String[] args) throws Exception {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("test.xml"));
            doc.getDocumentElement().normalize();

            Node root = doc.getDocumentElement();

            System.out.println(doc.getDocumentElement().getNodeName());
            System.out.println("==============");

            NodeList node = root.getChildNodes();
            for (int i = 0; i < node.getLength(); i++) {
                Node book = node.item(i);

                if (book.getNodeType() != Node.TEXT_NODE) {
                    System.out.println(book.getNodeName());
                    System.out.println();

                    NodeList bookProps = book.getChildNodes();

                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);

                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(bookProp.getNodeName() + ": " + bookProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("==============");
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}