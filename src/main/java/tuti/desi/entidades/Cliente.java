package tuti.desi.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id", nullable = false, unique = true)
=======
	@Column(name = "id", nullable = false, unique = true)
>>>>>>> main
    private Long customerId;

    @Column(nullable = false, unique = true)
    private Long dni;

    @Column
    private String name;

    @Column
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "birth_date", columnDefinition = "DATE", nullable = false)
    private LocalDateTime birthDate;

    @Column(name = "passport_number")
    private String passportNumber;

    public Cliente() {
    }

    public Cliente(Long dni, String name, String address, String email, Long phoneNumber, LocalDateTime birthDate, String passportNumber) {
        this.dni = dni;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
    }

    // Getters
    public Long getCustomerId() {
        return customerId;
    }

    public Long getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    // Setters
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
