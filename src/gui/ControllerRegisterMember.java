package gui;

import businesslogic.MemberDAO;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import domain.Member;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Javier Blas
 */
public class ControllerRegisterMember implements Initializable {
    
    private MemberDAO memberDAO; 
    
    @FXML 
    private ComboBox comboBoxMemberPosition;
    @FXML 
    private ComboBox comboBoxMemberTypeOfTeaching;
    @FXML 
    private ComboBox comboBoxMemberPRODEP;
    
    @FXML
    private TextField textFieldMemberName;
    @FXML
    private TextField textFieldMemberCURP;
    @FXML
    private TextField textFieldMemberPhoneNumber;
    @FXML
    private TextField textFieldMemberInstitutionalEmail;
    @FXML
    private TextField textFieldMemberDiscipline;
    @FXML
    private TextField textFieldMemberGradeStudy;
    @FXML
    private TextField textFieldMemberAreaStudy;
    @FXML
    private TextField textFieldMemberLGAC;
    @FXML
    private TextField textFieldMemberIES;
    
    @FXML
    private Label labelMemberKeyCode;
    
    @FXML
    private DatePicker datePickerMemberDateOfBirth;
    
    ObservableList<Member> memberList;
    
    @FXML
    private Button buttonCancel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillComboBoxWihtMemberPosition();
        fillComboBoxWihtMemberTypeOfTeaching();
        fillComboBoxWihtMemberPRODEP();
        
        memberList = FXCollections.observableArrayList();
    }    
    
    @FXML
    public void fillComboBoxWihtMemberPosition(){
        ObservableList<String> listPositions = FXCollections.observableArrayList("Integrante","Colaborador");
        comboBoxMemberPosition.setItems(listPositions);
    }
 
    @FXML
    public void fillComboBoxWihtMemberTypeOfTeaching(){
        ObservableList<String> listTypeOfTeaching = FXCollections.observableArrayList("Tiempo completo","Medio tiempo","Investigación");
        comboBoxMemberTypeOfTeaching.setItems(listTypeOfTeaching);
    }
    
    @FXML
    public void fillComboBoxWihtMemberPRODEP(){
        ObservableList<String> listPRODEP = FXCollections.observableArrayList("Sí","No");
        comboBoxMemberPRODEP.setItems(listPRODEP);
    }
    
    @FXML
    public void RegisterMemberButton(ActionEvent event){
        memberDAO = new MemberDAO();
        
        int getDay = datePickerMemberDateOfBirth.getValue().getDayOfMonth();
        int getMonth = datePickerMemberDateOfBirth.getValue().getMonthValue();
        int getYear = datePickerMemberDateOfBirth.getValue().getYear();
        
        String memberName = textFieldMemberName.getText();
        String memberCURP = textFieldMemberCURP.getText();
        String memberPhoneNumber = textFieldMemberPhoneNumber.getText();
        String memberInstitutionalEmail = textFieldMemberInstitutionalEmail.getText();
        String memberDiscipline = textFieldMemberDiscipline.getText();
        String memberGradeStudy = textFieldMemberGradeStudy.getText();
        String memberAreaStudy = textFieldMemberAreaStudy.getText();
        String memberTypeOfTeaching = (String) comboBoxMemberTypeOfTeaching.getSelectionModel().getSelectedItem();
        String memberLGAC = textFieldMemberLGAC.getText();
        String memberIES = textFieldMemberIES.getText();
        String memberPRODEP = (String) comboBoxMemberPRODEP.getSelectionModel().getSelectedItem();
        String memberPosition = (String) comboBoxMemberPosition.getSelectionModel().getSelectedItem();
        String memberKeyCode = labelMemberKeyCode.getText();
                
        Date memberDate = new Date((getYear-1900), (getMonth-1), getDay);
        
        Member member = new Member(memberName, memberDate, memberCURP, memberPhoneNumber, memberInstitutionalEmail, memberDiscipline, memberGradeStudy, memberAreaStudy, memberTypeOfTeaching, memberLGAC, memberIES, memberPRODEP, memberPosition, memberKeyCode);
   
        MemberDAO memberSentinel = new MemberDAO();
        Member memberConsult;
        memberConsult = memberSentinel.consultMember(memberName);        
        String memberNameConsult = memberConsult.getFullName();
        
        if(!memberName.equals(memberNameConsult)){
            this.memberList.add(member);
            memberDAO.registerMember(member);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmacion");
            alert.setContentText("El miembro ha sido registrado exitosamente");
            alert.showAndWait();
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El miembro ya existe");
            alert.showAndWait();
        }
        
    }
    
    @FXML
    void cancelOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de cancelación");
        alert.setContentText("¿Desea cancelar el registro?");
        Optional<ButtonType> aceptCancel = alert.showAndWait();
        if(aceptCancel.get()==ButtonType.OK){
            Stage stage = (Stage) buttonCancel.getScene().getWindow();
            stage.close();
        }  
    }
    
}
