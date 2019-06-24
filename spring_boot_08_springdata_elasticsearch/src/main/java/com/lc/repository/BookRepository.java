package com.lc.repository;

import com.lc.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/6/21
 * @Author:lc
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long>{

    List<Book> getBookByBookName(String bookName);

}
