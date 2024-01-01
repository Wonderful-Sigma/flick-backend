package sigma.http.auth.request;

public record OAuthLoginRequest(
        String code) {}