package mk.ukim.finki.wp.project.epetshop.demo.web;


import mk.ukim.finki.wp.project.epetshop.demo.model.Member;
import mk.ukim.finki.wp.project.epetshop.demo.model.Product;
import mk.ukim.finki.wp.project.epetshop.demo.model.enumerations.MemberRole;
import mk.ukim.finki.wp.project.epetshop.demo.model.enumerations.VerificationStatus;
import mk.ukim.finki.wp.project.epetshop.demo.service.AuthService;
import mk.ukim.finki.wp.project.epetshop.demo.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/api/members")
public class MemberRestController {

    private final AuthService authService;
    private final MemberService memberService;

    public MemberRestController(AuthService authService, MemberService memberService) {
        this.authService = authService;
        this.memberService = memberService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Member> registration(@RequestParam String username,
                                       @RequestParam String email,
                                       @RequestParam String password,
                                       @RequestParam String repeat,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName) {
        return this.memberService.register(username, email, password, repeat,
                firstName, lastName, MemberRole.ROLE_USER, VerificationStatus.PENDING)
                .map(m -> ResponseEntity.ok().body(m))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/login")
    public Member login(@RequestParam String username, @RequestParam String password){
        return this.authService.login(username, password);
    }

}
