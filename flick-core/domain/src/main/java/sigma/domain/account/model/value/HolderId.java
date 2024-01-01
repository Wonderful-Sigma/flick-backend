package sigma.domain.account.model.value;

import sigma.domain.common.value.AbstractId;

public final class HolderId extends AbstractId {

    public HolderId(final Long id) {
        super(id);
    }

    public HolderId(final AbstractId id) {
        super(id.getId());
    }

}