#用于构建独立druid_demo镜像：druid_demo
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=druid_demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} druid_demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /druid_demo-0.0.1-SNAPSHOT.jar ${0} ${@}"]