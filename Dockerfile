FROM openjdk:8-jdk-alpine
COPY target/*.jar /app/
EXPOSE 8080
CMD ["java","-jar","/app/biblioteca.jar"]
