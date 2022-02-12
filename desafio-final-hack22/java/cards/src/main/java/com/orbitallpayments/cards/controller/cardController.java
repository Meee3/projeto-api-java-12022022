package com.orbitallpayments.cards.controller;

import com.orbitallpayments.cards.domains.Card;
import com.orbitallpayments.cards.repository.cardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/cards")
public class cardController {

    @Autowired
    private com.orbitallpayments.cards.services.cardService cardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        Card savedCard = cardService.save(card);

        return new ResponseEntity(savedCard, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Card>> findAll(){
        List<Card> customers = cardService.findAll();
        return ResponseEntity.ok(customers);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Card> findById (@PathVariable Long id) {
        Optional<Card> fetchedCustomer = cardService.findById(id);

        return ResponseEntity.ok(fetchedCustomer.get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        cardService.deleteById(id);
        return  "Deletado com Sucesso";
    }

//    @PutMapping("/{id}")
//    public ResponseEntity update(@PathVariable("id") long id,
//                                 @RequestBody Card card) {
//        return cardService.findById(id)
//                .map(record -> {
//                    record.setCardNumber(card.getCardNumber());
//                    record.setEmbossName(card.getEmbossName());
//                    record.setDocumentNumber(card.getDocumentNumber());
//                    record.setMotherName(card.getMotherName());
//                    record.setAddress(card.getAddress());
//                    record.setCity(card.getCity());
//
//////                            "cardNumber": 32,
//////                            "embossName": "TL",
//////                            "customerName": "TL",
//////                            "documentNumber": 123,
//////                            "motherName": "Mamãe Chama ...",
//////                            "address": "Rua Principal",
//////                            "city": "Sanca"
////
//                    Card updated = cardService.save(record);
//                    return ResponseEntity.ok().body(updated);
//                }).orElse(ResponseEntity.notFound().build());
//    }




}


