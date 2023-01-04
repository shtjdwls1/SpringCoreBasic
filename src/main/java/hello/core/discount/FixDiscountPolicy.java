package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 할인금액 = 1000원 고정

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ // member 등급 VIP면 할인
            return  discountFixAmount;
        }else{
            return 0; // 아니면 할인 x
        }

    }
}
