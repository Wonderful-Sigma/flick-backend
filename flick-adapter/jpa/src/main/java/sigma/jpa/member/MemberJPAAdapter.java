package sigma.jpa.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sigma.application.member.outport.MemberDBPort;
import sigma.domain.member.model.Member;

import java.util.Optional;

import static sigma.jpa.member.MemberConverter.*;

@Component
@RequiredArgsConstructor
class MemberJPAAdapter implements MemberDBPort {

    private final MemberJPARepository repository;

    @Override
    public Member save(final Member member) {
        return toDomain(repository.save(toEntity(member)));
    }

    @Override
    public Optional<Member> findById(final Long id) {
        return Optional.ofNullable(toDomain(repository.findById(id).orElse(null)));
    }

}