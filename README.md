# TransitOps — Smart Transport Operations Platform

![TransitOps Banner](https://img.shields.io/badge/TransitOps-Enterprise%20Fleet%20Platform-0066CC?style=for-the-badge&logo=bus)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.16-6DB33F?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React-19.2.7-61DAFB?style=for-the-badge&logo=react)
![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk)
![Vite](https://img.shields.io/badge/Vite-6.2.0-646CFF?style=for-the-badge&logo=vite)
![License](https://img.shields.io/badge/License-MIT-blue.style=for-the-badge)

TransitOps is a full-stack, enterprise-grade **Smart Transport Operations Platform** engineered to streamline fleet management, driver operations, trip lifecycle execution, maintenance tracking, fuel & expense logs, and business analytics.

---

## Table of Contents
1. [Project Overview](#project-overview)
2. [Problem Statement](#problem-statement)
3. [Key Features](#key-features)
4. [System Architecture](#system-architecture)
5. [Frontend Technology Stack](#frontend-technology-stack)
6. [Backend Technology Stack](#backend-technology-stack)
7. [Database & Storage Technology](#database--storage-technology)
8. [Project Folder Structure](#project-folder-structure)
9. [User Roles and Permissions Matrix](#user-roles-and-permissions-matrix)
10. [Core Modules](#core-modules)
11. [Important Business Rules & Formulas](#important-business-rules--formulas)
12. [Trip Lifecycle Workflow](#trip-lifecycle-workflow)
13. [Vehicle and Driver Status Workflows](#vehicle-and-driver-status-workflows)
14. [Maintenance Workflow](#maintenance-workflow)
15. [Fuel and Expense Management Workflow](#fuel-and-expense-management-workflow)
16. [Dashboard and Analytics KPIs](#dashboard-and-analytics-kpis)
17. [Environment Variables & Configuration](#environment-variables--configuration)
18. [Installation Instructions](#installation-instructions)
19. [Frontend Setup & Run Commands](#frontend-setup--run-commands)
20. [Backend Setup & Run Commands](#backend-setup--run-commands)
21. [Database Setup & Migrations](#database-setup--migrations)
22. [API Endpoints & Swagger Documentation](#api-endpoints--swagger-documentation)
23. [How to Use the Application & Seed Credentials](#how-to-use-the-application--seed-credentials)
24. [Build & Deployment Instructions](#build--deployment-instructions)
25. [UI Screenshots & Preview](#ui-screenshots--preview)
26. [Future Improvements](#future-improvements)
27. [License](#license)

---

## Project Overview

TransitOps offers a centralized digital hub for logistics and transport businesses to manage physical vehicle assets, driver safety metrics, trip dispatching, operating costs, and revenue generation. The application couples a responsive React single-page application with a Spring Boot REST API backed by JWT security and MySQL relational storage.

---

## Problem Statement

Modern transport operators face significant challenges due to fragmented systems:
- Lack of real-time visibility into vehicle availability, maintenance schedules, and active trips.
- Inefficient manual driver assignment leading to compliance risks and unmonitored safety scores.
- Uncoordinated fuel logging and expense tracking resulting in unaccounted operational leakages.
- Inability to calculate true Vehicle Return on Investment (ROI) and fleet utilization metrics.

TransitOps resolves these pain points through automated workflow enforcement, status synchronization, role-based governance, and real-time operational metrics.

---

## Key Features

- **Enterprise Security & Granular RBAC**: 6 pre-configured system roles with customizable fine-grained module permissions (`READ`, `CREATE`, `UPDATE`, `DELETE`, `DISPATCH`, `COMPLETE`, `CANCEL`, `EXPORT`).
- **Vehicle Management**: Track license plates, models, vehicle types, max payload capacity, odometer readings, acquisition costs, current location, and real-time operational status (`Available`, `On Trip`, `In Shop`, `Retired`).
- **Driver Management**: CDL license management, expiration tracking, phone contacts, safety score ratings (0–100), system account linkages, and availability status (`Available`, `On Trip`, `Suspended`).
- **Trip Operations**: Full lifecycle support from creation to dispatching, starting, completing, or cancelling. Automatic status propagation to assigned vehicle and driver profiles.
- **Maintenance Management**: Log preventive maintenance and emergency repairs with service types, cost tracking, completion dates, and automatic vehicle status lock (`In Shop`).
- **Fuel & Expense Tracking**: Capture fuel refuel logs (liters, total cost, odometer) with automated ledger creation in vehicle expense logs.
- **Analytics & KPI Reports**: Automated calculations for **Fleet Utilization Rate**, **Fuel Efficiency (km/L)**, **Operating Cost per km**, and **Vehicle Return on Investment (ROI)**.
- **Audit Logging & System Settings**: System audit trail for compliance monitoring and singleton company metadata management.

---

## System Architecture

```text
               +----------------------------------+
               |        React Frontend            |
               | (Vite, TailwindCSS, Zustand)     |
               +----------------------------------+
                                |
                   HTTPS / JSON | Axios (JWT Auth)
                                v
               +----------------------------------+
               |       Spring Boot 3 Backend      |
               | (Spring Security, JPA, OpenAPI)  |
               +----------------------------------+
                                |
                  Hibernate ORM | JDBC
                                v
               +----------------------------------+
               |         MySQL Database           |
               |    (transitops relational DB)    |
               +----------------------------------+
```

---

## Frontend Technology Stack

| Technology | Version | Description |
| :--- | :--- | :--- |
| **React** | `^19.2.7` | UI library for building interactive component views |
| **Vite** | `^6.2.0` | High-performance frontend build tool & development server |
| **TailwindCSS** | `^4.3.2` | Utility-first CSS framework for modern responsive styling |
| **Axios** | `^1.18.1` | HTTP client with request/response authorization interceptors |
| **Zustand** | `^5.0.14` | Lightweight state management for application stores |
| **Recharts** | `^3.9.2` | Charting library for analytics and dashboard visuals |
| **Lucide React**| `^1.24.0` | Modern icon library |
| **GSAP** | `^3.15.0` | High-performance animations |
| **TanStack Table** | `^8.21.3` | Headless table library for data grids |
| **React Hook Form** | `^7.81.0` | Form validation and state management |
| **React Hot Toast** | `^2.6.0` | Toast notifications |

---

## Backend Technology Stack

| Technology | Version | Description |
| :--- | :--- | :--- |
| **Java** | `21` | LTS Java Development Kit |
| **Spring Boot** | `3.5.16` | Application framework |
| **Spring Security** | `3.5.16` | Authentication and authorization framework |
| **JJWT (Java JWT)**| `0.12.6` | JSON Web Token generation and validation |
| **Spring Data JPA**| `3.5.16` | ORM abstraction over Hibernate |
| **Spring Validation**| `3.5.16` | Request payload DTO validation constraints |
| **Springdoc OpenAPI**| `2.8.9` | Swagger UI & OpenAPI 3 specification generator |
| **Lombok** | — | Boilerplate reduction annotations |

---

## Database & Storage Technology

- **Database Engine**: MySQL 8.0+
- **Database Connection**: `jdbc:mysql://localhost:3306/transitops?createDatabaseIfNotExist=true`
- **ORM Configuration**: Hibernate DDL auto set to `update` for automated schema synchronization.
- **Default Database Credentials**: User: `root`, Password: `root`.

---

## Project Folder Structure

```text
Transitops/
├── frontend/
│   ├── public/
│   │   └── vite.svg
│   ├── src/
│   │   ├── api/             # Axios instance & API service modules
│   │   ├── animations/      # GSAP motion utilities
│   │   ├── assets/          # Static logos & graphic assets
│   │   ├── components/      # Common UI components (Navbar, Sidebar, Modals, Cards)
│   │   ├── context/         # Auth and Theme context providers
│   │   ├── hooks/           # Custom React hooks
│   │   ├── pages/           # Application route pages (Dashboard, Vehicles, Trips, etc.)
│   │   ├── routes/          # App routing and Protected/RoleRoute handlers
│   │   ├── store/           # Zustand state stores
│   │   ├── styles/          # Tailwind and global CSS styles
│   │   ├── utils/           # Formatters, CSV export, and validators
│   │   ├── App.jsx
│   │   ├── index.css
│   │   └── main.jsx
│   ├── index.html
│   ├── package.json
│   ├── package-lock.json
│   └── vite.config.js
├── backend/
│   ├── .mvn/                # Maven wrapper binaries
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/transitops/
│   │   │   │   ├── config/       # Security beans & DataInitializer seed configuration
│   │   │   │   ├── constant/     # System constants
│   │   │   │   ├── controller/   # REST Controllers
│   │   │   │   ├── dto/          # Request & Response Data Transfer Objects
│   │   │   │   ├── entity/       # JPA Entities (User, Vehicle, Trip, etc.)
│   │   │   │   ├── enums/        # RoleName and Status enumerations
│   │   │   │   ├── exception/    # Custom exceptions & GlobalExceptionHandler
│   │   │   │   ├── mapper/       # Entity-DTO mapping logic
│   │   │   │   ├── repository/   # Spring Data JPA Repositories
│   │   │   │   ├── security/     # JWT filters, UserDetailsService, SecurityConfig
│   │   │   │   ├── service/      # Business logic service interfaces & implementations
│   │   │   │   └── util/         # Utility classes
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │       └── java/com/transitops/
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
├── .gitignore
└── README.md
```

---

## User Roles and Permissions Matrix

TransitOps enforces role-based access control (RBAC). Permissions are defined by module and action:

| Role | Description | Key Module Permissions |
| :--- | :--- | :--- |
| **ADMIN** | System Administrator | Full access across all modules (`USERS`, `ROLES`, `VEHICLES`, `DRIVERS`, `TRIPS`, `MAINTENANCE`, `FUEL`, `EXPENSES`, `REPORTS`, `AUDIT_LOGS`, `SETTINGS`). |
| **FLEET_MANAGER** | Fleet & Asset Supervisor | Full CRUD on `VEHICLES`, `DRIVERS`, `TRIPS`, `MAINTENANCE`; Read/Create on `FUEL`, `EXPENSES`, `REPORTS`, `SETTINGS`. |
| **DISPATCHER** | Dispatch Coordinator | Full CRUD & Dispatch actions on `TRIPS`; Read access on `VEHICLES` and `DRIVERS`. |
| **SAFETY_OFFICER** | Compliance & Driver Safety | Full CRUD on `DRIVERS`; Read access on `VEHICLES` and `REPORTS`. |
| **FINANCIAL_ANALYST**| Finance & Expense Auditor | Read/Create/Update/Delete on `EXPENSES`; Read/Create on `FUEL`; Read/Export on `REPORTS`. |
| **DRIVER** | Mobile Vehicle Operator | Read access to assigned `TRIPS`; Read/Create refuel entries under `FUEL`. |

---

## Core Modules

1. **Authentication & RBAC**: JWT authorization tokens, session protection, role switching, user profile updates, and role permission customization.
2. **Vehicle Management**: Register, update, and inspect fleet vehicles, operational locations, odometer, and service status.
3. **Driver Management**: Manage driver records, commercial driver licenses (CDL), medical/license expirations, and safety performance scores.
4. **Trip Management**: Schedule cargo shipments, assign driver/vehicle pairs, dispatch, record trip start/completion odometers, and track cargo weight.
5. **Maintenance Log**: Track preventive schedules, repair costs, maintenance status, and vehicle downtime.
6. **Fuel Log**: Record fuel station refills, fuel volume (liters), cost, and odometer reading at pump.
7. **Expense Log**: Complete ledger for operational expenditure (Fuel, Maintenance, Tolls, Insurance, Permits).
8. **Reports & Analytics**: Comprehensive financial and operational reports with CSV data export.

---

## Important Business Rules & Formulas

1. **Automatic Status Synchronization**:
   - Dispatching a trip (`Dispatched` / `In Progress`) automatically sets the assigned Vehicle's status to **`On Trip`** and assigned Driver's status to **`On Trip`**.
   - Completing or cancelling a trip automatically sets the Vehicle and Driver back to **`Available`**.
   - Scheduling active maintenance automatically sets the Vehicle status to **`In Shop`**.
2. **Trip Odometer Validation**:
   - Trip completion requires `endOdometer` to be strictly greater than `startOdometer`.
3. **Fuel Efficiency Formula**:
   $$\text{Fuel Efficiency (km/L)} = \frac{\text{Distance Traveled (km)}}{\text{Fuel Consumed (Liters)}}$$
4. **Vehicle ROI Formula**:
   $$\text{Vehicle ROI (\%)} = \frac{\text{Trip Revenue} - (\text{Fuel Expenses} + \text{Maintenance Costs} + \text{Other Expenses})}{\text{Vehicle Acquisition Cost}} \times 100$$
5. **Fleet Utilization Rate**:
   $$\text{Fleet Utilization (\%)} = \frac{\text{Vehicles currently On Trip}}{\text{Total Operational Fleet Count}} \times 100$$

---

## Trip Lifecycle Workflow

```text
 [ Draft ] ---> [ Dispatched ] ---> [ In Progress ] ---> [ Completed ]
    |                 |                   |
    +-----------------+-------------------+-------------> [ Cancelled ]
```

- **Draft**: Trip details created; vehicle and driver assigned.
- **Dispatched**: Trip confirmed and dispatched. Vehicle and Driver status set to `On Trip`.
- **In Progress**: Cargo loaded and vehicle en route to destination.
- **Completed**: Arrival at destination; end odometer recorded; distance calculated. Vehicle and Driver returned to `Available`.
- **Cancelled**: Trip terminated before completion. Vehicle and Driver released to `Available`.

---

## Vehicle and Driver Status Workflows

### Vehicle Status Lifecycle
- **Available**: Ready for trip assignment or maintenance.
- **On Trip**: Currently assigned to an active trip.
- **In Shop**: Undergoing maintenance or repair.
- **Retired**: Decommissioned asset.

### Driver Status Lifecycle
- **Available**: Ready for dispatch assignment.
- **On Trip**: Currently driving an active trip.
- **Suspended**: Inactive or under compliance review (safety score < 50).

---

## Maintenance Workflow

1. **Schedule / Create Maintenance**: Enter vehicle ID, service type (e.g., Oil Change, Brake Repair), estimated cost, and start date.
2. **Status Change**: Set maintenance log status to `In Progress`. System locks vehicle status to `In Shop`.
3. **Completion**: Update log status to `Completed`, record final actual cost and completion date. System restores vehicle status to `Available`.

---

## Fuel and Expense Management Workflow

1. Driver or Fleet Manager submits a Fuel Log entry (Vehicle ID, Driver ID, Date, Liters, Total Cost, Odometer).
2. Backend creates the Fuel Log record and automatically generates a corresponding entry in the `Expense` table with reference ID `FUEL-{id}`.
3. Financial Analysts can review total operational expenses categorized by `Fuel`, `Maintenance`, `Insurance`, `Tolls`, or `Miscellaneous`.

---

## Dashboard and Analytics KPIs

The main dashboard provides real-time metric cards:
- **Total Fleet Size** & Active Vehicles (`Available`, `On Trip`, `In Shop`).
- **Active Drivers** & Safety Compliance Averages.
- **Total Trips Completed** & In-Transit Cargo Weight.
- **Total Fleet Revenue** & Net Operating Profit.
- **Monthly Fuel Cost Trends** & Maintenance Expenditures.

---

## Environment Variables & Configuration

### Frontend (`frontend/.env.example`)
```env
VITE_API_BASE_URL=/api
```

### Backend (`backend/src/main/resources/application.properties`)
```properties
spring.application.name=transitops

# Database Settings
spring.datasource.url=jdbc:mysql://localhost:3306/transitops?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Server Port
server.port=8080
```

---

## Installation Instructions

### Prerequisites
- **JDK 21** installed and configured in `PATH`.
- **Node.js** (v18+ or v20+) and **npm**.
- **MySQL Server 8.0+** running locally on port `3306`.

---

## Frontend Setup & Run Commands

```bash
# Navigate to frontend directory
cd frontend

# Install Node dependencies
npm install

# Start Vite local development server
npm run dev

# Build production bundle
npm run build
```

The frontend development server will start at `http://localhost:5173`.

---

## Backend Setup & Run Commands

```bash
# Navigate to backend directory
cd backend

# Compile application using Maven Wrapper
./mvnw clean compile    # On Linux/macOS
.\mvnw clean compile    # On Windows PowerShell

# Run Spring Boot backend application
./mvnw spring-boot:run  # On Linux/macOS
.\mvnw spring-boot:run  # On Windows PowerShell
```

The Spring Boot backend server will start on port `8080`.

---

## Database Setup & Migrations

1. Ensure MySQL Server is running on `localhost:3306`.
2. Ensure user `root` with password `root` (or update `application.properties` with your MySQL credentials) has database creation privileges.
3. On application startup, Spring Boot automatically creates the database `transitops` if it does not exist and executes `DataInitializer` to seed initial roles, permissions, users, vehicles, drivers, trips, maintenance logs, fuel logs, and company settings.

---

## API Endpoints & Swagger Documentation

Once the backend is running, access the interactive OpenAPI 3 Swagger UI at:
**`http://localhost:8080/swagger-ui/index.html`**

### Key REST API Endpoints

| Module | HTTP Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- | :--- |
| **Auth** | `POST` | `/api/auth/login` | Authenticate user & return JWT token | Public |
| **Auth** | `POST` | `/api/auth/register` | Register user account | Public |
| **Users** | `GET` / `POST` | `/api/users` | List all users / Create user | `ADMIN` |
| **Roles** | `GET` / `POST` | `/api/roles` | List and update RBAC roles | `ADMIN` |
| **Vehicles** | `GET` / `POST` | `/api/vehicles` | List and register fleet vehicles | `ADMIN`, `FLEET_MANAGER` |
| **Drivers** | `GET` / `POST` | `/api/drivers` | List and update driver profiles | `ADMIN`, `FLEET_MANAGER`, `SAFETY_OFFICER` |
| **Trips** | `GET` / `POST` | `/api/trips` | Create and list trips | `ADMIN`, `FLEET_MANAGER`, `DISPATCHER` |
| **Trips** | `POST` | `/api/trips/{id}/dispatch` | Dispatch assigned trip | `ADMIN`, `FLEET_MANAGER`, `DISPATCHER` |
| **Trips** | `POST` | `/api/trips/{id}/complete` | Record completion & odometer | `ADMIN`, `FLEET_MANAGER`, `DISPATCHER` |
| **Maintenance**| `GET` / `POST` | `/api/maintenance` | Create and track vehicle maintenance | `ADMIN`, `FLEET_MANAGER` |
| **Fuel** | `GET` / `POST` | `/api/fuel` | Log refuel records | `ADMIN`, `FLEET_MANAGER`, `DRIVER`, `FINANCIAL_ANALYST` |
| **Expenses** | `GET` / `POST` | `/api/expenses` | Manage operational expense ledger | `ADMIN`, `FLEET_MANAGER`, `FINANCIAL_ANALYST` |
| **Reports** | `GET` | `/api/reports/fleet-utilization` | Fleet utilization stats | `ADMIN`, `FLEET_MANAGER`, `FINANCIAL_ANALYST` |
| **Reports** | `GET` | `/api/reports/fuel-efficiency` | Fuel efficiency stats (km/L) | `ADMIN`, `FLEET_MANAGER`, `FINANCIAL_ANALYST` |
| **Reports** | `GET` | `/api/reports/vehicle-roi` | Vehicle ROI calculations | `ADMIN`, `FLEET_MANAGER`, `FINANCIAL_ANALYST` |
| **Dashboard** | `GET` | `/api/dashboard` | Aggregated KPI stats | Authenticated |

---

## How to Use the Application & Seed Credentials

Upon initial launch, the system automatically populates sample operational data for Indian logistics operations along with the following role test accounts:

| User Email | Default Password | Assigned Role | Module Target |
| :--- | :--- | :--- | :--- |
| `manu@transitops.com` | `Manu@123` | **ADMIN** | Full System Control & User Management |
| `josphin@transitops.com` | `Josphin@123` | **FLEET_MANAGER** | Vehicle & Driver Operations |
| `rajshree@transitops.com` | `RajShree@123` | **DISPATCHER** | Trip Scheduling & Dispatching |
| `kokil@transitops.com` | `Kokil@123` | **SAFETY_OFFICER** | Safety Compliance & Drivers |
| `akil@transitops.com` | `Akil@123` | **FINANCIAL_ANALYST**| Expense Ledger & Revenue Reports |
| `surya@transitops.com` | `Surya@123` | **DRIVER** | Assigned Driver Portal & Fuel Logging |

---

## Build & Deployment Instructions

### Production Build
1. **Frontend**:
   ```bash
   cd frontend
   npm run build
   ```
   The production static assets will be output to `frontend/dist/`.

2. **Backend**:
   ```bash
   cd backend
   .\mvnw clean package -DskipTests
   ```
   The executable JAR file will be generated at `backend/target/transitops-0.0.1-SNAPSHOT.jar`.

3. **Running Production Artifact**:
   ```bash
   java -jar backend/target/transitops-0.0.1-SNAPSHOT.jar
   ```

---

## UI Screenshots & Preview

| Dashboard & KPI Analytics | Vehicle Fleet Directory |
| :---: | :---: |
| *Real-time metrics, active trip status, and financial overview* | *Fleet status filtering, payload capacities, and maintenance flags* |

---

## Future Improvements

- [ ] **GPS Live Tracking**: Integrate Leaflet / Mapbox live vehicle tracking via IoT telematics.
- [ ] **Real-time Push Notifications**: WebSockets / SSE for instant dispatch and driver alerts.
- [ ] **AI-Powered Route Optimization**: Automated route planning based on traffic and fuel efficiency models.
- [ ] **Mobile App for Drivers**: React Native application for offline proof of delivery and barcode scanning.

---

## License

This project is licensed under the MIT License — see the repository files for details.

Developed with ❤️ for **TransitOps Smart Transport Operations Platform**.
