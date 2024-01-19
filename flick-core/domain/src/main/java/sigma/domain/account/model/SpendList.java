package sigma.domain.account.model;

import sigma.domain.account.model.value.MoneyInfo;
import sigma.domain.account.model.value.SpendListId;
import sigma.domain.account.model.value.SpendType;
import sigma.domain.account.model.value.TargetInfo;

import java.time.LocalDateTime;
import java.time.ZoneId;

public final class SpendList {
    private final SpendListId spendListId;
    private final TargetInfo targetInfo;
    private final MoneyInfo moneyInfo;
    private SpendType spendType;
    private LocalDateTime createdDate;

    public SpendList(SpendListId spendListId, TargetInfo targetInfo, MoneyInfo moneyInfo, SpendType spendType) {
        this.spendListId = spendListId;
        this.targetInfo = targetInfo;
        this.moneyInfo = moneyInfo;
        this.spendType = spendType;
        this.createdDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    //Getter 써야겠지?
    public SpendListId SpendListId() {return spendListId;}

    public TargetInfo TargetInfo() {return targetInfo;}

    public MoneyInfo MoneyInfo() {return moneyInfo;}

    public SpendType SpendType() {return spendType;}

    public LocalDateTime CreatedDate() {return createdDate;}
}
