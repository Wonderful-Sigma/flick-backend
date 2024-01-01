package sigma.jpa.account;

import org.springframework.data.jpa.repository.JpaRepository;

interface GroupMemberJPARepository extends JpaRepository<GroupMemberJPAEntity, Long> {

    boolean existsByMemberIdAndAccountId(Long memberId, Long accountId);

}