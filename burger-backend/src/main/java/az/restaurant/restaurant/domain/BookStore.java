package az.restaurant.restaurant.domain;

import javax.persistence.*;

@Entity
@Table(name = "book_store")
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private double latitude;
    private double longitude;

    private String address;
    private String phone;
    private String email;
    private String director;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String cheff) {
        this.director = cheff;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cheff='" + director + '\'' +
                '}';
    }
}
