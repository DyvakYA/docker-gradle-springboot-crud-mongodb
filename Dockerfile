FROM java:8-jre
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>

ADD ./target/application.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/application.jar"]

EXPOSE 6000