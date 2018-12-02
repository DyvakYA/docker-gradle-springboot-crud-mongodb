FROM gradle:4.3.0-jdk8-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>

ADD src src
ADD build.gradle .
RUN gradle build

FROM openjdk:8-jdk-alpine

ADD ./build/libs/application.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/application.jar"]

EXPOSE 5000

