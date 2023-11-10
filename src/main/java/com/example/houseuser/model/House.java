package com.example.houseuser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "houses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class House {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="address_f", nullable = false)
    private String adress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User master;

    @OneToMany(mappedBy = "house")
    private List<User> residents;
}
