package com.ABS.ataf.utility;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XMLUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(new File("C:\\Users\\AnindyarajMahalanabi\\Downloads\\Manifest.xml"));
		
		setContentOnElement(doc,"/uploadfiledetails/uploadfiles/uploadfile/className[text()='ACCOUNT']/parent::uploadfile/fileName","myfile0.csv");
		
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		DOMSource domSource = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File("C:\\Users\\AnindyarajMahalanabi\\Downloads\\Manifest.xml"));
		tf.transform(domSource, sr);
		System.out.println("Successfull!");
		}
		catch(Exception ex){
			System.out.println(ex.getLocalizedMessage());
		}
	}
	
	public static void setContentOnElement(Document doc, String xpathinput, String content) throws Exception {
		XPath xPath = XPathFactory.newInstance().newXPath();
		Node testNode = (Node) xPath.compile(xpathinput).evaluate(doc, XPathConstants.NODE);
		testNode.setTextContent(content);
	}

}
