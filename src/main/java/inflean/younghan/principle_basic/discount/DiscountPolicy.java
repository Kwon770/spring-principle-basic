package inflean.younghan.principle_basic.discount;

import inflean.younghan.principle_basic.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
