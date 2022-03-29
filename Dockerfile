FROM ubuntu:18.04
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#RUN apt-get upgrade
#RUN apt-get update
#RUN apt-get install git -y
RUN apt-get install maven -y
RUN apt-get install openjdk-8-jdk -y
#RUN git clone https://github.com/RooBarsic/SimpleWebApp/tree/develop
WORKDIR SimpleWebApp
RUN mvn clean package
ENTRYPOINT ["java","-jar","target/GitSimpleWebApp-1.0-SNAPSHOT"]

