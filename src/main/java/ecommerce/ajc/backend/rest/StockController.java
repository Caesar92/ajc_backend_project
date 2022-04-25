package ecommerce.ajc.backend.rest;


import ecommerce.ajc.backend.model.Stock;
import ecommerce.ajc.backend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    StockRepository stockRepository;

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
}
