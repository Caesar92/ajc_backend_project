package ecommerce.ajc.backend.service;

import ecommerce.ajc.backend.model.Stock;
import ecommerce.ajc.backend.model.Vetement;
import ecommerce.ajc.backend.repository.StockRepository;
import ecommerce.ajc.backend.repository.VetementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public void increaseStock(long id){
        Stock stock = stockRepository.findById(id).get();
        stock.setQuantite(stock.getQuantite()+1);
        stockRepository.save(stock);
    }

    public void decreaseStock(long id){
        Stock stock = stockRepository.findById(id).get();
        stock.setQuantite(stock.getQuantite()-1);
        stockRepository.save(stock);
    }
}
