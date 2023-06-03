package inflean.younghan.principle_basic;

import inflean.younghan.principle_basic.member.Grade;
import inflean.younghan.principle_basic.member.Member;
import inflean.younghan.principle_basic.member.MemberService;
import inflean.younghan.principle_basic.member.MemberServiceImpl;
import inflean.younghan.principle_basic.order.Order;
import inflean.younghan.principle_basic.order.OrderService;
import inflean.younghan.principle_basic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
