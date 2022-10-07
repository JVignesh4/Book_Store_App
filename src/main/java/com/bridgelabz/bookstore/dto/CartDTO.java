package com.bridgelabz.bookstore.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CartDTO {

    private int userId;
    private int bookId;
    @NotNull(message = "quantity should not be null")
    private int quantity;
}
