FROM openjdk:8
COPY /target/user-movies-rating.jar /usr/local/bin/user-movies-rating.jar
WORKDIR /usr/local/bin
Expose 8081
ENTRYPOINT ["java","-jar","user-movies-rating.jar"]