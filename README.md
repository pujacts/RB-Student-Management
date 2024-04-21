# Student Management Service

## Swagger

- **Swagger UI:** [http://localhost:8080/student-management/swagger-ui/index.html](http://localhost:8080/student-management/swagger-ui/index.html)
- **Swagger YAML:** [http://localhost:8080/student-management/v3/api-docs.yaml](http://localhost:8080/student-management/v3/api-docs.yaml)
- **Swagger JSON:** [http://localhost:8080/student-management/v3/api-docs](http://localhost:8080/student-management/v3/api-docs)

## Actuator

- **Actuator Endpoint:** [http://localhost:9000/actuator](http://localhost:9000/actuator)

## Entity Info

- **Entity Table:** student

## Controllers

1. **Admin Controller** (Student Management)
    - **Endpoints:**
        - Add new student
        - Update student
        - Remove student by id
        - Retrieve student by student Id and School Name
        -  - Retrieve student by School Name and School Grade

    
2. **StudentFeeCollectionController** (Fee Management)
    - **Endpoints:**
        - Make fee payment for student
        - Fetch student fee