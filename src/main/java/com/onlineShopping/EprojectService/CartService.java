package com.onlineShopping.EprojectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineShopping.EprojectModel.Cart;
import com.onlineShopping.EprojectRepo.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    public ResponseEntity<?> addCart(Cart cart){
        cartRepo.save(cart);
        return ResponseEntity.ok(cart);
    }
    public List<Cart> getAllCarts() {
	    return cartRepo.findAll();
	}

    public ResponseEntity<?> DeleteCart(Long cartID){
        cartRepo.deleteById(cartID);
         Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted successfully");
        return ResponseEntity.ok(response);
    }
}
