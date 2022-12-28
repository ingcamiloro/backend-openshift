FROM openjdk:8-jdk-alpine
COPY targets/*.jar /app/
EXPOSE 8080
CMD ["java","-jar","/app/biblioteca.jar"]
