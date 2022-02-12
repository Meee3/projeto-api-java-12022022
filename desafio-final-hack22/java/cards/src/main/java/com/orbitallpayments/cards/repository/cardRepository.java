package com.orbitallpayments.cards.repository;

import com.orbitallpayments.cards.domains.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cardRepository extends CrudRepository<Card, Long> {


}


