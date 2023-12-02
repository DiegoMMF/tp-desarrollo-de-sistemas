package tuti.desi.presentacion.clientes;

import jakarta.validation.constraints.NotNull;

public class ClienteEditForm {

    @NotNull(message = "El dni no puede ser nulo")
    private Long dni;

    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @NotNull(message = "El apellido no puede ser nulo")
    private String surname;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private String birthDate;

    @NotNull(message = "El email no puede ser nulo")
    private String email;

    @NotNull(message = "El número de teléfono no puede ser nulo")
    private Long phoneNumber;

    @NotNull(message = "La dirección no puede ser nula")
    private String address;

    @NotNull(message = "El número de pasaporte no puede ser nulo")
    private String passportNumber;

    public ClienteEditForm() {
    }

    public ClienteEditForm(Long dni, String name, String surname, String birthDate, String email, Long phoneNumber, String address, String passportNumber) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    // Getters
    public Long getDni() { return dni; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getBirthDate() { return birthDate; }
    public String getEmail() { return email; }
    public Long getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getPassportNumber() { return passportNumber; }

    // Setters
    public void setDni(Long dni) { this.dni = dni; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(Long phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    @Override
    public String toString() {
        return "ClienteEditForm{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public ClienteEditForm toPojo() {
        return new ClienteEditForm(
                dni,
                name,
                surname,
                birthDate,
                email,
                phoneNumber,
                address,
                passportNumber
        );
    }
}
