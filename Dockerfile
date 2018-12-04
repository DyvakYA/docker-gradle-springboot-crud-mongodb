FROM gradle:4.3.0-jdk8-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>

ADD src src
ADD build.gradle build.gradle 
RUN gradle build

RUN ls -a

#RUN mkdir /app
#WORKDIR /app

#ADD ./build/libs/application.jar /app                       
RUN cd /app && ls -a

CMD java -Xmx200m -jar /build/libs/application.jar
EXPOSE 5000

