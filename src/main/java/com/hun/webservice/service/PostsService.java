package com.hun.webservice.service;

import com.hun.webservice.domain.posts.PostsRepository;
import com.hun.webservice.dto.posts.PostsMainResponseDto;
import com.hun.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;


@EnableTransactionManagement
@AllArgsConstructor
@Service
/*Controller와 Service 역할을 분리하기 위해서
* Service를 만들어 Dto를 전달받음*/
public class PostsService{
    private PostsRepository postsRepository;

    /*DB를 CRUD하는 메소드는 @Transactional를 필수적으로 동반함
    * 예외가 발생하면 롤백시킴*/
    @Transactional
    public Long save(PostsSaveRequestDto dto){

        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}