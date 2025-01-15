# Usar una imagen base con Java 17
FROM openjdk:17-jdk-slim

# Establecer un directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado en el contenedor
COPY target/BdOSinabro-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación, las variables de entorno deben estar configuradas en Render
ENTRYPOINT ["java", "-jar", "app.jar"]
