package sigma.jpa.member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sigma.application.member.outport.MemberDBPort;
import sigma.domain.member.model.Member;

import java.util.List;
import java.util.Optional;

import static sigma.jpa.member.MemberConverter.*;

@Component
@RequiredArgsConstructor
class MemberJPAAdapter implements MemberDBPort {

    private final MemberJPARepository repository;
    private final EntityManager entityManager;

    @Override
    public Member save(final Member member) {
        return toDomain(repository.save(toEntity(member)));
    }

    @Override
    public Optional<Member> findById(final String id) {
        return Optional.ofNullable(toDomain(repository.findById(id).orElse(null)));
    }

    @Override
    public List<Member> findByName(final String name){
        return entityManager.createQuery("SELECT m from tbl_member as m where m.studentName = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}