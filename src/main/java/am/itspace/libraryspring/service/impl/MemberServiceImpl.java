package am.itspace.libraryspring.service.impl;

import am.itspace.libraryspring.model.Member;
import am.itspace.libraryspring.repository.MemberRepository;
import am.itspace.libraryspring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Value("${library.upload.images.directory.path}")
    private String imageDirectoryPath;

    @Override
    public Member save(Member member, MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && multipartFile != null) {
            String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageDirectoryPath + fileName);
            try {
                multipartFile.transferTo(file);
                member.setPictureName(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return memberRepository.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Integer id) {
        return memberRepository.findById(id);
    }
}
