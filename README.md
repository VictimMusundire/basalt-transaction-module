
## Overview

## Keycloak Setup
We run keycloak using Docker containers pointing to a Postgres DB
Create a database called *basalt_auth_db*
Start the container
Please check for the latest container build here: https://quay.io/repository/keycloak/keycloak
Do not use the latest tag
### Dev:
```shell
docker run --name basalt-keycloak-server --network host -d \
        -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=password \
        quay.io/keycloak/keycloak:21.0.1 \
        start-dev \
        --db=postgres \
        --features=token-exchange \
        --db-url=jdbc:postgresql://localhost/basalt_auth_db \
        --db-username=postgres \
        --db-password=postgres \
        --hostname-strict=false
```
### Dev