package businesslogic;

import dataacces.Conection;
import domain.GeneralCurriculum;
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
public class GeneralCurriculumDAO implements IGeneralCurriculumDAO{

    private Conection connection;

    @Override
    public GeneralCurriculum consultGeneralCurriculum(String keycode) {
        String query = "SELECT Keycode, Title, DependencyInstitute, FacultyOfTheInstitution, DegreeOfConsolidation, NumberOfParticipants, NumberOfCollaborators, RegistrationDate, LGAC, GeneralPurpose, Mission, Vision  FROM generalCurriculum WHERE keycode = ?";
        GeneralCurriculum generalCurriculum = null; 
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, keycode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                generalCurriculum = new GeneralCurriculum();
                generalCurriculum.setKeyCode(resultSet.getString("Keycode"));
                generalCurriculum.setTitle(resultSet.getString("Title"));
                generalCurriculum.setDependencyInstitute(resultSet.getString("DependencyInstitute"));
                generalCurriculum.setFacultyOfTheInstitution(resultSet.getString("FacultyOfTheInstitution"));
                generalCurriculum.setDegreeOfConsolidation(resultSet.getString("DegreeOfConsolidation"));
                generalCurriculum.setNumberOfParticipants(resultSet.getInt("NumberOfParticipants"));
                generalCurriculum.setNumberOfCollaborators(resultSet.getInt("NumberOfCollaborators"));
                generalCurriculum.setRegistrationDate(resultSet.getDate("RegistrationDate"));
                generalCurriculum.setLgac(resultSet.getString("LGAC"));
                generalCurriculum.setGeneralPurpose(resultSet.getString("GeneralPurpose"));
                generalCurriculum.setMission(resultSet.getString("Mission"));
                generalCurriculum.setVision(resultSet.getString("Vision"));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(GeneralCurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.disconnect();
        }
        return generalCurriculum;
    }
    
    @Override
    public int modifyGeneralCurriculum(GeneralCurriculum generalCurriculum, int keycode) {
        int result = 0;
        try {
            String query = "UPDATE generalCurriculum SET title = ?, dependencyInstitute = ?, facultyOfTheInstitution = ?, degreeOfConsolidation = ?, numberOfParticipants = ?, numberOfCollaborators = ?, registrationDate = ?, lgac = ?, generalPurpose = ?, mission = ?, vision = ? WHERE keyCode = ?";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, generalCurriculum.getKeyCode());
            preparedStatement.setString(2, generalCurriculum.getTitle());
            preparedStatement.setString(3, generalCurriculum.getDependencyInstitute());
            preparedStatement.setString(4, generalCurriculum.getFacultyOfTheInstitution());
            preparedStatement.setString(5, generalCurriculum.getDegreeOfConsolidation());
            preparedStatement.setInt(6, generalCurriculum.getNumberOfParticipants());
            preparedStatement.setInt(7, generalCurriculum.getNumberOfCollaborators());
            preparedStatement.setDate(8, (Date) generalCurriculum.getRegistrationDate());
            preparedStatement.setString(9, generalCurriculum.getLgac());
            preparedStatement.setString(10, generalCurriculum.getGeneralPurpose());
            preparedStatement.setString(11, generalCurriculum.getMission());
            preparedStatement.setString(12, generalCurriculum.getVision());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GeneralCurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.disconnect();
        }
        return result;
    }
}
