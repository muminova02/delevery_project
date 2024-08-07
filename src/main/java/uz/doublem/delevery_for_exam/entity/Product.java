package uz.doublem.delevery_for_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @CreationTimestamp
    private Timestamp createdAt;
    @OneToMany(mappedBy = "product")
    private List<ProductImages> productImages;
    @OneToMany(mappedBy = "product")
    private List<SuperProduct> superProducts;
}
