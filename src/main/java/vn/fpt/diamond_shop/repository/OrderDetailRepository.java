package vn.fpt.diamond_shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.diamond_shop.model.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    Page<OrderDetail> findAllByCustomerIdAndStatusOrderByCreatedAtDesc(Long customerId, String status, Pageable pageable);

    List<OrderDetail> findAllByCustomerIdAndStatus(Long customerId, String status);

    Page<OrderDetail> findAllByCustomerIdOrderByCreatedAtDesc(Long customerId, Pageable pageable);

    List<OrderDetail> findAllByUniqueOrderId(String uniqueOrderId);
}
