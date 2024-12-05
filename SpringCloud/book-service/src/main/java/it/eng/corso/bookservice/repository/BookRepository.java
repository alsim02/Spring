package it.eng.corso.bookservice.repository;

import it.eng.corso.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByUuid( String uuid );

    List<Book> findByAuthorContainingIgnoreCase( String author );

    List<Book> findByAuthor( String author );

    @Query(value = "select b from Book b where b.author = ?1 and b.author = ?2 ", nativeQuery = true)
    List<Book> findMiaQuery(String author, String param2 );


    @Query("select b from Book b where b.author = :pippo and b.author = :param2 and b.author = :param3")
    List<Book> findMiaQuery2(@Param("pippo") String author,@Param("param2") String param2,@Param("param3") String param3);


    @Query(value = "select * from Book b where b.pippo = :pippo ", nativeQuery = true)
    List<Book> findMiaQuery2(@Param("pippo") String author );


}
