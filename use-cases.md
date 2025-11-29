# Use Cases — Airline & Plane Service

## 1. Create Airline
**Actor:** Admin, plane-service  
**Description:** Додати нову авіакомпанію з базовою інформацією.  
**Flow:**
1. Admin надсилає request з name, country, foundedYear, description.
2. Система перевіряє унікальність name.
3. Створюється запис у БД.
4. Повертається AirlineResponse.

## 2. Get Airline
**Actor:** Користувач, plane-service  
**Description:** Отримати детальну інформацію про авіакомпанію.  
**Flow:**
1. User запитує авіакомпанію по ID.
2. Система шукає airline в БД.
3. Якщо знайдено — повертає AirlineResponse.
4. Якщо не знайдено — повертає 404.

## 3. Create Plane
**Actor:** Admin, plane-service  
**Description:** Створити новий літак, прив’язаний до авіакомпанії.  
**Flow:**
1. Admin передає DTO з model, capacity, airlineId.
2. Система перевіряє існування airlineId.
3. Створює запис у таблиці planes.
4. Повертає PlaneResponse.

## 4. Get Plane
**Actor:** Користувач, plane-service  
**Description:** Отримати деталі літака.  
**Flow:**
1. User запитує літак по ID.
2. Система шукає літак у БД.
3. Якщо знайдено — повертає PlaneResponse.
4. Якщо не знайдено — повертає 404.
