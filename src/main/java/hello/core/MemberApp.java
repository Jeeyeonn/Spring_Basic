package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService =  appConfig.memberService();

        Member member = new Member(1L, "Jeeyeon", Grade.VIP);
        memberService.join(member);

        Member f_member = memberService.findMember(1L);
        System.out.println("findMember = " + member.getName());
        System.out.println("member = " + f_member.getName());
    }
}