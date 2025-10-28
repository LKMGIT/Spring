import com.ssg.membertest.service.MemberServiceImpl;
import com.ssg.membertest.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)   //Junit 버전에서 spring-test 이용하기 위한 설정 어노테이션
// 스프링의 설정 정보를 로딩하기 위한
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberTest {

    @Autowired
    MemberServiceImpl memberService;

    @Test
    @Transactional  // ?
    @Rollback(false) // >
    public void testInsertMember() throws Exception {
        MemberVO vo = new MemberVO();
        vo.setMid("testMid5");
        vo.setMpw("testMpw");
        vo.setMname("testMname");
        vo.setMdate(LocalDate.now());
        memberService.insertMember(vo);
    }

    @Test
    public void testSelectMember() throws Exception {
        memberService.selectMember().forEach(System.out::println);
    }

}
