package sigma.jpa.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface AccountJPARepository extends JpaRepository<AccountJPAEntity, Long> {

    Optional<AccountJPAEntity> findByNumber(Long number);

}