FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/Student-fee-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8099

ENTRYPOINT ["java", "-jar", "app.jar"] 
