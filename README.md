# Casino Spring boot Service

## Table Of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
## Overview
This service fetches casino player balances,updates balance and displays the last transactions

Service Basepath
- /casino

## Requirements
For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [MAVEN 3](https://maven.apache.org)

## Getting Started

### Install Dependencies
```shell
mvn clean install
```
### Run Project
```shell
mvn spring-boot:run 
```

### API ENDPOINTS

- GET BALANCE

```http
GET /player/{playerId}/balance
```

- UPDATE BALANCE

```http
POST /player/{playerId}/balance/update
```

- LAST 10 TRANSACTIONS
```http
POST /admin/player/transactions
```

