/**
	 * CMSC 215 - Intermediate Programming
	 * Project 3
	 * Class Project3 -  Graphical user interface designed to allow users to input trip expenses and return a total cost. 
	 * @author Irving Huerta
	 * 26 Nov 2023
	 * Java Eclipse
	 */



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx. scene.layout.GridPane;
import javafx.stage.Stage; 

public class Project3 extends Application {
	
	// Creates text fields, button, and combo boxes in UI
	private TextField distance = new TextField();
	private TextField gasCost = new TextField();
	private TextField mileage = new TextField();
	private TextField numberDays = new TextField();
	private TextField hotel = new TextField();
	private TextField food = new TextField();
	private TextField attractions = new TextField();
	private Button btCalculate = new Button("Calculate");
	private TextField tripCost = new TextField();
	private ComboBox<String> cbo = new ComboBox<>();
	private ComboBox<String> cbo2 = new ComboBox<>();
	private ComboBox<String> cbo3 = new ComboBox<>();
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create UI
		GridPane gridPane = new GridPane();
		gridPane.setHgap(8);
		gridPane.setVgap(8);
		gridPane.add(new Label("Distance:"), 0, 0);
		gridPane.add(distance, 1, 0);
		gridPane.add(cbo, 2, 0);
		gridPane.add(new Label("Gasoline Cost:"), 0, 1);
		gridPane.add(gasCost, 1, 1);
		gridPane.add(cbo2, 2, 1);
		gridPane.add(new Label("Gas Mileage:"), 0, 2);
		gridPane.add(mileage, 1, 2);
		gridPane.add(cbo3, 2, 2);
		gridPane.add(new Label("Number Of Days:"), 0, 3);
		gridPane.add(numberDays, 1, 3);
		gridPane.add(new Label("Hotel Cost:"), 0, 4);
		gridPane.add(hotel, 1, 4);
		gridPane.add(new Label("Food Cost:"), 0, 5);
		gridPane.add(food, 1, 5);
		gridPane.add(new Label("Attractions:"), 0, 6);
		gridPane.add(attractions, 1, 6);
		gridPane.add(btCalculate, 1, 7);
		gridPane.add(new Label("Total Trip Cost: "), 0, 7);
		gridPane.add(tripCost, 1, 8);
		
		
		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		distance.setAlignment(Pos.BOTTOM_CENTER);
		gasCost.setAlignment(Pos.BOTTOM_CENTER);
		mileage.setAlignment(Pos.BOTTOM_CENTER);
		numberDays.setAlignment(Pos.BOTTOM_CENTER);
		hotel.setAlignment(Pos.BOTTOM_CENTER);
		food.setAlignment(Pos.BOTTOM_CENTER);
		attractions.setAlignment(Pos.BOTTOM_CENTER);
		GridPane.setHalignment(btCalculate, HPos.CENTER);
		tripCost.setAlignment(Pos.BOTTOM_CENTER);
		tripCost.setEditable(false);
		
		// ComboBox properties
		cbo.getItems().addAll("miles", "kilometers");
		cbo.setValue("miles");
		cbo2.getItems().addAll("dollar/gal", "dollar/lit");
		cbo2.setValue("dollar/gal");
		cbo3.getItems().addAll("miles/gal", "miles/lit");
		cbo3.setValue("miles/gal");
		
		// Process events
		btCalculate.setOnAction(e -> calculateTripCost());
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 400, 400);
		primaryStage.setTitle("Trip Cost Estimator"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
		// Method for calculating total trip cost with user input
		public void calculateTripCost() {
			// Get values from text fields 
			double distanceInput = Double.parseDouble(distance.getText());
			double gasInput = Double.parseDouble(gasCost.getText());
			double mileageInput = Double.parseDouble(mileage.getText());
			double numberDaysInput = Double.parseDouble(numberDays.getText());
			double hotelInput = Double.parseDouble(hotel.getText());
			double foodInput = Double.parseDouble(food.getText());
			double attractionsInput = Double.parseDouble(attractions.getText());
			
			// Create a TripCost object
			TripCost finalCost  = new TripCost(distanceInput, gasInput, mileageInput, numberDaysInput, hotelInput, foodInput, attractionsInput);
			
			// Display total trip cost 
			tripCost.setText(String.format("$%.2f", finalCost.totalTripCost()));
			
		}
		
		// Main method 
		public static void main(String[] args) {
			launch(args);
		}
		
}


