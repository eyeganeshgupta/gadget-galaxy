# GadgetGalaxy WebApplication

GadgetGalaxy is a web-based e-commerce application for electronic gadgets and accessories. This application is built using Java Servlets and JSP, with Oracle as the backend database and Apache Tomcat as the application server.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Prerequisites](#prerequisites)
4. [Setup and Installation](#setup-and-installation)
5. [Database Schema](#database-schema)
6. [Project Structure](#project-structure)
7. [Usage](#usage)
8. [Contributing](#contributing)
9. [License](#license)

## Features

- User registration and authentication
- Product browsing and searching
- Shopping cart functionality
- Order placement and tracking
- User profile management
- Admin panel for product and order management

## Technologies Used

- Java Servlets
- JavaServer Pages (JSP)
- JDBC for database connectivity
- Oracle Database
- Apache Tomcat Server
- HTML, CSS, and JavaScript for frontend
- Maven for dependency management

## Prerequisites

Before you begin, ensure you have met the following requirements:

- JDK 8 or higher
- Apache Tomcat 9.x
- Oracle Database 19c or higher
- Maven 3.6.x or higher

## Setup and Installation

1. Clone the repository:
git clone https://github.com/yourusername/gadget-galaxy.git

2. Set up the Oracle database using the provided SQL scripts in the `database` folder.

3. Configure the database connection in `src/main/resources/db.properties`.

4. Build the project using Maven:
mvn clean install

5. Deploy the generated WAR file to your Tomcat server.

## Database Schema

The application uses the following main tables:

- users
- products
- orders
- transactions
- user_demands
- user_carts

For detailed schema information, refer to the `database/schema.sql` file.

## Project Structure

gadget-galaxy/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── gadgetgalaxy/
│   │   │           ├── dao/
│   │   │           ├── model/
│   │   │           ├── servlet/
│   │   │           └── util/
│   │   ├── resources/
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       └── jsp/
│   └── test/
├── database/
├── pom.xml
└── README.md


## Usage

1. Start your Tomcat server.
2. Access the application at `http://localhost:8080/gadget-galaxy`.
3. Register a new user account or log in with existing credentials.
4. Browse products, add items to your cart, and place orders.

## Contributing

Contributions to the GadgetGalaxy project are welcome. Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature.
3. Commit your changes.
4. Push to the branch.
5. Create a new Pull Request.
