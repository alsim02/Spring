package it.eng.corso.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.groups.Step1;
import it.eng.corso.bookservice.groups.Step2;
import it.eng.corso.bookservice.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> findAll( ){
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<BookDTO> findByAuthor(@RequestParam String author ){
        return bookService.findByAuthor( author );
    }

    @GetMapping("/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "tutto ok"),
            @ApiResponse(responseCode = "404", description = "l'uuid indicato non esiste sulla base dati")}
    )
    @Operation(summary = "endpoint per ottenere il dettagli di un book", description = "chiamando questo endopoint si ottiene il dettaglio del book con l'uuid indicato")
    public BookDTO findById( @PathVariable String uuid ){
        return bookService.findByUuid( uuid );
    }

    @PostMapping
    public BookDTO save( @RequestBody @Validated({Step2.class, Step1.class}) BookDTO book ){
        return bookService.save( book );
    }

    @PutMapping("/{uuid}")
    public BookDTO update( @PathVariable String uuid, @RequestBody BookDTO book ){
        return bookService.update(uuid, book );
    }

    @PatchMapping("/{uuid}")
    public BookDTO partialUpdate( @PathVariable String uuid, @RequestBody BookDTO book ){
        return bookService.partialUpdate(uuid, book );
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable String uuid ){
        bookService.delete( uuid );
    }

}
