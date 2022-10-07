package com.bridgelabz.bookstore.repository;


import com.bridgelabz.bookstore.model.CartData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartData, Integer> {

}
