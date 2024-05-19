package vn.fpt.diamond_shop.security.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "role_id")
    private Long roleId;
}
