package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.Stock;
import ecommerce.ajc.backend.model.User;
import ecommerce.ajc.backend.repository.StockRepository;
import ecommerce.ajc.backend.repository.UserRepository;
import ecommerce.ajc.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    StockService stockService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStocks(){
        return ResponseEntity.ok().body(stockRepository.findAll());
    }
    @PostMapping
    public ResponseEntity <?> createStock(@RequestBody Stock stock){
        stockRepository.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity <?> upDateStock(@RequestBody Stock stock){
        stockRepository.save(stock);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteStock(@PathVariable long id){
        stockRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity <?> getStock(@PathVariable long id){
        return ResponseEntity.ok().body(stockRepository.findById(id));
    }

    @PutMapping("/less/{id}")
    public ResponseEntity<?> decreaseStockId(@PathVariable long id){
        stockService.decreaseStock(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/more/{id}")
    public ResponseEntity<?> increaseStockId(@PathVariable long id){
        stockService.increaseStock(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}