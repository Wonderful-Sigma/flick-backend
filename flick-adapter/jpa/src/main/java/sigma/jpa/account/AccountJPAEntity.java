package sigma.jpa.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sigma.domain.account.model.value.AccountType;
import sigma.jpa.common.entity.AbstractIdEntity;

@Entity
@Table(name = "tbl_account")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountJPAEntity extends AbstractIdEntity {

    @NotNull
    @Column(unique = true)
    private Long number;

    @NotNull
    private String name;

    @NotNull
    private Long holderId;

    @NotNull
    private Long balance;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private AccountType type;

    @NotNull
    private String profileImage;
}