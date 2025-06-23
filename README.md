# Basic Level RESTful Service

Bu proje, Spring Boot ve Spring Data JPA kullanılarak geliştirilmiş temel seviyede bir RESTful servistir. Uygulama, basit öğrenci kayıt işlemlerini (CRUD) gerçekleştirmektedir.

## 🎯 Projenin Amacı

Bu projenin temel amacı:

- Spring Boot ile REST API nasıl oluşturulur göstermek
- Spring Data JPA ile veritabanı işlemlerini soyutlayarak kullanmak
- DTO yapısı ile veri transferinde güvenli ve sadeleştirilmiş veri kullanımı sağlamak
- Katmanlı mimari (controller, service, repository) ile temiz ve sürdürülebilir kod yazmak
- **Postman kullanarak HTTP isteklerini manuel test edebilmek**


## ✅ Uygulamada Yapılanlar

1. **Entity - Student**  
   Öğrencilere ait `firstName`, `lastName`, `birthOfDate` gibi alanlar tanımlanmıştır. `@Entity` anotasyonu ile JPA tablosuna dönüştürülür.

2. **DTO Kullanımı**  
   - `DtoStudentIU` → Kullanıcıdan alınan (input) veriler için
   - `DtoStudent` → Cevap olarak döndürülen (output) veriler için

3. **BeanUtils.copyProperties(...)**  
   DTO ile Entity arasında veri dönüşümleri yapılmaktadır.

4. **Controller Katmanı**  
   REST API uç noktaları (`/save`, `/list`, `/update/{id}`, `/delete/{id}`) üzerinden gelen istekleri karşılar.

5. **Service Katmanı**  
   İş mantığı bu katmanda yer alır. Controller’dan gelen verileri işleyip repository’e iletir.

6. **Repository Katmanı**  
   `JpaRepository` kullanılarak veritabanı işlemleri yapılır.

7. **Veritabanı (PostgreSQL veya H2)**  
   `application.properties` dosyası üzerinden yapılandırılır.

8. **Postman ile Test**  
   Tüm HTTP endpoint'leri Postman aracıyla test edilmiştir. Her bir istek JSON formatında gönderilip yanıtlar gözlemlenmiştir.


## 📌 Kullanılan Teknolojiler

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 / PostgreSQL
- Maven
- **Postman** (HTTP isteklerini test etmek için)


## 📁 Proje Yapısı

com.ipeksavas
├── controller
│ ├── IStudentController.java
│ └── impl/StudentControllerImpl.java
├── services
│ ├── IStudentService.java
│ └── impl/StudentServiceImpl.java
├── dto
│ ├── DtoStudent.java
│ └── DtoStudentIU.java
├── entities
│ └── Student.java
├── repository
│ └── StudentRepository.java
└── starter
└── SpringDataJpaApplication.java


## 🔄 API Endpointleri

| Method | Endpoint                          | Açıklama               |
|--------|-----------------------------------|------------------------|
| `POST` | `/rest/api/student/save`          | Yeni öğrenci kaydı     |
| `GET`  | `/rest/api/student/list`          | Tüm öğrencileri getir  |
| `GET`  | `/rest/api/student/list/{id}`     | ID ile öğrenci getir   |
| `PUT`  | `/rest/api/student/update/{id}`   | Öğrenci güncelle       |
| `DELETE`| `/rest/api/student/delete/{id}`  | Öğrenci sil            |


## ⚙️ Veritabanı Ayarı

`application.properties` dosyası üzerinden yapılandırılır:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


🧪 API Test Süreci
Tüm HTTP istekleri Postman ile manuel olarak test edilmiştir.

POST, GET, PUT, DELETE istekleri ilgili endpoint’lere uygun JSON verileri ile gönderilmiştir.

Yanıtlar JSON olarak alınmış ve başarı durumları (200 OK, 201 Created, 204 No Content) kontrol edilmiştir.
