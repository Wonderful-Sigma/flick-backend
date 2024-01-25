package sigma.domain.account.model.value;

import sigma.domain.common.value.AbstractId;
import sigma.domain.member.model.value.MemberId;

public final class HolderId /*extends AbstractId */{
    private final MemberId Id;

    public HolderId(final MemberId id) {
        this.Id = id;
    }

    public String getId() {
        return Id.getId();
    }
}