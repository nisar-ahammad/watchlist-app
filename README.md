# 🎬 Movie Watchlist Application

A simple Spring Boot web application for movie lovers who have less time and want to quickly decide **which movie is worth watching** based on ratings.

This app allows you to maintain a personal watchlist and view the rating of each movie so you can make informed choices without wasting time.

---

## 🚀 Features

- ✅ Add movies to your watchlist
- ⭐ See the rating of each movie
- ❌ Remove movies from your list
- 📃 View all movies added
- 🎯 Fast and easy UI using Thymeleaf
- 💾 Uses in-memory H2 database (no setup required)

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web + Thymeleaf
- Spring Data JPA + Hibernate
- H2 Database (in-memory)
- Maven

---

## 📂 Project Structure
<pre>WatchListApplication/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/WatchListApp/
│   │   │       ├── Controller/
│   │   │       ├── Model/
│   │   │       ├── Repository/
│   │   │       └── ServiceLayer/
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
├── pom.xml
└── README.md</pre>

---

## ⚙️ H2 Database Configuration

No external database setup is needed. H2 is an in-memory database, which makes this app very easy to run for testing or demo.

### `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:Moviedb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
🔗 **App URL** (Local):
http://localhost:8080/

🔐 **H2 Console**:
http://localhost:8080/h2-console
Use JDBC URL: jdbc:h2:mem:watchlistdb


