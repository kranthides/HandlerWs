package com.mkyong.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class SimonWSHandler implements SOAPHandler<SOAPMessageContext>{

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean result = true;
		
		SOAPMessage msg = context.getMessage();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			msg.writeTo(out);
		} catch (SOAPException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		String strMsg = new String(out.toByteArray());
		System.out.println("**MSG** " + strMsg);
		
		//generateSOAPErrMessage(msg, "Error leo.");
		
		return result;
	}
	

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Server : handleFault()......");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context) {
		System.out.println("Server : close()......");
	}

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	@Override
	public Set<QName> getHeaders() {
		System.out.println("Server : getHeaders()......");
		return null;
	}
	
	/**
	 * 
	 * @param msg
	 * @param reason
	 */
	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
       try {
          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
          SOAPFault soapFault = soapBody.addFault();
          soapFault.setFaultString(reason);
          throw new SOAPFaultException(soapFault); 
       }
       catch(SOAPException e) { }
    }
	

}
