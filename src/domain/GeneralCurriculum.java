package domain;

import java.util.Date;

/**
 *
 * @author Javier Blas
 */
public class GeneralCurriculum {
    private String keyCode;
    private String title;
    private String dependencyInstitute;
    private String facultyOfTheInstitution;
    private String degreeOfConsolidation;
    private int numberOfParticipants;
    private int numberOfCollaborators;
    private Date registrationDate;
    private String lgac;
    private String generalPurpose;
    private String mission;
    private String vision;

    public GeneralCurriculum(String keyCode, String title, String dependencyInstitute, String facultyOfTheInstitution, String degreeOfConsolidation, int numberOfParticipants, int numberOfCollaborators, Date registrationDate, String lgac, String generalPurpose, String mission, String vision) {
        this.keyCode = keyCode;
        this.title = title;
        this.dependencyInstitute = dependencyInstitute;
        this.facultyOfTheInstitution = facultyOfTheInstitution;
        this.degreeOfConsolidation = degreeOfConsolidation;
        this.numberOfParticipants = numberOfParticipants;
        this.numberOfCollaborators = numberOfCollaborators;
        this.registrationDate = registrationDate;
        this.lgac = lgac;
        this.generalPurpose = generalPurpose;
        this.mission = mission;
        this.vision = vision;
    }

    public GeneralCurriculum() {
    }

    public String getKeyCode() {
        return keyCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDependencyInstitute() {
        return dependencyInstitute;
    }

    public String getFacultyOfTheInstitution() {
        return facultyOfTheInstitution;
    }

    public String getDegreeOfConsolidation() {
        return degreeOfConsolidation;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getNumberOfCollaborators() {
        return numberOfCollaborators;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getLgac() {
        return lgac;
    }

    public String getGeneralPurpose() {
        return generalPurpose;
    }

    public String getMission() {
        return mission;
    }

    public String getVision() {
        return vision;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDependencyInstitute(String dependencyInstitute) {
        this.dependencyInstitute = dependencyInstitute;
    }

    public void setFacultyOfTheInstitution(String facultyOfTheInstitution) {
        this.facultyOfTheInstitution = facultyOfTheInstitution;
    }

    public void setDegreeOfConsolidation(String degreeOfConsolidation) {
        this.degreeOfConsolidation = degreeOfConsolidation;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setNumberOfCollaborators(int numberOfCollaborators) {
        this.numberOfCollaborators = numberOfCollaborators;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLgac(String lgac) {
        this.lgac = lgac;
    }

    public void setGeneralPurpose(String generalPurpose) {
        this.generalPurpose = generalPurpose;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    
}
