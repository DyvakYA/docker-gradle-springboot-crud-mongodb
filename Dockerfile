FROM gradle:4.3.0-jdk8-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>
CMD ["ls", "lsa"]
ADD src src
ADD build.gradle .
RUN gradle build
CMD ["ls", "lsa"]
ADD ./build/libs/aplication.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/application.jar"]

EXPOSE 5000

