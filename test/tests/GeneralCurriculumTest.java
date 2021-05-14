package tests;

import businesslogic.GeneralCurriculumDAO;
import domain.GeneralCurriculum;
import java.sql.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Javier Blas
 */
public class GeneralCurriculumTest {
    @Test
    public void testConsultPersonalCurriculumByKeyCode() {
        GeneralCurriculumDAO generalCurriculum = new GeneralCurriculumDAO();
        GeneralCurriculum generalCurriculumResult;
        String generalCurriculumKeycodeExpected = "JDOEIJ804";
        generalCurriculumResult = generalCurriculum.consultGeneralCurriculum(generalCurriculumKeycodeExpected);
        String workplanlanKeycodeActual = generalCurriculumResult.getKeyCode();
        Assert.assertEquals("Prueba obtener otro curriculum general", generalCurriculumKeycodeExpected, workplanlanKeycodeActual);
    }
    
    @Test
    public void testUpdateGeneralCurriculumSuccessfully() {
        Date registrationDate = new Date((2004-1900), (2-1), 15);
        GeneralCurriculumDAO generalCurriculum = new GeneralCurriculumDAO();
        GeneralCurriculum updatedGeneralCurriculum = new GeneralCurriculum("JDOEIJ804", "Tecnologías de la informática", "Universidad Veracruzana", "Estadística e informática", "En consolidación", 5, 5, registrationDate, "Sí","Desarrrolar métodos, técnicas y herramientas para el desarrollo de software", "Generar cnocimiento y formar recursos humanos en Ingeniería de Software", "Generar conocimiento y formar recursos humanos en Ingeniería de software");
        int updatedSuccessful = generalCurriculum.modifyGeneralCurriculum(updatedGeneralCurriculum, 0);
        Assert.assertEquals(1, updatedSuccessful);
    }
}
