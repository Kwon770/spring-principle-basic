package inflean.younghan.principle_basic.order;

import inflean.younghan.principle_basic.discount.DiscountPolicy;
import inflean.younghan.principle_basic.discount.FixDiscountPolicy;
import inflean.younghan.principle_basic.member.Member;
import inflean.younghan.principle_basic.member.MemberRepository;
import inflean.younghan.principle_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
