package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.MemoryRepository;

public class OrderServiceImpl implements OrderService{

    private final MemoryRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemoryRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemoryRepository getMemberRepository() {
        return memberRepository;
    }
}
