# HandlerWs

Servicio web sencillo que se puede publicar el mismo con WsPublisher
Cuenta con la implementacion de SOAPHandler el cual permite interceptar y acceder a los mensajes SOAP
tanto en el request como en el response.

Sirve para probar servicios web sencillos.

tomado del tutorial:
http://www.mkyong.com/webservices/jax-ws/jax-ws-soap-handler-in-server-side/

cuando se valla a crear un servicio nuevo se tiene que generar:
wsgen -keep -verbose -cp . YYY.TTT

YYY -> paquetes
TTT -> clase que representa el servicio

Ejemplo:
wsgen -keep -verbose -cp . com.mkyong.ws.ServerInfo
