# 🌐 Gopher Client in Java

## 📖 Overview
This is a simple **Gopher client** written in **Java** that connects to a **Gopher server**, sends a request, and prints the response. The client communicates with the **Gopher protocol** over **TCP (port 70)**, similar to how web browsers use HTTP.

## 🚀 How It Works
1. **Creates a TCP connection** to a Gopher server.
2. **Sends a request** in the Gopher format (`selector + "\r\n"`).
3. **Receives and prints** the response line by line.
4. **Handles errors** and closes the connection properly.

## 📜 Gopher Protocol Basics
- The **Gopher protocol** is a text-based system for retrieving documents.
- It is structured as a **menu-driven interface**, where users select links.
- Requests are simple: **a selector (path) followed by `\r\n`**.
- The **default port** for Gopher servers is **70**.

## 📝 Code Breakdown
### **1️⃣ Constants**
The program defines constants for:
```java
private static final String HOST = "gopher.mozz.us";  // Gopher server
private static final String PATH = "/";  // Root directory
private static final int PORT = 70;  // Gopher default port
```

### **2️⃣ Establishing a Connection**
It opens a **TCP socket** to the Gopher server:
```java
Socket socket = new Socket(HOST, PORT);
```

### **3️⃣ Sending a Request**
The request consists of a **selector string** (the path to the resource), followed by a **carriage return and newline (`\r\n`)**:
```java
String request = PATH + "\r\n";
outputStream.write(request.getBytes());
outputStream.flush();
```

### **4️⃣ Reading the Server Response**
A `BufferedReader` is used to **read and print the response** line by line:
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String line;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
```
---

## 🛠️ How to Compile & Run
### **1️⃣ Compile the Java Code**
```sh
javac GopherClient.java
```
This will generate a compiled `GopherClient.class` file.

### **2️⃣ Run the Program**
```sh
java GopherClient
```

---
