package com.base;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 模仿spring中的写法加载， 并读取xml文件
 * Created by xiaotao.wxt on 2014/8/7.
 */
public class ReadXml {
    @Test
    public void testReadXml(){
        DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder domBuilder = domfac.newDocumentBuilder();
            InputStream is = new FileInputStream(new File("D:\\readxml.xml"));
            Document doc = domBuilder.parse(is);
            Element root = doc.getDocumentElement();
            NodeList books = root.getChildNodes();
            if(books!=null){
                for (int i = 0; i < books.getLength(); i++) {
                    Node book = books.item(i);
                    if(book.getNodeType()==Node.ELEMENT_NODE) {
                        //（7）取得节点的属性值
                        String email=book.getAttributes().getNamedItem("email").getNodeValue();
                        System.out.println(email);
                        //注意，节点的属性也是它的子节点。它的节点类型也是Node.ELEMENT_NODE
                        //（8）轮循子节点
                        for(Node node=book.getFirstChild();node!=null;node=node.getNextSibling()) {
                            if(node.getNodeType()==Node.ELEMENT_NODE) {
                                if(node.getNodeName().equals("name")) {
                                    String name=node.getNodeValue();
                                    String name1=node.getFirstChild().getNodeValue();
                                    System.out.println(name);
                                    System.out.println(name1);
                                }
                                if(node.getNodeName().equals("price")) {
                                    String price=node.getFirstChild().getNodeValue();
                                    System.out.println(price);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
