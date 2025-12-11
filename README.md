# fastclub-membership
Membership Program Assignment – Java Spring Boot


# 🚀 FastClub Membership Program (Backend System)

A complete backend system designed for managing **Membership Plans, Tiers, Subscriptions, Upgrades, Downgrades, Cancellations, Tier Evaluations, and Auto-Expiry** using **Spring Boot**.

This project is built to demonstrate clean backend architecture, REST API design, scheduling, concurrency handling, and membership lifecycle management.

---

## 🧩 Overview

The **Membership Program** allows users to subscribe to different plans (Monthly, Quarterly, Yearly) and automatically assigns them to Silver, Gold, or Platinum tiers.

The service provides:

- Complete membership lifecycle management  
- Tier upgrades and downgrades  
- Automatic expiration  
- Tier evaluation based on user activity  
- Realistic project structure following industry standards  

---

## ⭐ Features

### 👤 Subscription Lifecycle
- Subscribe to a membership plan  
- Upgrade membership tier  
- Downgrade tier  
- Cancel subscription  
- Auto-expire subscription via Scheduler  
- Check active membership  

### 🛠 System Features
- REST APIs  
- H2 in-memory or persistent DB  
- Clean architecture with layered services  
- Concurrency safe using `@Version`  
- Seeded plans and tiers using `data.sql`  

---

## 🏗 Architecture
Controller → Service → Repository → H2 Database
↓
BillingAdapter
↓
SubscriptionExpiryScheduler


## 🛠 Tech Stack

- **Java 17**
- **Spring Boot (Web, JPA, Scheduling)**
- **H2 Database**
- **Lombok**
- **Spring Validation**
- **Quartz Scheduler**
- **Maven**

---

## 📂 Project Structure
membership/
├── controller/
│ ├── HealthController.java
│ ├── PlanController.java
│ ├── SubscriptionController.java
│ └── TierEvaluationController.java
│
├── service/
│ ├── SubscriptionService.java
│ ├── PlanService.java
│ ├── TierEvaluationService.java
│ └── impl/
│ ├── SubscriptionServiceImpl.java
│ ├── PlanServiceImpl.java
│ └── TierEvaluationServiceImpl.java
│
├── repository/
│ ├── SubscriptionRepository.java
│ ├── PlanRepository.java
│ └── TierRepository.java
│
├── domain/
│ ├── Plan.java
│ ├── Tier.java
│ └── Subscription.java
│
├── dto/
│ ├── SubscribeRequest.java
│ ├── UpgradeRequest.java
│ ├── DowngradeRequest.java
│ ├── TierEvaluationRequest.java
│ └── SubscriptionResponse.java
│
├── adapter/
│ ├── BillingAdapter.java
│ └── MockBillingAdapter.java
│
├── scheduler/
│ └── SubscriptionExpiryScheduler.java
│
├── resources/
│ ├── application.properties
│ └── data.sql
│
└── MembershipApplication.java


---

## 🗄 Database Schema

### PLAN Table
| Column | Type |
|--------|------|
| id | string |
| name | string |
| billingCycle | string |
| price | number |

### TIER Table
| Column | Type |
|--------|------|
| id | string (1,2,3) |
| name | SILVER/GOLD/PLATINUM |
| discountPercent | number |
| freeDelivery | boolean |
| prioritySupport | boolean |

### SUBSCRIPTION Table
| Column | Type |
|--------|------|
| id | UUID |
| userId | string |
| planId | string |
| tierId | string |
| startDate | datetime |
| expiryDate | datetime |
| status | ACTIVE / CANCELLED / EXPIRED |
| version | integer |

---

## 📡 API Endpoints

### 🔹 Health


GET /health


### 🔹 Plans & Tiers


GET /api/v1/memberships/plans
GET /api/v1/memberships/tiers


### 🔹 Subscribe


POST /api/v1/memberships/subscribe

Body:
```json
{
  "userId": "user123",
  "planId": "p-monthly",
  "tierId": "1"
}

🔹 Get Active User Subscription
GET /api/v1/memberships/users/{userId}

🔹 Upgrade Subscription
POST /api/v1/memberships/{subscriptionId}/upgrade

🔹 Downgrade Subscription
POST /api/v1/memberships/{subscriptionId}/downgrade

🔹 Cancel Subscription
POST /api/v1/memberships/{subscriptionId}/cancel

🔹 Evaluate Tier (Admin)
POST /api/v1/memberships/evaluate-tier

🔄 Subscription Lifecycle
SUBSCRIBE → ACTIVE → UPGRADE/DOWNGRADE → CANCEL → EXPIRED


Scheduler runs every midnight:

cron: 0 0 0 * * ?

▶ How to Run
1️⃣ Clone repo
git clone https://github.com/<your-username>/fastclub-membership.git

2️⃣ Navigate inside project
cd membership

3️⃣ Run project
mvn spring-boot:run

4️⃣ Open H2 Console (optional)
http://localhost:8080/h2-console

🧪 Curl Examples
Subscribe
curl -X POST http://localhost:8080/api/v1/memberships/subscribe \
-H "Content-Type: application/json" \
-d "{\"userId\":\"user123\",\"planId\":\"p-monthly\",\"tierId\":\"1\"}"

Upgrade
curl -X POST http://localhost:8080/api/v1/memberships/<id>/upgrade \
-H "Content-Type: application/json" \
-d "{\"newTierId\":\"2\"}"

Downgrade
curl -X POST http://localhost:8080/api/v1/memberships/<id>/downgrade \
-H "Content-Type: application/json" \
-d "{\"newTierId\":\"1\"}"

Cancel
curl -X POST http://localhost:8080/api/v1/memberships/<id>/cancel

Evaluate Tier
curl -X POST http://localhost:8080/api/v1/memberships/evaluate-tier \
-H "Content-Type: application/json" \
-d "{\"userId\":\"user123\",\"totalOrders\":8,\"totalSpend\":3000}"

🚀 Future Enhancements

JWT Authentication

Swagger Documentation

Tier rules stored in DB

Event-driven notifications (email/SMS)

Outbox pattern for billing events

Multi-plan support

Audit logs
