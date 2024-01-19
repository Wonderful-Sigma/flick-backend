package sigma.application.member.outport;

import sigma.domain.member.model.Member;
import sigma.domain.member.model.exception.MemberNotFound;

import java.util.List;
import java.util.Optional;

public interface MemberDBPort {

    Member save(Member member);

    Optional<Member> findById(String id);

    default Member getById(final String id) {
        return findById(id)
                .orElseThrow(() -> MemberNotFound.EXCEPTION);
    }

    List<Member> findByName(String name);
}