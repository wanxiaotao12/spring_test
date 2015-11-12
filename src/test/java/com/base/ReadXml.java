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
 * ģ��spring�е�д�����أ� ����ȡxml�ļ�
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
                        //��7��ȡ�ýڵ������ֵ
                        String email=book.getAttributes().getNamedItem("email").getNodeValue();
                        System.out.println(email);
                        //ע�⣬�ڵ������Ҳ�������ӽڵ㡣���Ľڵ�����Ҳ��Node.ELEMENT_NODE
                        //��8����ѭ�ӽڵ�
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
