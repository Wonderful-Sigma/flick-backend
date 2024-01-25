package sigma.http.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sigma.application.auth.interactor.NewTokenUseCase;
import sigma.application.member.interactor.MemberFindUseCase;
import sigma.application.member.interactor.response.MemberFindByNameResponse;
import sigma.application.member.interactor.response.MemberFindOneResponse;
import sigma.http.member.request.SetFirebaseTokenRequest;

import java.util.List;

@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberFindUseCase memberFindUseCase;
    private final NewTokenUseCase newTokenUseCase;


    //권한 추가(Student)
    @GetMapping("/findOne")
    public MemberFindOneResponse findOne(@RequestHeader(value = "Authorization") String token){
        return memberFindUseCase.findOne(token.substring("Bearer".length()).trim());
    }

    @GetMapping("/search/{memberName}")
    public List<MemberFindByNameResponse> findByName(@PathVariable(value = "memberName") String name){
        return memberFindUseCase.findByName(name);
    }

    @GetMapping("/newAccessToken")
    public String newAccessToKen(@RequestHeader(value = "RefreshToken") String token){
        return newTokenUseCase.newAccessToKen(token);
    }

    @PostMapping("/setFirebase/{memberId}")
    public void setFirebaseToken(@PathVariable(value = "memberId") String memberId, @RequestBody SetFirebaseTokenRequest setFirebaseTokenRequest){
        newTokenUseCase.setNewFirebaseToken(memberId,setFirebaseTokenRequest.firebaseToken());
    }
}