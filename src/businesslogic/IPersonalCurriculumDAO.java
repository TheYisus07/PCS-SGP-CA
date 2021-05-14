package businesslogic;

import domain.PersonalCurriculum;

/**
 *
 * @author Javier Blas
 */
public interface IPersonalCurriculumDAO {
    public PersonalCurriculum consultPersonalCurriculum (String fullName);
    public int modifyPersonalCurriculum (PersonalCurriculum personalCurriculum, int curp);
}

