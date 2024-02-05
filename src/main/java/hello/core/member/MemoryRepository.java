package hello.core.member;

public interface MemoryRepository {

    void save(Member member);

    Member findById(Long memberId);
}
