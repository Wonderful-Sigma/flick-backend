package sigma.jpa.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sigma.jpa.common.entity.AbstractIdEntity;

@Entity
@Table(name = "tbl_group_member")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupMemberJPAEntity extends AbstractIdEntity {

    @NotNull
    private String memberId;
    @NotNull
    private Long accountId;

}