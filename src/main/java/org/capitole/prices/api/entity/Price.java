package org.capitole.prices.api.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Price {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "brand_id")
    private Integer brandId;
    @Column(name = "price_list")
    private Integer priceList;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price")
    private double price;
    @Column(name = "curr")
    private String curr;

    @Override
    public String toString() {
        return "Price{" +
                "brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", curr=" + curr +
                '}';
    }
}
