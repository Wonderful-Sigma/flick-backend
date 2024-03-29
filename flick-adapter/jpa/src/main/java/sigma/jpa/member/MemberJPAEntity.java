package sigma.jpa.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sigma.domain.member.model.value.Role;
import sigma.jpa.common.entity.AbstractTimeEntity;

@Entity
@Table(name = "tbl_member")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJPAEntity /* extends AbstractIdEntity*/ extends AbstractTimeEntity {

    @jakarta.persistence.Id
    private String id;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @NotNull
    private String profileImage;
    @NotNull
    private String fcmToken;
    @NotNull
    private String studentName;
    @NotNull
    private String studentNumber;

}