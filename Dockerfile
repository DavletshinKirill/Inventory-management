FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY target/InventoryManagement-1.0-SNAPSHOT.jar application.jar
CMD ["java", "-jar", "/application.jar"]