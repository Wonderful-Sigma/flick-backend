package sigma.domain.member.model.event;

import sigma.domain.member.model.value.MemberId;

public record MemberRegisteredEvent(MemberId id) {}