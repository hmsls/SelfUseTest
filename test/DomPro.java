import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * DOM 解析XML文档
 */
public class DomPro implements XmlDocument {
    @Test
    public void test(){
        parserXml("F:\\java_file\\Scala\\src\\main\\xml\\invoice.xml");
    }
    private Document document;

    @Override
    public void parserXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);

            //得到container的属性值
//            NodeList conta = document.getElementsByTagName("Resource");
//
//            for(int i = 0;i<conta.getLength();i++){
//               Node n =  conta.item(i);
//               NamedNodeMap nnp = n.getAttributes();
//               for(int j = 0;j<nnp.getLength();j++){
//                   Node nodeatt = nnp.item(j);
//                   System.out.print(nodeatt.getNodeName()+"---");
//                   System.out.println(nodeatt.getNodeValue());
////                   System.out.println(nodeatt.getTextContent());
//               }
//            }
//            System.out.println(conta.getLength());

            //得到节点的值
//            NodeList root = document.getElementsByTagName("ResourceDefination");
            Element de = document.getDocumentElement();
            NodeList root = de.getChildNodes();
            System.out.println("-------------------得到根节点"+de.getTagName());
            for(int l=0;l<root.getLength();l++){
                //得到body和head
                Node n = root.item(l);
                if(n instanceof Element){
                    String nodeName = n.getNodeName();
                    System.out.println("-----------------------根节点下第"+l+"个节点是："+nodeName);
                }

                NodeList rootChilds = n.getChildNodes();
                for(int m=0;m<rootChilds.getLength();m++){
                    //得到body和head节点下的节点
                    Node c = rootChilds.item(m);
                    //if(userMeta.item(k).getNodeName() != "#text")
                    if(c instanceof Element){
                        String cn = c.getNodeName();
                        System.out.println(cn+"节点名称是："+c.getNodeName());
                        System.out.println(cn+"节点内容是："+c.getTextContent());
                    }
                    if((c instanceof Element) && (c.getTextContent() == "")){
                        NamedNodeMap nnp = c.getAttributes();
                        String nodeName = c.getNodeName();
                        for(int q = 0;q<nnp.getLength();q++){
                            Node nnpattr = nnp.item(q);
                            String attrName = nnpattr.getNodeName();
                            System.out.print(nodeName+"节点下属性"+attrName+"的名称是"+nnpattr.getNodeName()+"---");
                            System.out.println(nodeName+"节点下属性"+attrName+"的内容是"+nnpattr.getNodeValue());
                            System.out.println("for层----------------------------");
                        }
                    }

                    NodeList rootChildChilds = c.getChildNodes();
                    for(int p = 0;p<rootChildChilds.getLength();p++){
                        //得到body和head节点下节点的下面的节点
                        Node rcc = rootChildChilds.item(p);
                        String rccName = rcc.getNodeName();
                        if(rcc instanceof Element){
                            System.out.println(rccName+"节点名称是："+rcc.getNodeName());
                            System.out.println(rccName+"节点内容是："+rcc.getTextContent());
                        }
                        if((rcc instanceof Element) && (rcc.getTextContent() == "")){
                            NamedNodeMap nnp = rcc.getAttributes();
                            String nodeName = rcc.getNodeName();
                            for(int q = 0;q<nnp.getLength();q++){
                                Node nnpattr = nnp.item(q);
                                String attrName = nnpattr.getNodeName();
                                System.out.print(nodeName+"节点下属性"+attrName+"的名称是"+nnpattr.getNodeName()+"---");
                                System.out.println(nodeName+"节点下属性"+attrName+"的内容是"+nnpattr.getNodeValue());
                            }
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}