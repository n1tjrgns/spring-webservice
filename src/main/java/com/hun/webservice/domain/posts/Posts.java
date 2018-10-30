package com.hun.webservice.domain.posts;

import com.hun.webservice.domain.BaseTimeEntity;
import javafx.scene.chart.ChartBuilder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//import org spring.어쩌고 id 엿는데 javax.persistence로 바꾸니까 됏음
//https://stackoverflow.com/questions/4381290/hibernate-exception-org-hibernate-annotationexception-no-identifier-specified
import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /*public String getTitle(String title) {
        this.title = title;
        return title;
    }
    public String getContent(String content){
        this.content = content;
        return content;
    }*/
}