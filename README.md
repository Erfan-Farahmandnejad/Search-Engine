# 🔍 SearchEngine

## 🚀 Java-Based Search Engine with Custom Data Structures
SearchEngine is a lightweight, Java-based search engine that efficiently indexes and searches text data using custom map implementations. Built with JavaFX, it provides a simple yet powerful GUI for users to interact with the search system.

---

## 🌟 Features
✅ **Fast text search** using optimized data structures  
✅ **Custom Map Implementation** for efficient indexing  
✅ **JavaFX GUI** for an interactive user experience  
✅ **CSS-styled interface** with theme customization  
✅ **Standalone operation** with no external dependencies  
✅ **Maven-based build system** for easy dependency management  

---

## 📁 Project Structure
```
SearchEngine/
│── pom.xml                            # Maven project configuration
│── mvnw, mvnw.cmd                     # Maven wrapper scripts
│── src/
│   ├── main/
│   │   ├── java/com/example/searchengine/
│   │   │   ├── FileOperations.java      # File handling and text processing
│   │   │   ├── HelloApplication.java    # Main JavaFX application
│   │   │   ├── MainController.java      # JavaFX controller for UI interactions
│   │   │   ├── MapImplementation/       # Custom data structure implementations
│   │   │   │   ├── AbstractMap.java
│   │   │   │   ├── Entry.java
│   │   │   │   ├── IMap.java
│   │   │   │   ├── UnsortedTableMap.java
│   │   ├── resources/com/example/searchengine/
│   │   │   ├── Main.fxml                 # JavaFX UI layout
│   │   │   ├── Alerts.css                # CSS for alerts and pop-ups
│   │   │   ├── anchorPane.css            # General styling
│   │   │   ├── images/                   # UI assets (icons, backgrounds)
│── README.md                            # Project documentation
```

---

## 🔧 Installation & Setup

### **1️⃣ Prerequisites**
Ensure you have:
- Java 11 or later
- Maven installed (or use the provided Maven wrapper `mvnw`)

### **2️⃣ Clone the Repository**
```bash
git clone https://github.com/Erfan-fn/SearchEngine.git
cd SearchEngine
```

### **3️⃣ Build the Project**
Use Maven to build the project:
```bash
mvn clean package
```

### **4️⃣ Run the Application**
```bash
mvn javafx:run
```

---

## 📌 Usage

### **Starting a Search**
1. Launch the application.
2. Select or provide a directory containing text files.
3. Enter a search query.
4. View search results instantly.

### **Customizing the UI**
- Modify `CSS` files in `src/main/resources/com/example/searchengine/` to change UI styles.
- Replace images in `src/main/resources/com/example/searchengine/images/` for custom themes.

---

## 📜 License
This project is open-source and available under the MIT License.

