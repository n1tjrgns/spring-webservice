package com.hun.webservice.domain.posts;

import com.hun.webservice.domain.BaseTimeEntity;
import javafx.scene.chart.ChartBuilder;

//lombok 플러그인 설치
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//import org spring.어쩌고 id 엿는데 javax.persistence로 바꾸니까 됏음
//https://stackoverflow.com/questions/4381290/hibernate-exception-org-hibernate-annotationexception-no-identifier-specified
import javax.persistence.*;

//기본 생성자 자동추가
//access ~~ : 기본 생성자의 접근권한을 protected로 제한
//Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되,
// JPA서 Entity 클래스를 생성하는 것은 허용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter //모든 필드의 게터 메소드 자동 생성성@Entity //실제 DB 테이블과 매칭될 클래스, Entity클래스
        //JPA 사용시 Entity 클래스 수정으로 작업
        //언더스코어 네이밍으로 이름 매칭, SalesManager.java = salse_manager table
public class Posts extends BaseTimeEntity{

    @Id //PK 필드
    @GeneratedValue //PK의 생성규칙, 기본값은 Auto == mysql의 auto_increment

    private Long id;

    //@column은 선언하지 않아도 해당 클래스 필드는 모두 컬럼이 되지만
    //추가로 변경이 필요한 옵션이 있을 경우 사용
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
}