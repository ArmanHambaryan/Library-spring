package am.itspace.libraryspring.controller;

import am.itspace.libraryspring.model.Member;
import am.itspace.libraryspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/member")
    public String membersPage(ModelMap modelMap) {
        modelMap.addAttribute("members", memberRepository.findAll());
        return "member";

    }

    @GetMapping("/members/add")
    public String addMemberPage() {
        return "addMember";
    }

    @PostMapping("/members/add")
    public String addMember(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/member";
    }


    @GetMapping("/members/{id}")
    public String memberDetailsPage(@PathVariable("id") int id, ModelMap modelMap) {
        // Փորձում ենք գտնել անդամին բազայից
        memberRepository.findById(id).ifPresent(member -> {
            modelMap.addAttribute("member", member);
        });
        return "memberDetails";
    }
}
