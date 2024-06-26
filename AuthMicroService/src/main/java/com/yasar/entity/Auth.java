package com.yasar.entity;

import com.yasar.utility.enums.EState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
@Entity
@Table(name = "tbl_auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID için otomatik artan bir HB sequence oluşturur.
    private Long id;
    @Column(unique = true, length = 64, updatable = false)
    private String userName;
    @Column(length = 32)
    private String password;
    @Column(length = 138)
    private String email;
    @Enumerated(EnumType.STRING)
    private EState state;
}
