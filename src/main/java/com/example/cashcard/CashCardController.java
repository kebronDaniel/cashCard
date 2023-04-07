package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    @GetMapping("/{request_id}")
    public ResponseEntity<CashCard> findByID(@PathVariable Long request_id){
        if (request_id == 99L){
            CashCard cashCard = new CashCard(request_id, 0.0);
            return ResponseEntity.ok(cashCard);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
