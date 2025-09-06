FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/studentInformationSystem-0.0.1-SNAPSHOT.jar /app/studentInformationSystem.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "studentInformationSystem.jar"]
