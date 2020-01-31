package com.sw.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {






//    @Query("select a from Author a where a.phone=?1")
//    List<Author> findByPhone(String phone);
//    @Query("select a.nickName,length(a.nickName) from Author a where a.nickName like %?1%")
//    List<Object[]> findArry(String nickName);
//    @Query("select a from Author a where a.nickName like %?1%")
//    List<Author> findByNickName(String nickName, Sort sort);
//    @Query(value = "select * from author where nick_name like %?1%", nativeQuery = true)
//    List<Author> findbySql(String nickName);
//    @Transactional
//    @Modifying
//    @Query("update Author a set a.nick_name =?1 where a.phone=?2")
//    int setNickName(String nickName, String phone);
}
