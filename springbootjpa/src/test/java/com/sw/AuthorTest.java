package com.sw;

import com.alibaba.fastjson.JSON;
import com.sw.domain.Author;
import com.sw.domain.AuthorRepository;
import com.sw.domain.Wallet;
import com.sw.domain.WalletRepository;
import com.sw.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AuthorTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private WalletRepository walletRepository;
//    @Test
//    public void saveAuthorTest(){
//        Author author = new Author();
//        author.setNickName("Ginger666");
//        author.setPhone("9175556666");
//        author.setSignDate(new Date());
//        author.setWallet(new Wallet(new BigDecimal(188.23)));
//        authorRepository.save(author);
//    }
    //更新测试方法
//    @Test
//    public void updateAuthorTest(){
//        Author author = authorService.findAuthor((long)9);
//        author.setPhone("1112223333");
//        Wallet wallet = author.getWallet();
//        wallet.setBalance(new BigDecimal(288));
//        author.setWallet(wallet);
//        authorService.updateAuthor(author);
//
//    }
//    @Test
//    public void findAuthorTest(){
//        Author author = authorService.findAuthor(9L);
//        System.out.println(JSON.toJSONString(author, true));
//    }
//    @Test
//    public void findAuthorForPageTest(){
//        Sort sort = Sort.by(Sort.Direction.DESC,"id");
//        Pageable pageable = PageRequest.of(0,5, sort);
//        Page<Author> page = authorRepository.findAll(pageable);
//        System.out.println(JSON.toJSONString(page, true));
//    }
//    @Test
//    public void transactionalTest(){
//        authorService.updateAuthor();
//    }
//    @Test
//    public void deleteAuthorTest(){
//        authorService.deleteAuthor(9L);
//    }
    @Test
    public void findWalletTest(){
        Optional<Wallet> list = walletRepository.findById(2L);
        if (! list.isPresent()){
            System.out.println("not exists");
        }
        Wallet wallet = list.get();
        System.out.println(JSON.toJSONString(wallet, true));
//        System.out.println(wallet);
    }

}
