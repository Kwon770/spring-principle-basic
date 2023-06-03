package inflean.younghan.principle_basic;

import inflean.younghan.principle_basic.member.Grade;
import inflean.younghan.principle_basic.member.Member;
import inflean.younghan.principle_basic.member.MemberService;
import inflean.younghan.principle_basic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}