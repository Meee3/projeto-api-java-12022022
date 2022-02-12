package com.orbitallpayments.cards.services;


import com.orbitallpayments.cards.domains.Card;
import com.orbitallpayments.cards.repository.cardRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class cardService {
    @Autowired
    private cardRepository cardRepository;
    //implementar
    // existsById, saveAll
    //public Long count(Card card) {return cardRepository.count();}


    public Card save(Card card) {
        return cardRepository.save(card);
    }


    public List<Card> findAll(){
        List<Card> cards = new ArrayList<>();

        cardRepository.findAll().forEach(cards :: add);
        return  cards;
    }


    public Optional<Card> findById(Long id){
        return cardRepository.findById(id);
    }

    public  void deleteById(Long id) {
         cardRepository.deleteById(id);
    }


    // Fazer o put(update)



}
