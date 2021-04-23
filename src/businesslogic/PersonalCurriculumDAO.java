package businesslogic;

import dataacces.Conection;
import domain.PersonalCurriculum;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Blas
 */
public class PersonalCurriculumDAO implements IPersonalCurriculumDAO{
    
    private final Conection connection = new Conection();

    /**
     *
     * @param personalfullName
     * @return
     */
    @Override
    public PersonalCurriculum consultPersonalCurriculum(String personalfullName) {
        String query = "SELECT FullName, DateOfBirth, CURP, PhoneNumber, InstitutionalMail, Discipline, StudyGrade, StudyArea, TypeOfTeaching, LGAC, IES, ProdepParticipation, PositionCA, NumberOfEvidences, DirectedProjects  FROM member WHERE FullName = ?";
        PersonalCurriculum personalCurriculum = null; 
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, personalfullName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                personalCurriculum = new PersonalCurriculum();
                personalCurriculum.setFullName(resultSet.getString("FullName"));                    
                personalCurriculum.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                personalCurriculum.setCurp(resultSet.getString("CURP"));
                personalCurriculum.setPhoneNumber(resultSet.getString("PhoneNumber"));
                personalCurriculum.setInstitutionalMail(resultSet.getString("InstitutionalMail"));
                personalCurriculum.setDiscipline(resultSet.getString("Discipline"));
                personalCurriculum.setStudyGrade(resultSet.getString("StudyGrade"));
                personalCurriculum.setStudyArea(resultSet.getString("StudyArea"));
                personalCurriculum.setTypeOfTeaching(resultSet.getString("TypeOfTeaching"));
                personalCurriculum.setLgac(resultSet.getString("LGAC"));
                personalCurriculum.setIes(resultSet.getString("IES"));
                personalCurriculum.setProdepParticipation(resultSet.getBoolean("ProdepParticipation"));
                personalCurriculum.setPositionCA(resultSet.getString("PositionCA"));
                personalCurriculum.setNumberOfEvidences(resultSet.getInt("NumberOfEvidences"));
                personalCurriculum.setDirectedProjects(resultSet.getString("DirectedProjects"));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(PersonalCurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.disconnect();
        }
        return personalCurriculum;
    }

    @Override
    public int modifyPersonalCurriculum(PersonalCurriculum personalCurriculum, int curp) {
        int result = 0;
        try {
            String query = "UPDATE personalCurriculum SET fullName = ?, dateOfBirth = ?, phoneNumber = ?, institutionalMail = ?, discipline = ?, studyGrade = ?, studyArea = ?, typeOfTeaching = ?, lgac = ?, ies = ?, prodepParticipation = ?, positionCA = ?, numberOfEvidences = ?, directedProjects = ? WHERE curp = ?";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, personalCurriculum.getFullName());
            preparedStatement.setDate(2, (Date) personalCurriculum.getDateOfBirth());
            preparedStatement.setString(3, personalCurriculum.getPhoneNumber());
            preparedStatement.setString(4, personalCurriculum.getInstitutionalMail());
            preparedStatement.setString(5, personalCurriculum.getDiscipline());
            preparedStatement.setString(6, personalCurriculum.getStudyGrade());
            preparedStatement.setString(7, personalCurriculum.getStudyArea());
            preparedStatement.setString(8, personalCurriculum.getTypeOfTeaching());
            preparedStatement.setString(9, personalCurriculum.getLgac());
            preparedStatement.setString(10, personalCurriculum.getIes());
            preparedStatement.setBoolean(11, personalCurriculum.isProdepParticipation());
            preparedStatement.setString(12, personalCurriculum.getPositionCA());
            preparedStatement.setInt(13, personalCurriculum.getNumberOfEvidences());
            preparedStatement.setString(14, personalCurriculum.getDirectedProjects());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonalCurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.disconnect();
        }
        return result;
    }    
}
