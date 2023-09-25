package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 한번 끝날 때마다 repository 데이터를 지워주는 코드를 만들어야 순서에 상관없이 테스트 코드를 한꺼번에 실행했을 때 오류가 나지 않음 (의존 관계 없게 설계)
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
     public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //Optional에서는 get으로 꺼낼 수 있음
        // System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result); // (member, null)로 지정하면 오류 발생

        // 좀 더 편한 Assertions (core에 있는 것을 import)
        // Assertions.assertThat(member).isEqualTo(result);

        // Assertions를 static으로 import하면 앞에 Assertions를 적을 필요 없음
        assertThat(member).isEqualTo(result);
        // assertThat(member).isEqualTo(null);
     }

     @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         Member result = repository.findByName("spring1").get();

         assertThat(result).isEqualTo(member1);
     }

     @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         List<Member> result = repository.findAll();

         assertThat(result.size()).isEqualTo(2); // isEqualTo(3)를 하면 오류 발생

     }
}
