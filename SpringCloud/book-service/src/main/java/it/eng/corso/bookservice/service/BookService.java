package it.eng.corso.bookservice.service;

import it.eng.corso.bookservice.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO save(BookDTO book);

    List<BookDTO> findAll();

    List<BookDTO> findByAuthor(String author );

    BookDTO findByUuid(String uuid);

    void delete(String uuid);

    BookDTO update(String uuid, BookDTO book);

    BookDTO partialUpdate(String uuid, BookDTO book);
}
