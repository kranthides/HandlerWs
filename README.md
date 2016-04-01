# HandlerWs

Servicio web sencillo que se puede publicar el mismo con `WsPublisher`
Cuenta con la implementacion de `SOAPHandler` el cual permite interceptar y acceder a los mensajes SOAP
tanto en el request como en el response.

Sirve para probar servicios web sencillos.

[Tomado del tutorial](http://www.mkyong.com/webservices/jax-ws/jax-ws-soap-handler-in-server-side/)

## Compilar

Se compila con `build.xml`
para que corra en la carpeta `bin` deben existir los `.class`

## Generar clases

cuando se valla a crear un servicio nuevo se tiene que generar:
```sh
wsgen -keep -verbose -cp . YYY.TTT
```
YYY -> paquetes
TTT -> clase que representa el servicio

Se debe correr en la carpeta bin, donde estan los .class

## Ejemplo:
```sh
wsgen -keep -verbose -cp . com.mkyong.ws.ServerInfo
```
