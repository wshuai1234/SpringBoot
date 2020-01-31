package com.shuaiwang.web;
import com.shuaiwang.domain.Book;
import com.shuaiwang.exception.BookNotFoundException;
import com.shuaiwang.service.BookService;
import com.shuaiwang.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;
@Controller
@RequestMapping("/books")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;
    //书单详情
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "book";
    }
//    @ExceptionHandler({Exception.class})
//    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception{
//        logger.error("Request URL:{}, Exception:{}",request.getRequestURL(),e.getMessage());
//        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!= null){
//            throw e;
//        }
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("url",request.getRequestURL());
//        mav.addObject("exception", e);
//        mav.setViewName("error/error");
//        return mav;
//    }
}
