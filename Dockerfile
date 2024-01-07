FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/flick-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENV LOCAL_DB_URL="jdbc:mariadb://192.168.45.185:3306/flick?serverTimezone=Asia/Seoul&characterEncoding=UTF-8"
ENV LOCAL_DB_USERNAME="jbj"
ENV LOCAL_DB_PASSWORD="qwsedc1!234"

ENTRYPOINT ["java","-jar","/app.jar"]