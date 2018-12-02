FROM java:8-jre
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>

ADD ./build/aplication.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/application.jar"]

EXPOSE 5000