package inflean.younghan.principle_basic.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
