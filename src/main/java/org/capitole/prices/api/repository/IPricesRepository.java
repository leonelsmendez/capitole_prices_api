package org.capitole.prices.api.repository;

import org.capitole.prices.api.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface IPricesRepository extends JpaRepository<Price, Long> {

    List<Price> findAll();

    @Query(value = "select p.id, p.brand_id, p.start_date, p.end_date, p.price_list, p.product_id, p.priority, p.price, p.curr " +
            "from prices p " +
            "where (:startDate is null or :startDate between p.start_date and p.end_date) " +
            "and (:productId is null or :productId = p.product_id) " +
            "and (:brandId is null or :brandId = p.brand_id) ", nativeQuery = true)
    List<Price> findByStartDateAndProductIdAndBrandId(@Param("startDate") LocalDateTime startDate,
                                                      @Param("productId") Integer productId,
                                                      @Param("brandId") Integer brandId);
}
