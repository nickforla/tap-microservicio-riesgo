# Microservicio de Riesgo - Técnicas Avanzadas de Programación
Este repositorio contiene el código del microservicio de riesgo del sistema de validación crediticia realizado como trabajo práctico para materia Técnicas Avanzadas de Programación. Se encarga de recibir las solicitudes de estados del microservicio de consulta en base a las peticiones del usuario y utilizar la información recibida para determinar el estado crediticio de cada persona y responder la petición. 

## Instalación
### Requerimientos
- JDK 8
- Variables de entorno  
  - ```JAVA_HOME```

```bash
git clone https://github.com/nickforla/tap-microservicio-riesgo.git
cd tap-microservicio-riesgo/
./mvnw install
java -jar target/microservicio-riesgo-1.0.0.jar
```
Una vez que el jar fue ejecutado, el servicio corre en el puerto 8085.

## Endpoints
- Analizar Estado Persona
  - GET
  - /analizarEstado/persona/{cuil}
  - Permite obtener el estado crediticio de una persona en base al CUIL enviado.
- Analizar Estado Personas
  - POST
  - /analizarEstado/personas
  - Permite obtener el estado crediticio de varias personas en base a un array de CUILs enviados en el cuerpo de la petición en formato JSON
