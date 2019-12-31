package uz.doublem.delevery_for_exam.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cupon {
    private Integer id;
    private String code;
    private double discount;
    private Date expiryDate;
    private boolean isActive;
    private Date createdAt;
}
