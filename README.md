#  Spring Boot CRUD Project with Validation and Custom Queries

##  Project Description
This project is a Spring Boot REST API application that performs CRUD (Create, Read, Update, Delete) operations on **User** and **Product** entities.  
It also includes **input validation** and **custom query methods** using Spring Data JPA.

##  Features

- User Registration with Validation
- Product Management (Add, Update, Delete, View)
- Input Validation using Jakarta Validation
- Custom Query Methods (findBy, existsBy)
- REST API using Spring Boot
- Tested using Postman

##  Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (or H2 Database)
- Postman
- Git & GitHub

##  API Endpoints

###  User APIs

| Method | Endpoint | Description |
|-------|---------|------------|
| POST | /api/user/register | Register new user |
| GET | /api/user/all | Get all users |
| GET | /api/user/{id} | Get user by ID |
| PUT | /api/user/update/{id} | Update user |
| DELETE | /api/user/delete/{id} | Delete user |
| GET | /api/user/email/{email} | Find user by email (Custom Query) |



###  Product APIs

| Method | Endpoint | Description |
|-------|---------|------------|
| POST | /api/products/add | Add new product |
| GET | /api/products/all | Get all products |
| GET | /api/products/{id} | Get product by ID |
| PUT | /api/products/update/{id} | Update product |
| DELETE | /api/products/delete/{id} | Delete product |
| GET | /api/products/name/{name} | Find product by name (Custom Query) |
| GET | /api/products/exists/{name} | Check product existence |


## Validation Used

- `@NotBlank`
- `@Size`
- `@Email`
- `@Pattern`
- `@Positive`
- `@Min`, `@Max`


##  Custom Queries

Spring Data JPA automatically generates queries from method names:

```java
findByEmail(String email);
findByProductName(String productName);
existsByEmail(String email);
existsByProductName(String productName);
```
Testing

All APIs were tested using Postman.

Example Request:
```json
{
  "productName": "Laptop",
  "productDescription": "High performance laptop",
  "productPrice": 70000,
  "productDiscount": 10,
  "stockQuantity": 5
}
```
## Output
### 1. Add Users and products (POST Request)
This request is used to add a new user and product to the database with all required fields.
<img width="502" height="508" alt="p1" src="https://github.com/user-attachments/assets/5c7674e7-4a45-4e5d-8923-a4be9d6a3695" />

<img width="496" height="544" alt="p3" src="https://github.com/user-attachments/assets/54cb1149-1415-43e6-b9fe-76b4e3f13b92" />

### 2. Validation Error
<img width="497" height="493" alt="p2" src="https://github.com/user-attachments/assets/8e1804d9-0107-4a08-ace8-fcd586b9d85d" />

<img width="502" height="487" alt="p4" src="https://github.com/user-attachments/assets/21a4c14a-04d2-4603-bd07-a80614870ba1" />

### 3. Get All Products
This request fetches all products stored in the database.
<img width="506" height="605" alt="p6" src="https://github.com/user-attachments/assets/5884c02e-1e24-4a63-9589-2a4622e3db51" />

### 4. Update Product (PUT Request)
This request updates an existing product using its ID.
<img width="504" height="559" alt="p5" src="https://github.com/user-attachments/assets/23a2c0a4-7bd0-4ff2-9d39-1363cedd857e" />

### 5. Delete Product
This request deletes a product using its ID.
<img width="655" height="422" alt="image" src="https://github.com/user-attachments/assets/22cefbe1-7b9a-453f-a72c-76096d1cc8ef" />

### 6. Custom Query
This demonstrates custom query using `findByEmail()`.
<img width="661" height="511" alt="p8" src="https://github.com/user-attachments/assets/8e62181c-2755-44e7-827a-f4eaf150ea6f" />

This demonstrates custom query using `findByProductName()`.
<img width="652" height="537" alt="p9" src="https://github.com/user-attachments/assets/98e58425-8e54-4e87-9a31-79e38922874f" />

### 7. Exists Query
This checks whether a product exists using `existsByProductName()`.
<img width="666" height="389" alt="s1" src="https://github.com/user-attachments/assets/0410175b-6397-4823-9d08-ef98cdb9e20f" />

---
Prerna - 23BCS80341
