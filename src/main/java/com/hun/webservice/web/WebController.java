package com.hun.webservice.web;

import com.hun.webservice.domain.posts.PostsRepository;
import com.hun.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//URL의 컨트롤러
@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    //@RequestMapping 대체체
   @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        /*handlebars-spring-boot-starter덕에 컨트롤러에서 문자열을 반환할 때
        * 앞의 path와 뒤의 파일확장자는 자동으로 지정됨
        * prefix:src/main/resources/templates, suffix :.hbs
        * 그래서 자동으로 전환되어 View Resolver가 처리하게 됨*/
        return "main";
    }
}