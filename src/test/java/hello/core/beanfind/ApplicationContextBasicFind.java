package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFind {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("이름없이 타입으로 조회")
    public void findBeanByType() {

        // 타입으로만 조회할 경우 같은 타입이 존재하면 문제가 발생하기도 함
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2() {

        // 권장하지 않지만 구현체 타입으로도 조회가 가능하다. 유연성이 떨어진다..?
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    // 테스트는 항상 실패 테스트도 작성해봐야 한다.

    @Test
    @DisplayName("빈 이름으로 조회 X")
    public void findBeanByNameX(){

//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
//        위에 실행하면 NoSuchBeanDefinitionException 해당 예외 발생
        // 얘는 Assertions를 JUnit 써야함
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));

    }

}
