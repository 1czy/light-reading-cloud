package cn.zealon.readingcloud.homepage.service.impl;

import cn.zealon.readingcloud.homepage.service.BookService;
import cn.zealon.readingcloud.homepage.vo.BookVO;
import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cn.zealon.readingcloud.book.feign.client.BookClient;
import java.util.List;

/**
 * 图书
 * @author: tangyl
 * @since: 2019/7/4
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookClient bookClient;

    @Override
    public BookVO getBookDetailsById(String bookId) {
        BookVO bookVO = new BookVO();
        return bookVO;
    }

    @Override
    public Result getBookById(String bookId) {
        return bookClient.getBookById(bookId);
    }

    @Override
    public ResponseEntity<byte[]> getBookList() {
        ResponseEntity<byte[]> bookList = bookClient.getBookList();
        System.out.println(bookList.getBody().length);
        return bookList;
    }

    @Override
    public List<Book> getBookList2() {
        List<Book> bookList2 = bookClient.getBookList2();
        byte[] bytes = bookList2.toString().getBytes();
        System.out.println(bytes.length);
        return bookList2;
    }
}
