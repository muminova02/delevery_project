package uz.doublem.delevery_for_exam.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperProduct {
    private Integer productId;
    private Integer superProductId;
    private boolean isOptional;
    private boolean isActive;
}
