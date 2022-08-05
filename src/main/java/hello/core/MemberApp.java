package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService =  appConfig.memberService();

        //AppConfig에 있는 설정정보를 가지고 관리를 해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "Jeeyeon", Grade.VIP);
        memberService.join(member);

        Member f_member = memberService.findMember(1L);
        System.out.println("findMember = " + member.getName());
        System.out.println("member = " + f_member.getName());
    }
}
