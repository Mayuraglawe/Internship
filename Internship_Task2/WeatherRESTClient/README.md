# WeatherRESTClient - CodTech Internship Deliverable

## 🌐 About
A Java application that consumes the OpenWeatherMap REST API to fetch and display live weather data in a structured format.

## 🧰 Requirements
- Java 11+
- `json-20210307.jar` placed inside `lib/`

Download JSON JAR: [https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar](https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar)

## 🚀 How to Run

### ✅ Step 1: Compile
#### On Linux/Mac:
```bash
javac -cp "lib/json-20210307.jar" src/WeatherClient.java
```
#### On Windows:
```cmd
javac -cp "lib/json-20210307.jar" src\WeatherClient.java
```

### ✅ Step 2: Run
#### On Linux/Mac:
```bash
java -cp "lib/json-20210307.jar:src" WeatherClient
```
#### On Windows:
```cmd
java -cp "lib/json-20210307.jar;src" WeatherClient
```

## ✅ Output Example

```
🌤 Weather Report for London:
Temperature: 280.32 °K
Humidity: 81 %
Wind Speed: 4.1 m/s
```

## 📅 Internship Completion
This project fulfills the REST API deliverable for the CodTech Internship.
Author: Mayur Aglwe