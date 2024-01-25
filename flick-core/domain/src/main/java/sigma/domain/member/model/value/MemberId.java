package sigma.domain.member.model.value;

import sigma.domain.common.value.AbstractId;

public final class MemberId/* extends AbstractId */{
    private final String Id;

    public MemberId(final String id) {
        this.Id = id;
    }

    public String getId() {
        return Id;
    }
}