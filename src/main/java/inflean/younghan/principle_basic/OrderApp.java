package inflean.younghan.principle_basic;

import inflean.younghan.principle_basic.member.Grade;
import inflean.younghan.principle_basic.member.Member;
import inflean.younghan.principle_basic.member.MemberService;
import inflean.younghan.principle_basic.member.MemberServiceImpl;
import inflean.younghan.principle_basic.order.Order;
import inflean.younghan.principle_basic.order.OrderService;
import inflean.younghan.principle_basic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
