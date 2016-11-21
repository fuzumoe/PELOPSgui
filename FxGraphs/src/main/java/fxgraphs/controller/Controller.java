package fxgraphs.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fxgraphs.application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class Controller implements Initializable {

	/**** Application Context variables ****/
	private Main main;
	/**** FX components ****/
	@FXML
	PieChart piecaht;
	@FXML
	LineChart<String, Number> lineChart;
	@FXML
	Label status;

	public Controller() {

	}

	@SuppressWarnings("unchecked")
	@FXML
	private void handleButtonAction(ActionEvent event) {

		lineChart.getData().clear();
		lineChart.getYAxis().setLabel("MY YY Axis");
		lineChart.getXAxis().setLabel("MY XX Axis");
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		series1.getData().add(new XYChart.Data<String, Number>("Jan", 500));
		series1.getData().add(new XYChart.Data<String, Number>("Feb", 300));
		series1.getData().add(new XYChart.Data<String, Number>("March", 200));
		series1.getData().add(new XYChart.Data<String, Number>("April", 600));
		series1.setName("Payroll 1");

		XYChart.Series<String, Number> series2 = new XYChart.Series<>();

		series2.getData().add(new XYChart.Data<String, Number>("Jan", 400));
		series2.getData().add(new XYChart.Data<String, Number>("Feb", 200));
		series2.getData().add(new XYChart.Data<String, Number>("March", 500));
		series2.getData().add(new XYChart.Data<String, Number>("April", 300));
		series2.setName("Payroll 2");

		XYChart.Series<String, Number> series3 = new XYChart.Series<>();
		series3.getData().add(new XYChart.Data<String, Number>("Jan", 600));
		series3.getData().add(new XYChart.Data<String, Number>("Feb", 200));
		series3.getData().add(new XYChart.Data<String, Number>("March", 300));
		series3.getData().add(new XYChart.Data<String, Number>("April", 400));
		series3.setName("Payroll 2");

		lineChart.getData().addAll(series1, series2, series3);
		for (final XYChart.Data<String, Number> data : series1.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
				status.setText(String.valueOf(data.getXValue()+" "+data.getYValue()) + "%");
			    Tooltip.install(data.getNode(),new Tooltip(String.valueOf(data.getXValue()+" "+data.getYValue()+ "%") ));
			});

		}
		for (final XYChart.Data<String, Number> data : series2.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
				status.setText(String.valueOf(data.getXValue()+" "+data.getYValue()) + "%");
			    Tooltip.install(data.getNode(),new Tooltip(String.valueOf(data.getXValue()+" "+data.getYValue()+ "%") ));

			});
		}
		for (final XYChart.Data<String, Number> data : series3.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
				status.setText(String.valueOf(data.getXValue()+" "+data.getYValue()) + "%");
			    Tooltip.install(data.getNode(),new Tooltip(String.valueOf(data.getXValue()+" "+data.getYValue()+ "%") ));

			});
		}

		/**
		 * PieChart Handle ObservableList<Data> list =
		 * FXCollections.observableArrayList(new PieChart.Data("Java", 50), new
		 * PieChart.Data("C++", 40), new PieChart.Data("C#", 25), new
		 * PieChart.Data("C", 15), new PieChart.Data("python", 20));
		 * piecaht.setData(list); for (final PieChart.Data data :
		 * piecaht.getData()) {
		 * data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,e ->{
		 * status.setText(String.valueOf(data.getPieValue())+"%"); }); }
		 */
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
