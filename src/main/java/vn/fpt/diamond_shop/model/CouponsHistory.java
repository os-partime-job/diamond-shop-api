package vn.fpt.diamond_shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "coupons_history")
public class CouponsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Size(max = 100)
    @Column(name = "coupons_code", length = 100)
    private String couponsCode;

    @Column(name = "total_discount")
    private Integer totalDiscount;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}