FROM eclipse-temurin:17-jdk-focal
LABEL authors="Virendra Singh Rajpurohit (virendrasinghrp.gihtub.io)"

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
