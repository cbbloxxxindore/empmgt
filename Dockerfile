FROM openjdk:17
COPY target/*.jar app1.jar
ENTRYPOINT ["java","-jar","app1.jar"]
EXPOSE 9191