import com.ssg.membertest.MemberServiceImpl;
import com.ssg.membertest.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)   //Junit 버전에서 spring-test 이용하기 위한 설정 어노테이션
// 스프링의 설정 정보를 로딩하기 위한
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberTest {

    @Autowired
    MemberServiceImpl memberService;

    @Autowired
    MemberVO memberVO;

    @Test
    public void testInsertMember() throws Exception {
        memberVO.setMid("testMid2");
        memberVO.setMpw("testMpw");
        memberVO.setMname("testMname");
        memberService.insertMember(memberVO);
    }

    @Test
    public void testSelectMember() throws Exception {
        List<MemberVO> list = memberService.selectMember();

        for (MemberVO memberVO : list) {
            log.info(memberVO.toString());
            System.out.println(memberVO);
        }
    }

}
