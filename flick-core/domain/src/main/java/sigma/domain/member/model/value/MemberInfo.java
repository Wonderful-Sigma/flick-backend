package sigma.domain.member.model.value;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public final class MemberInfo {

    private Role role;
    private String profileImage;
    private String smsToken;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Role role() {
        return role;
    }

    public String profileImage() {
        return profileImage;
    }

    public String smsToken() {
        return smsToken;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

}