package uz.doublem.delevery_for_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToMany(mappedBy = "id")
    private List<Product> product;
    private String attachmentName;
    private String prefix;
    private String attachmentSize;
    @CreationTimestamp
    private Timestamp createdAt;
}
