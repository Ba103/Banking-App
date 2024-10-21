FROM openjdk:11
COPY target/banking-app.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/banking-app.jar"]
