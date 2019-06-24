package com.lc;

import com.lc.domain.Book;
import com.lc.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot08SpringdataElasticsearchApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void addEsData() {
		Book book = new Book();
		book.setId(4L);
		book.setBookName("java基础");
		book.setAuthor("lc");
		bookRepository.index(book);
	}

	@Test
	public void searchContent() {
		List<Book> bookList = bookRepository.getBookByBookName("java");
		for (Book book : bookList) {
			System.out.println(book);
		}

	}
}
