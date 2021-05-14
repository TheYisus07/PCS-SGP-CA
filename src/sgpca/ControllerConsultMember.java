/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpca;

import businesslogic.MemberDAO;
import domain.Member;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javier Blas
 */
public class ControllerConsultMember implements Initializable {
    
    @FXML 
    private Label labelNameMember;
    
    @FXML 
    private Label labelBirthOfDayMember;
    
    @FXML 
    private Label labelCURPMember;        
    
    @FXML 
    private Label labelPhoneNumberMember;
            
    @FXML 
    private Label labelInstitutionalMailMember;
    
    @FXML 
    private Label labelDisciplineMember;
    
    @FXML 
    private Label labelGradeOfStudyMember;        
    
    @FXML 
    private Label labelAreaOfStudyMember; 
            
    @FXML 
    private Label labelTypeOfTeachingMember;
    
    @FXML 
    private Label labelLGACMember;
    
    @FXML 
    private Label labelIESMember; 
    
    @FXML 
    private Label labelPositionMember;
    
    @FXML 
    private Label labelPRODEPMember;
       
    @FXML 
    private Label labelKeycodeMember;
    
    @FXML
    private Button buttonExitMember;
            
    @FXML
    private Button buttonListEvidence;
    
    @FXML
    void getOutOfMemberConsult(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("¿Desea regresar a la lista de miembro?");
        alert.setTitle("Salir");
        Optional<ButtonType> okCancel = alert.showAndWait();
        if (okCancel.get() == ButtonType.OK){
            Stage stage = (Stage) buttonExitMember.getScene().getWindow();
            stage.close();
        }
    }
    
    public void closeWindow(ActionEvent member){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLConsultMemberList.fxml"));
            Stage stage = (Stage)((Node)member.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.hide();
            stage.setScene(scene);
            stage.show();          
        } catch (IOException ex) {
            Logger.getLogger(ControllerConsultMemberList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getMemberSelected(String nameMember){
        labelNameMember.setText(nameMember);
        
        MemberDAO memberDAO = new MemberDAO();
        Member memberConsulted;
        memberConsulted = memberDAO.consultMember(nameMember);
        Date dateOfBirthAux = memberConsulted.getDateOfBirth();
       // String dateOfBirth = (new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirthAux));
        String curp = memberConsulted.getCurp();
        String phoneNumber = memberConsulted.getPhoneNumber();
        String institutionalMail = memberConsulted.getInstitutionalMail();
        String discipline = memberConsulted.getDiscipline();
        String studyGrade = memberConsulted.getStudyGrade();
        String studyArea = memberConsulted.getStudyArea();
        String typeOfTeaching = memberConsulted.getTypeOfTeaching();
        String lgac = memberConsulted.getLgac();
        String ies = memberConsulted.getIes();
        String prodep = memberConsulted.getProdepParticipation();
        String position =  memberConsulted.getPosition();
        String keycode = memberConsulted.getKeycodeAcademicGroup();
        
        labelKeycodeMember.setText(keycode);
        labelPositionMember.setText(position);
        labelPRODEPMember.setText(prodep);
        labelIESMember.setText(ies);
        labelLGACMember.setText(lgac);
        labelTypeOfTeachingMember.setText(typeOfTeaching);
        labelAreaOfStudyMember.setText(studyArea);
        labelGradeOfStudyMember.setText(studyGrade);
        labelDisciplineMember.setText(discipline);
        labelInstitutionalMailMember.setText(institutionalMail);
        labelPhoneNumberMember.setText(phoneNumber);
        labelCURPMember.setText(curp);
       // labelBirthOfDayMember.setText(dateOfBirth);
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
