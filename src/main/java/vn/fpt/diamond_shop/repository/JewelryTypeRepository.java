package vn.fpt.diamond_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.diamond_shop.model.Jewelry;
import vn.fpt.diamond_shop.model.JewelryType;

@Repository
public interface JewelryTypeRepository extends JpaRepository<JewelryType, Integer> {
}