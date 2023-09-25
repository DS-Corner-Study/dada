package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // Member 클래스의 id는 시스템이 정해주는 것
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 요즘은 Null 값에 대한 처리를 Optional로 감싸서 처리 -> 클라이언트가 다른 처리를 할 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) { // 하나가 찾아지면 그냥 그것을 반환하고, 끝까지 찾아지지 않으면 Optional에 Null이 포함되어져서 반환됨
        return store.values().stream() // 루프 돌리기
                .filter(member -> member.getName().equals(name)) // filter를 통해서 parameter로 들어온 name과 같은 경우에만 필터링되어서 반환되도록
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 자바 실무에선 List를 많이 사용
        return new ArrayList<>(store.values()); // store에 있는 values는 member 전체를 의미하는 듯  -> 이걸 반환해줌
    }

    public void clearStore() {
        store.clear(); // store를 싹 비움
    }
}
