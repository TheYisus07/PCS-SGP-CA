package sgpca;

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

/**
 *
 * @author Javier Blas
 */
public class ControllerMember implements Initializable {
    
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
    private TextField textFieldMemberInsstitutionalEmail;
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
    private TextField textFieldMemberKeyCode;
    
    
    @FXML
    private DatePicker datePickerMemberDateOfBirth;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillComboBoxWihtMemberPosition();
        fillComboBoxWihtMemberTypeOfTeaching();
        fillComboBoxWihtMemberPRODEP();
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
        int getDay = datePickerMemberDateOfBirth.getValue().getDayOfMonth();
        int getMonth = datePickerMemberDateOfBirth.getValue().getMonthValue();
        int getYear = datePickerMemberDateOfBirth.getValue().getYear();
        
        Date memberDate = new Date((getYear-1900), (getMonth-1), getDay);
        memberDAO = new MemberDAO();
        Member member = new Member(textFieldMemberName.getText(), memberDate, textFieldMemberCURP.getText(), textFieldMemberPhoneNumber.getText(), textFieldMemberInsstitutionalEmail.getText(), textFieldMemberDiscipline.getText(), textFieldMemberGradeStudy.getText(), textFieldMemberAreaStudy.getText(), (String) comboBoxMemberTypeOfTeaching.getSelectionModel().getSelectedItem(), textFieldMemberLGAC.getText(), textFieldMemberIES.getText(), (String) comboBoxMemberPRODEP.getSelectionModel().getSelectedItem(), (String) comboBoxMemberPosition.getSelectionModel().getSelectedItem(), textFieldMemberKeyCode.getText());
   
        //System.out.println(comboBoxMemberTypeOfTeaching.getSelectionModel().getSelectedItem());
        memberDAO.registerMember(member);
        //System.out.println(member.toString());
    }
}
