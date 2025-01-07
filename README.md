# BookMyShow

`@MappedSuperClass:` This annotation says that:
1. No table for parent class.
2. All the attributes of parent class will be present as columns in all the child class tables.

- Do we need a table for baseModel? --> No.
- But do you want the attributes of BaseModel to be present in all of its child tables? --> Yes.

`@Id`: Identity/PK column
<br>
`@GeneratedValue(strategy = GenerationType.IDENTITY)`: Auto Incremented
- Identity: Auto Incremented starting from 1.
- uuid: Random UUID string.
- sequence: follow the sequence.
- Auto: Hibernate will decide the best strategy.

`@Entity`: Creates a table with the exact same name.
<br>
`@Entity(name = "table_name")`: Creates a table with the given name.

#### primitive vs Non-primitive Attributes
- Primitive: int, String
- Non-primitive: Enum
- For primitive attributes, we can directly create a column in the table.
- But for non-primitive attributes, we need to define the cardinality.

`@Enumerated`: This states that the attribute is an Enum.
<br>
`@Enumerated(EnumType.ORDINAL)`: This states that the Enum will be stored as an integer in the database.
- Instead of storing the Enum as a string, we can store the corresponding integer(index) value.
- ORDINAL: 0, 1, 2, 3, ...
- String: "UPI", "CREDIT_CARD", "DEBIT_CARD", ...
<br>
`@ElementCollection`: This states that the attribute is a collection of non-primitive Attributes.

##### When I include `@ElementCollection` in it gives me an error?
```java
    @OneToMany
//    @ElementCollection
    private List<Seat> seats;
```

##### Who will create the table in the database?
- Hibernate will create the table in the database not JPA.
- We are using JPA, JPA is internally using JDBC, and JDBC is internally using Hibernate.
- Hibernate is the one who is creating the table in the database.
- Hibernate is the labour who is actually doing the work.
- JPA is kind of contractor who is getting the work done by the labours.

`@RestController`: This annotation allows us to create a  web service.
<br>
- `@RequestMapping("/users")`: This annotation is used to map the web requests onto specific handler classes and/or handler methods.
<br>
- `@GetMapping`: This annotation handles the HTTP GET requests.
<br>
- `@PostMapping`: This annotation handles the HTTP POST requests.
  - `@RequestBody`: This annotation binds the HTTP request body to the domain object.
  <br>
- `@PutMapping`: This annotation handles the HTTP PUT requests.
<br>
- `@DeleteMapping`: This annotation handles the HTTP DELETE requests.

`@Service`: This annotation is used to mark the class as a service provider.
- It will create a singleton object of the class. So, we can use the same object throughout the application.
- It helps in Dependency Injection.

`@Repository`: This annotation is used to mark the class as a Data Access Object.
- Generally we create an interface which extends  the JpaRepository.
- `JpaRepository<Table_name, DataType_of_the_primary_key_of_that_table>`
- Ideally one repository interface should be for one table. It is not a good practice that one repository interface is talking to multiple tables.

##### Benefits of using a JPA Repository
- JPA Repository automatically provides us a lot of methods.
  - `save()`: This method is used to save the data in the database.
  - `findById()`: This method is used to get the data by id from the database.
      - This will automatically convert into this kind of Query: `select * from table_name where id = ?`
  - `findAllById()`: This method is used to get all the data by id from the database.

`@Autowired`: This annotation is used to auto wire the bean on the setter method.

#### Why we use DTOs?
- We do not want to expose our domain objects to the outside world.
- We want to expose only the required fields to the outside world.
- That's why we create dummy objects called DTOs.

`@EnableJpaAuditing`: Asking my Spring Boot application that you have to audit my JPA part.
- Whenever I am using JPA, please keep a track of it.

`@EntityListeners(AuditingEntityListener.class)`: Hey baseModel class, if any event happens on these attributes, you have to listen to it(keep a track of it).

`@CreatedDate`: This annotation is used to keep a track of the created date.

`@LastModifiedDate`: This annotation is used to keep a track of the last modified date.

### Steps to automatically add createdAt and lastModifiedAt columns (Auditing attributes).
1. Enable JPA Auditing on SpringBoot application.
2. `@EntityListeners(AuditingEntityListener.class)` on BaseModel class.
3. Use `@CreatedAt`, `@LastModifiedAt` annotation on the respective attributes.

#### Why `@RestController` for Users and `@Controller` for Tickets?
#### `@Component` vs `@Service` vs `@Repository` vs `@Controller` vs `@RestController`
#### `@Transactional` : Taking Lock in Spring boot

- `@Transactional(isolation = Isolation.SERIALIZABLE)`: All the Queries that you write inside this method will be executed in a lock.
