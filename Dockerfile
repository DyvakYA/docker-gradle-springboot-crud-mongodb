FROM gradle:4.3.0-jdk8-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>

RUN ls -a

RUN mkdir /app
WORKDIR /app

ADD ./build/libs/application.jar /app                       
RUN cd /app && ls -a

CMD java -Xmx200m -jar /app/application.jar
EXPOSE 5000

