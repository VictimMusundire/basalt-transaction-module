FROM eclipse-temurin:17

LABEL maintainer = "mvpvictim@gmail.com"

WORKDIR /app

COPY target/basalt-transaction-module-0.0.1-SNAPSHOT /app/basalt-transaction-module.jar

ENTRYPOINT ["java", "-jar", "basalt-transaction-module.jar"]
