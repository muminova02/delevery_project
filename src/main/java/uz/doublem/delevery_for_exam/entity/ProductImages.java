package uz.doublem.delevery_for_exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImages {
    private int id;
    private int productId;
    private String imageURL;
    private Date createdAt;
}
