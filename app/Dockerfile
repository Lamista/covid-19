FROM openjdk:11
ARG JAR_FILE=target/app.jar

WORKDIR /app
COPY ${JAR_FILE} /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]