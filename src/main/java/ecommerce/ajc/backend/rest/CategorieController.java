package ecommerce.ajc.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    CategorieController categorieController;

    @GetMapping(produces = PageAttributes.MediaType.APPLICATION_JASON_VALUE)
}
