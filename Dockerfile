FROM gradle:4.3.0-jdk8-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>
RUN ll
COPY ./build/libs/application.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/application.jar"]
EXPOSE 5000

