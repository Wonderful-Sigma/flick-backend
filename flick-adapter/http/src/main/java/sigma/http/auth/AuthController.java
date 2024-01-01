package sigma.http.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sigma.application.auth.interactor.OAuthLoginUseCase;
import sigma.application.auth.interactor.response.TokenResponse;
import sigma.http.auth.request.OAuthLoginRequest;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final OAuthLoginUseCase oAuthLoginUseCase;

    @PostMapping("/login")
    public TokenResponse oauthLogin(@RequestBody OAuthLoginRequest request) {
        return oAuthLoginUseCase.login(request.code());
    }

}