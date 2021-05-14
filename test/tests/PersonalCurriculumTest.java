package tests;

import businesslogic.PersonalCurriculumDAO;
import domain.PersonalCurriculum;
import java.sql.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Javier Blas
 */
public class PersonalCurriculumTest {
    
   @Test
    public void testConsultPersonalCurriculumByFullName() {
        PersonalCurriculumDAO personalCurriculum = new PersonalCurriculumDAO();
        PersonalCurriculum personalCurriculumResult;
        String personalFullNameExpected = "Antonio Dominguez Garcia";
        personalCurriculumResult = personalCurriculum.consultPersonalCurriculum(personalFullNameExpected);
        String workplanlanKeycodeActual = personalCurriculumResult.getFullName();
        Assert.assertEquals("Prueba obtener otro curriculum", personalFullNameExpected, workplanlanKeycodeActual);
    }
    
    @Test
    public void testUpdatePersonalCurriculumSuccessfully() {
        Date dateOfBirth = new Date((2001-1900), (7-1), 21);
        PersonalCurriculumDAO personalCurriculum = new PersonalCurriculumDAO();
        PersonalCurriculum updatedPersonalCurriculum = new PersonalCurriculum("Javier Alberto Blas", dateOfBirth, "CABJ010721HVZLLVA3", "2288539804", "zs19014035@estudiantes.uv.mx", "Maestría", "Doctorado", "Innovación", "Completo", "Sí", "Sí", true, "Integrante", 2, "Inteligencia artificial");
        int updatedSuccessful = personalCurriculum.modifyPersonalCurriculum(updatedPersonalCurriculum, 0);
        Assert.assertEquals(1, updatedSuccessful);
    }
}