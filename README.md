# 📚 Book Inventory System

An end-to-end, full-stack **Book Inventory Management System** built with **Java Spring Boot**, **Spring Data MongoDB**, and **Thymeleaf**. This application features a modern, responsive web dashboard for tracking books, calculating live inventory valuation, and performing complete CRUD operations.

---

## 🌟 Key Features

- **📊 Interactive Dashboard**: Displays real-time metrics including total book count, cumulative inventory value, and unique author count.
- **➕ Book Cataloging**: Add new book records with detailed attributes (Title, Author, Publisher, Publication Year, Price, Quantity, Language).
- **🔍 Fast Search**: Instant book lookup by unique Book ID with clear, formatted record views.
- **🗑️ Inventory Management**: Safely delete book entries from the system with feedback alerts.
- **🎨 Modern UI**: Clean, responsive Glassmorphic layout powered by **Bootstrap 5**, **Font Awesome 6**, and **Google Fonts (Poppins)**.

---

## 🛠️ Tech Stack & Architecture

| Component | Technology |
| :--- | :--- |
| **Backend Framework** | Spring Boot 3.x |
| **Language** | Java 17+ |
| **Database** | MongoDB |
| **Data Access** | Spring Data MongoDB |
| **Template Engine** | Thymeleaf |
| **Frontend UI** | Bootstrap 5, Font Awesome 6 |
| **Build Tool** | Gradle |

---

## 📁 Project Structure

```text
Book-Inventory-System/
├── src/
│   ├── main/
│   │   ├── java/com/book/inventory/app/
│   │   │   ├── controller/
│   │   │   │   └── BookController.java      # Handles HTTP routing & request logic
│   │   │   ├── domain/
│   │   │   │   └── Book.java                # MongoDB Document Entity Model
│   │   │   ├── repo/
│   │   │   │   └── BookRepo.java            # MongoRepository Interface
│   │   │   └── BookInventorySystemApplication.java  # Main Application Runner
│   │   └── resources/
│   │       ├── templates/                   # Thymeleaf HTML Templates
│   │       │   ├── index.html               # Home / Landing Page
│   │       │   ├── addbook.html             # Add Book Form
│   │       │   ├── searchbook.html          # Book Search Page
│   │       │   ├── deletebook.html          # Delete Book Form
│   │       │   └── bookinfo.html            # Analytics Dashboard & Table
│   │       └── application.yaml             # Database & Server Configurations
│   └── test/
└── build.gradle                               # Gradle Build Script


⚙️ Prerequisites
Before running the application, ensure you have the following installed:

Java Development Kit (JDK 25 or higher)

MongoDB Server running locally on port 27017

Gradle (or use the included ./gradlew wrapper)

An IDE such as IntelliJ IDEA or Eclipse


