package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 테스트 실행 전 무조건 실행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join(){
        //give
        Member member = new Member(1L, "jeeyeon2", Grade.VIP);

        //when
        memberService.join(member);
        Member find_member = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(find_member);

    }

}
