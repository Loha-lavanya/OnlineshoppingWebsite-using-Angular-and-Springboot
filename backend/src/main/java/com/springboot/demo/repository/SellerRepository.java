package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.Seller;
@Repository
public interface SellerRepository extends JpaRepository<Seller,Long>{

}
