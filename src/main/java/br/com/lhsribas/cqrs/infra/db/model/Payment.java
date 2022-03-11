package br.com.lhsribas.cqrs.infra.db.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @SequenceGenerator(name="payment_seq", sequenceName="payment_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payment_seq")
    @Column(name = "payment_id", length = 15, nullable = false)
    private Long id;

    @Column(name = "customer", length = 255, nullable = false)
    private String customer;

    @Column(name = "product", length = 255, nullable = false)
    private String product;

    @Column(name = "date_buy", nullable = false)
    private LocalDateTime date;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
