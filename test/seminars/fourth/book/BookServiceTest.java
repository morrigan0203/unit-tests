package seminars.fourth.book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


class BookServiceTest {

    @Test
    public void testBookServiceGetById() {
        Book fakeBook = new Book("1", "Title", "Author");
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findById("1")).thenReturn(fakeBook);
        Book book = bookService.findBookById("1");
        verify(bookRepository, times(1)).findById("1");
        Assertions.assertThat(book.getId()).isEqualTo("1");
        Assertions.assertThat(book.getTitle()).isEqualTo("Title");
        Assertions.assertThat(book.getAuthor()).isEqualTo("Author");
    }

    @Test
    public void testBookServiceGetAll() {
        Book fakeBook = new Book("1", "Title", "Author");

        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(fakeBook));
        List<Book> allBooks = bookService.findAllBooks();
        verify(bookRepository, times(1)).findAll();
        Assertions.assertThat(allBooks)
                .isNotEmpty()
                .hasSize(1)
                .isEqualTo(Arrays.asList(fakeBook));
    }

    @Test
    public void testBook() {
        Book book = new Book("1");
        book.setId("2");
        Assertions.assertThat(book.getId()).isEqualTo("2");
        book.setTitle("Title");
        Assertions.assertThat(book.getTitle()).isEqualTo("Title");
        book.setAuthor("Author");
        Assertions.assertThat(book.getAuthor()).isEqualTo("Author");
    }

}