package controllers;

import java.io.IOException;
import java.sql.SQLException;

import dao.AgricultorDAO;
import entidades.Agricultor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaCadastroController {
	
	@FXML
	private BorderPane raizTelaCadastro;
	
	@FXML
	private TextField textFieldArea;
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldData;
	
	@FXML
	private TextField textFieldCPF;
	
	
	
	  public void clickCadastrar() throws IOException {
		  
		  	String areaServico = textFieldArea.getText();
	        String nome = textFieldNome.getText();
	        String dataNasc = textFieldData.getText();
	        String cpf = textFieldCPF.getText();

	        Agricultor agricultor = new Agricultor(areaServico, nome, dataNasc, cpf);

	        AgricultorDAO daoAgricultor = new AgricultorDAO();

	        try {
	            daoAgricultor.cadastrar(agricultor);
	            clickCancelar();
	        } catch (SQLException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setHeaderText("Atenção");
	            alert.setContentText("Erro ao cadastrar: " + e.getMessage());
	            alert.show();
	        }
	    }
	
	public void clickCancelar() throws IOException {
		BorderPane fxml = new FXMLLoader(
				getClass().getResource("/views/TelaInicial.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) raizTelaCadastro.getScene().getWindow();
		
		stage.setScene(cena);
	}
	
}
