package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;


   @OneToOne(cascade = CascadeType.ALL)    //при выполн операции над User,она распространяется и на Car
   @JoinColumn(name = "car_id")          //через какие колонки связаны таблицы
   private Car empCar;                  //с какой табл связана табл User

   public User() {}

   public User(String firstName, String lastName, String email, Car empCar) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.empCar = empCar;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getEmpCar() {
      return empCar;
   }

   public void setEmpCar(Car empCar) {
      this.empCar = empCar;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}

