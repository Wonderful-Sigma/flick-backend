package sigma.application.member.outport;

import sigma.domain.member.model.Member;

public interface MemberSessionPort {

    Member current();

}