FROM amazoncorretto:11-alpine-jdk
ADD target/discovery.jar discovery.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","discovery.jar"]