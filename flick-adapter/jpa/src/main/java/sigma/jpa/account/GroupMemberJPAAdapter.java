package sigma.jpa.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sigma.application.account.outport.GroupMemberDBPort;
import sigma.domain.account.model.GroupMember;

import static sigma.jpa.account.GroupMemberConverter.*;

@Component
@RequiredArgsConstructor
class GroupMemberJPAAdapter implements GroupMemberDBPort {

    private final GroupMemberJPARepository repository;

    @Override
    public GroupMember save(final GroupMember groupMember) {
        return toDomain(repository.save(toEntity(groupMember)));
    }

    @Override
    public boolean existsByMemberAndAccount(final Long memberId, final Long accountId) {
        return repository.existsByMemberIdAndAccountId(memberId, accountId);
    }

}