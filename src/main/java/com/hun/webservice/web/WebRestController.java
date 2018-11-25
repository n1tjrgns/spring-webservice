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

    /*public WebRestController(PostsRepository postsRepository){
    *   this.postsRepository = postsRepository;
    *   }
    *  @AllArgsConstructor
    *  //bean주입 방식 중,
    생성자 주입 방식으로 모든 필드를 인자값으로 하는 생성자를 생성해줌
    이 때 클래스의 의존 관계가 변경될때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위해
    lombok 어노테이션 사용*/
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