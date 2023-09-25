package hello.hellospring.domain;

public class Member {

    private Long id; // 시스템에서 정해지는 id 값
    private String name; // 고객이 회원가입할 때 직접 적는 이름인 name 값

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
