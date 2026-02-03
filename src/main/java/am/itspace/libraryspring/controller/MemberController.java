package am.itspace.libraryspring.controller;

import am.itspace.libraryspring.model.Member;
import am.itspace.libraryspring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    public String membersPage(ModelMap modelMap) {
        modelMap.addAttribute("members", memberService.findAll());
        return "member";

    }

    @GetMapping("/members/add")
    public String addMemberPage() {
        return "addMember";
    }

    @PostMapping("/members/add")
    public String addMember(@ModelAttribute Member member, @RequestParam("pic") MultipartFile multipartFile) {

        memberService.save(member, multipartFile);
        return "redirect:/member";
    }


    @GetMapping("/members/{id}")
    public String memberDetailsPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        memberService.findById(id).ifPresent(member -> {
            modelMap.addAttribute("member", member);
        });
        return "memberDetails";
    }
}
