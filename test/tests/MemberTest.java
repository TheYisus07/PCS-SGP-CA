package tests;

import businesslogic.MemberDAO;
import domain.Member;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Javier Blas
 */
public class MemberTest {
    @Test
    public void testRegisterMember(){

        MemberDAO member = new MemberDAO();
        Member memberResult;
        Date memberDate = new Date((1995-1900), (5-1), 8);

        Member memberObject = new Member("Antonio Domínguez García", memberDate, "DOGA011207HVZMNRA08", "2288657690" , "zs19014049@estudiante.uv.mx", "Maestria", "Cuarto grado", "Innovación", "Completo", "Sí", "Sí", true, "Integrante", "JDOEIJ804");
        String fullNameMemberExpected = "Antonio Domínguez García";
        memberResult = member.registerMember(memberObject);
        String memberNew = memberResult.getFullName();

        assertEquals("Registrar miembro exitosamente", fullNameMemberExpected, memberNew);

    }
    
    @Test
    public void testRemoveMember() {
        MemberDAO member = new MemberDAO();
        int deleteResult = member.removeMember("Antonio Domínguez García", "DOGA011207HVZMNRA08");
        Assert.assertEquals(1, deleteResult);
    }
    
    @Test
    public void testConsultMemberList() {
        ArrayList<Member> listMembers = new ArrayList<>();
        MemberDAO member = new MemberDAO();
        listMembers = member.consultMemberList();
        Assert.assertTrue(!listMembers.isEmpty());
    }
    
    @Test
    public void testConsultMember() {
        MemberDAO member = new MemberDAO();
        Member memberResult;
        String memberFullNameExpected = "Antonio Domínguez García";
        memberResult = member.consultMember(memberFullNameExpected);
        String memberFullNameActual = memberResult.getFullName();
        Assert.assertEquals("Prueba obtener miembro", memberFullNameExpected, memberFullNameActual);
    }
    
}
