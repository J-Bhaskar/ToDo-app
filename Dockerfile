FROM openjdk:17
COPY ./target/TODO_RestAPI_JWT_Authentication_Docker-0.0.1-SNAPSHOT.jar TODO_RestAPI_JWT_Authentication_Docker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TODO_RestAPI_JWT_Authentication_Docker-0.0.1-SNAPSHOT.jar"]