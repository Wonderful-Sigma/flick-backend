package sigma.application.auth.interactor.response;

public record TokenResponse(
        String accessToken,
        String refreshToken) {}