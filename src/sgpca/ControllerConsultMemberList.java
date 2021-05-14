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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Javier Blas
 */
public class ControllerConsultMemberList implements Initializable {
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    ControllerConsultMemberList controllerConsultMemberList;
    
    @FXML
    private TableView<Member> tableViewConsultMembers;
    
    @FXML
    private TableColumn columnNameMember;
            
    @FXML
    private TableColumn columnPositionMember;
    
    @FXML
    private Button buttonExitConsultMember;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showConsultMemberGUI();
        showMemberList();
    }    
    
    @FXML
    void OpenRegisterMemberGUI(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRegisterMember.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            
            stage.hide();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerConsultMemberList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void getOutOfMemberList(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("¿Desea regresar a la lista de miembro?");
        alert.setTitle("Salir");
        Optional<ButtonType> okCancel = alert.showAndWait();
        if (okCancel.get() == ButtonType.OK){
            Stage stage = (Stage) buttonExitConsultMember.getScene().getWindow();
            stage.close();
        }
    }
    
    public void showMemberList() { 
        MemberDAO memberDAO = new MemberDAO();
        ObservableList<Member> memberList = FXCollections.observableArrayList();
        for (int i = 0; i < memberDAO.consultMemberList().size(); i++) {
            memberList.add(memberDAO.consultMemberList().get(i));
        }
        this.columnNameMember.setCellValueFactory(new PropertyValueFactory("fullName"));
        this.columnPositionMember.setCellValueFactory(new PropertyValueFactory("Position"));
        tableViewConsultMembers.setItems(memberList);
    }
    
    public void showConsultMemberGUI(){
        tableViewConsultMembers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Member>(){
             
            @Override
            public void changed(ObservableValue<? extends Member> observable, Member oldValue, Member newValue) {
                    try {
                    Stage stage =  (Stage) tableViewConsultMembers.getScene().getWindow();
                    stage.hide();
                    FXMLLoader fXMLLoader = new FXMLLoader();
                    fXMLLoader.setLocation(getClass().getResource("FXMLConsultMember.fxml"));
                    fXMLLoader.load();
                    ControllerConsultMember controllerConsultMember = fXMLLoader.getController();
                    String memberName = observable.getValue().getFullName();
                    controllerConsultMember.getMemberSelected(memberName);
                    Parent root = fXMLLoader.getRoot();
                    
                    Stage stageConsultMember = new Stage();
                    Scene scene = new Scene(root);
                    stageConsultMember.setScene(scene);
                    stageConsultMember.show();
                } catch (IOException ex) {
                    Logger.getLogger(ControllerConsultMemberList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
