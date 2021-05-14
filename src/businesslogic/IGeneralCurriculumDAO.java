package businesslogic;

import domain.GeneralCurriculum;

/**
 *
 * @author Javier Blas
 */
public interface IGeneralCurriculumDAO {
    public GeneralCurriculum consultGeneralCurriculum (String keycode);
    public int modifyGeneralCurriculum (GeneralCurriculum generalCurriculum, int keycode);
}
