package vn.fpt.diamond_shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.diamond_shop.model.Orders;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {


    Page<Orders> findAllOrderByOrderByCreatedAtDesc(Pageable pageable);

    Page<Orders> findAllOrderByStatusOrderByCreatedAtDesc(String status , Pageable pageable);

    List<Orders> findAllByOrderByCreatedAtDesc();
}