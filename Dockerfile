FROM adoptopenjdk/maven-openjdk11 as builder
WORKDIR /application
COPY spring-rest/target/spring-rest-1.0.jar ./app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# "RUN true" set to resolve copy issue on github actions
FROM adoptopenjdk:11-jre-hotspot
# label set to image to appear on the repository package section
LABEL org.opencontainers.image.source="https://github.com/wallysoncarvalho/desafio-donus"
WORKDIR /application
COPY --from=builder application/dependencies/ ./
RUN true
COPY --from=builder application/snapshot-dependencies/ ./
RUN true
COPY --from=builder application/spring-boot-loader/ ./
RUN true
COPY --from=builder application/application/ ./
EXPOSE 8090
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]