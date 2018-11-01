package com.hun.webservice.web;

import com.hun.webservice.domain.posts.PostsRepository;
import com.hun.webservice.dto.posts.PostsSaveRequestDto;
import com.hun.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController //responsebody를 모든 메소드에 적용해줌
@AllArgsConstructor
public class WebRestController {

    //private PostsRepository postsRepository;
    //WebRestController의 save 메소드를 service의 save로 교체
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        //hello 메소드는 helloworld라는 문자열을 JSON 형태로 반환
        return "HelloWorld";
    }

    //리턴타입 void -> Long
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto)throws InvalidDataAccessApiUsageException {

       // postsRepository.save(dto.toEntity());
       //이 부분도 교체
       return postsService.save(dto);
    }
}