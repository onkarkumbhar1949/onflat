FROM openjdk:13-jdk-alpine
ADD target/OnlineFlatRentalWebApplication-0.0.1-SNAPSHOT.jar OnlineFlatRentalWebApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","OnlineFlatRentalWebApplication-0.0.1-SNAPSHOT.jar"]
