package am.itspace.libraryspring.repository;

import am.itspace.libraryspring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}


