package cn.zealon.bookstore.bookcenter.service.impl;

import cn.zealon.bookstore.bookcenter.service.BookService;
import cn.zealon.bookstore.common.pojo.book.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 图书服务
 * @author: tangyl
 * @since: 2019/7/4
 */
@Service
public class BookServiceImpl implements BookService {

    @Override
    public Book getBookById(String bookId) {
        Random random = new Random();
        int index = random.nextInt(100);
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookName("冰与火之歌"+index);
        book.setAuthorPenname("马丁");
        // 模拟超时，进行随机睡眠
        int s = random.nextInt(1100);
        try {
            System.out.println("睡眠:"+s);
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getBookList() {
        List<Book> list = new ArrayList<>(5000);
        for (int i = 0; i < 1000; i++) {
            Book book = this.getBookById(String.valueOf(i));
            list.add(book);
        }
        return list;
    }
}
