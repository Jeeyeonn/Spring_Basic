package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//여기서 어플리케이션의 실제 동작에 필요한 '구현 객체를 생성' !!!!!!
//AppConfig는 생성한 객체 인스턴스의 참조를 '생성자'를 통해서 연결해준다
// MemberServiceImpl -> MemoryMemberRepository
// OrderServiceImpl -> MemoryMemberRepository, FixDiscountPolicy



@Configuration    //-> 설정 정보
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());  //생성자 주입
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy() );
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    } //할인 정책을 바꿀 때는 여기서 !
}
