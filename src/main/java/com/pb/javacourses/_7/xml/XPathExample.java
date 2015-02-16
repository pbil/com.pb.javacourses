package com.pb.javacourses._7.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

public class XPathExample {

	public static void main (String ... args) {
		System.out.println("run");
		try {
		    System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
		    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		    SAXParser parser = parserFactory.newSAXParser();
		    java.io.FileInputStream fin = new java.io.FileInputStream("pom.xml");

		    class MyHandler extends org.xml.sax.helpers.DefaultHandler {

		        String name = "";
		        String value = "";

		        @Override
		        public void startDocument() throws SAXException {
		        	System.out.println("start");
		        }

		        @Override
		        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		        	System.out.println("start element:" + "\n" + namespaceURI + "\n" + localName + "\n" + qName + "\n" + atts );
//		            if (qName.equalsIgnoreCase("groupId")) {
//		                name = atts.getValue("name");
//		            }
		        }

		        @Override
		        public void characters(char ch[], int start, int length) throws SAXException {
//		        	value = String.valueOf(ch, start, length);
		        	System.out.println("chars: start:"+start+ ", length:" +length + " - " + new String(ch) );
		        }
		        
		        @Override
		        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
//		        	if (qName.equalsIgnoreCase("el")) {
//		        		System.out.println(name + "=" + value);
//		        		name = "";
//		        		value = "";
//		        	}
		        	System.out.println("end element:" + "\n" + namespaceURI + "\n" + localName + "\n" + qName  );
		        }

		        @Override
		        public void endDocument() throws SAXException {
		        	System.out.println("end doc");
		        }
		    }

		    parser.parse(fin, new MyHandler());
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
}
