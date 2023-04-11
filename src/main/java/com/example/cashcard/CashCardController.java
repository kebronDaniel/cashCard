package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{request_id}")
    public ResponseEntity<CashCard> findByID(@PathVariable Long request_id){
        Optional<CashCard> optionalCashCard = cashCardRepository.findById(request_id);
        if (optionalCashCard.isPresent()){
            return ResponseEntity.ok(optionalCashCard.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
