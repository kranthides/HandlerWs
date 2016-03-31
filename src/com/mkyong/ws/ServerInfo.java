package com.mkyong.ws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@WebService
@HandlerChain(file="handler-chain.xml")
public class ServerInfo {

	@WebMethod
	public String getServerName() {
		
		return "mkyong server";
		
	}



}