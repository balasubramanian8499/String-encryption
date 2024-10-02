package com.demo.stringencryption.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deleted_flag")
    private Boolean deletedFlag;

    @Column(name = "created_by",nullable = false)
    private Integer createdBy;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_by",nullable = false)
    private Integer updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = false)
    private Timestamp updatedAt;

}
