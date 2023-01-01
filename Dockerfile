FROM openjdk:17

ARG JAR_FILE=build/libs/faircorp-0.0.1-SNAPSHOT.jar
ARG H2_USER="sa"
ARG H2_PASSWORD=""
ARG H2_URL="jdbc:h2:mem:faircorp"

ENV PORT="8080"
ENV H2_USER_NAME=${H2_USER}
ENV H2_PASS=${H2_PASSWORD}
ENV H2_PATH=${H2_URL}

EXPOSE $PORT 8000
COPY ${JAR_FILE} dockerApp.jar
ENTRYPOINT ["java","-jar","/dockerApp.jar"]