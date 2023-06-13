package inflean.younghan.principle_basic;

import inflean.younghan.principle_basic.discount.DiscountPolicy;
import inflean.younghan.principle_basic.discount.FixDiscountPolicy;
import inflean.younghan.principle_basic.discount.RateDiscountPolicy;
import inflean.younghan.principle_basic.member.MemberRepository;
import inflean.younghan.principle_basic.member.MemberService;
import inflean.younghan.principle_basic.member.MemberServiceImpl;
import inflean.younghan.principle_basic.member.MemoryMemberRepository;
import inflean.younghan.principle_basic.order.OrderService;
import inflean.younghan.principle_basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
