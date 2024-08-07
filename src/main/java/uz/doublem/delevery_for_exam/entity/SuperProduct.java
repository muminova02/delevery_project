package uz.doublem.delevery_for_exam.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SuperProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    private boolean isOptional;
    private boolean isActive;
}
