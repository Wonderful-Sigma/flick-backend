package sigma.application.member.outport;

import sigma.domain.member.model.Member;
import sigma.domain.member.model.exception.MemberNotFound;

import java.util.Optional;

public interface MemberDBPort {

    Member save(Member member);

    Optional<Member> findById(Long id);

    default Member getById(final Long id) {
        return findById(id)
                .orElseThrow(() -> MemberNotFound.EXCEPTION);
    }

}