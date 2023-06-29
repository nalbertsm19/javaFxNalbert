package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao.AgricultorDAO;
import entidades.Agricultor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable{
	
	@FXML
	private BorderPane raizAgricultor;
	
	@FXML
	private TableView<Agricultor> TabelaAgricultor;
	
	@FXML
	private TableColumn<Agricultor, Integer> textFieldcodAgricultor;
	
	@FXML
	private TableColumn<Agricultor, String> textFieldareaServico;
	
	@FXML
	private TableColumn<Agricultor, String> textFieldNome;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		textFieldcodAgricultor.setCellValueFactory(new PropertyValueFactory("codAgricultor"));
		textFieldNome.setCellValueFactory(new PropertyValueFactory("nome"));
	     
		AgricultorDAO agricultorDao = new AgricultorDAO();
		try {
			List<Agricultor> agricultorx = agricultorDao.listaAgri();
			
			TabelaAgricultor.setItems( FXCollections.observableArrayList(agricultorx) ); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCadastrar() throws IOException {
		BorderPane fxml = new FXMLLoader(
				getClass().getResource("/views/TelaCadastro.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) raizAgricultor.getScene().getWindow();
		
		stage.setScene(cena);
	}

}