package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var authors = repository.findAll();
        var result = authors.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO create(BookCreateDTO bookCreateDTO) {
        var book = bookMapper.map(bookCreateDTO);
        repository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO findById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var BookDTO = bookMapper.map(book);
        return BookDTO;
    }

    public BookDTO update(BookUpdateDTO bookUpdateDTO, Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        bookMapper.update(bookUpdateDTO, book);
        repository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
