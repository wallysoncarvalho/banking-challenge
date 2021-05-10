FROM adoptopenjdk/maven-openjdk11 as builder
WORKDIR /application
# COPY core ./core
# COPY persistence ./persistence
# COPY spring-rest ./spring-rest
# COPY coverage-report ./coverage-report
# COPY pom.xml ./
# RUN mvn clean package -DskipTests=true
COPY spring-rest/target/spring-rest-1.0.jar ./app.jar
# RUN java -Djarmode=layertools -jar spring-rest/target/spring-rest-1.0.jar extract
RUN java -Djarmode=layertools -jar app.jar extract
RUN ls

FROM adoptopenjdk:11-jre-hotspot
LABEL org.opencontainers.image.source="https://github.com/wallysoncarvalho/desafio-donus"
WORKDIR /application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./
EXPOSE 8090
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]