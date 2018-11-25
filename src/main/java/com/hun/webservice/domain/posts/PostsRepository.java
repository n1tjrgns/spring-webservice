package com.hun.webservice.domain.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

//JPaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동생성
public interface PostsRepository extends JpaRepository<Posts, Long>{

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}