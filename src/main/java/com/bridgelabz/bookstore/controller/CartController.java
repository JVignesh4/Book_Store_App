package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.CartData;
import com.bridgelabz.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @GetMapping("/getAll/{token}")
    public ResponseEntity<ResponseDTO> getAllCart(@PathVariable String token) {
        List<CartData> cartData = iCartService.getAllCart(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/give/{token}")
    public ResponseEntity<ResponseDTO> getCartById(@PathVariable String token) {
        CartData cartData = iCartService.getCartById(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addCart(@Valid @RequestBody CartDTO cartDTO) {
        String cartData = iCartService.insert(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Cart Data Successfully", cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{token}")
    public ResponseEntity<ResponseDTO> updateBooksById(@PathVariable String token, @Valid @RequestBody CartDTO cartDTO) {
        CartData cartData = iCartService.updateCartById(token, cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Cart Data Successfully", cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/cartDelete/{token}")
    public ResponseEntity<ResponseDTO> deleteCartData(@PathVariable String token) {
        iCartService.deleteCartData(token);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
