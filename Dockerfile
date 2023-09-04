FROM openjdk:11
COPY target/bot_assistant-0.0.7-dev-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]