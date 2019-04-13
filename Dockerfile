FROM gradle:4.3.0-jdk8-alpine
MAINTAINER Dyvak Yurii <dyvakyurii@gmail.com>

ADD src src
ADD build.gradle build.gradle 
RUN gradle build
# RUN ls -a
# RUN cd build/ && ls -a
# RUN cd build/libs/ && ls -a
# ADD ./build/libs/Application.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/build/libs/Application.jar"]

CMD java -Xmx200m -jar /build/libs/application.jar

ENTRYPOINT ["java", "-jar", "/build/libs/Application.jar"]

EXPOSE 5000


