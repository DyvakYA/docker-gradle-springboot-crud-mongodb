FROM openjdk:8-jdk-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>
ADD ./build/libs/application.jar /app/
EXPOSE 5000
CMD ["java", "-Xmx200m", "-jar", "/app/application.jar"]



