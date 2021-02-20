FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=eureka-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} eureka-server-0.0.1-SNAPSHOT.jar

EXPOSE 8761
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /eureka-server-0.0.1-SNAPSHOT.jar ${0} ${@}"]