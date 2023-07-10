package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 서비스 에노테이션을 입력시 스프링 실행시 멤버 서비스를 등록한다.
public class MemberService {

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;



    // 회원가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X
        // 옵셔널로 한번 감싸줘서 ifPresent 메서드를 사용 가능함
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 전체 멤버 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 멤버 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}
