package persistence.interfaces;

import entities.Offer;

import java.util.List;

//@Repository
public interface IOfferRepository extends IRepositoryCrud<Offer, Long>{
    List<Offer> getAllOffersByClientId(String username);
}
