package am.itspace.libraryspring.service;

import am.itspace.libraryspring.model.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member save(Member member, MultipartFile multipartFile);

    List<Member> findAll();

    Optional<Member> findById(Integer id);

}
