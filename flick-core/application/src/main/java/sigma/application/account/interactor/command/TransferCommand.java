package sigma.application.account.interactor.command;

public record TransferCommand(
        Long sender,
        Long receiver,
        Long amount) {}