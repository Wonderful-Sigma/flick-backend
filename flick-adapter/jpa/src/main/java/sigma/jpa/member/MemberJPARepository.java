package sigma.jpa.member;

import org.springframework.data.jpa.repository.JpaRepository;

interface MemberJPARepository extends JpaRepository<MemberJPAEntity, Long> {
}