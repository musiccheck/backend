package bcy.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

<<<<<<< HEAD
    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "picture")
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
=======
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // DB에 저장되지 않는 필드들 (OAuth attributes에서 가져옴)
    @Transient
    private String name;

    @Transient
    private String picture;

    @Transient
>>>>>>> 816efe96c28a00cac6b1cb9d953f20621ffbd8c6
    private Role role;

    @Builder
    public User(String email) {
        this.email = email;
    }

    public User(String email, String name, String picture, Role role) {
        this.email = email;
        this.name = name;
        this.picture = picture;
        this.role = role;
    }

    public void setOAuthAttributes(String name, String picture, Role role) {
        this.name = name;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public String getRoleKey() {
        return this.role != null ? this.role.getKey() : Role.GUEST.getKey();
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}