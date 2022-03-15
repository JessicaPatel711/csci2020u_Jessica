import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class lab06 extends Application {

    //Data for Bar Chart
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    //Data for Pie Chart
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 06");
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        //Title and Labels
        bc.setTitle("Housing vs Commercial");
        xAxis.setLabel("Year");
        yAxis.setLabel("Price");

        //Getting data for chart 1 
        XYChart.Series chart1 = new XYChart.Series();
        chart1.setName("Housing");
        chart1.getData().add(new XYChart.Data("2009", avgHousingPricesByYear[0]));
        chart1.getData().add(new XYChart.Data("2010", avgHousingPricesByYear[1]));
        chart1.getData().add(new XYChart.Data("2011", avgHousingPricesByYear[2]));
        chart1.getData().add(new XYChart.Data("2012", avgHousingPricesByYear[3]));
        chart1.getData().add(new XYChart.Data("2013", avgHousingPricesByYear[4]));
        chart1.getData().add(new XYChart.Data("2014", avgHousingPricesByYear[5]));
        chart1.getData().add(new XYChart.Data("2015", avgHousingPricesByYear[6]));
        chart1.getData().add(new XYChart.Data("2016", avgHousingPricesByYear[7]));

        //Getting data for chart 2
        XYChart.Series chart2 = new XYChart.Series();
        chart2.setName("Commercial");
        chart2.getData().add(new XYChart.Data("2009", avgCommercialPricesByYear[0]));
        chart2.getData().add(new XYChart.Data("2010", avgCommercialPricesByYear[1]));
        chart2.getData().add(new XYChart.Data("2011", avgCommercialPricesByYear[2]));
        chart2.getData().add(new XYChart.Data("2012", avgCommercialPricesByYear[3]));
        chart2.getData().add(new XYChart.Data("2013", avgCommercialPricesByYear[4]));
        chart2.getData().add(new XYChart.Data("2014", avgCommercialPricesByYear[5]));
        chart2.getData().add(new XYChart.Data("2015", avgCommercialPricesByYear[6]));
        chart2.getData().add(new XYChart.Data("2016", avgCommercialPricesByYear[7]));


        bc.getData().addAll(chart1,chart2); //Group both charts into one 


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]),
                new PieChart.Data(ageGroups[5], purchasesByAgeGroup[5]));

        final PieChart pieC = new PieChart(pieChartData);
        pieC.setTitle("Age Groups Purchase");
        pieC.setLegendVisible(true); //Legend


        FlowPane root = new FlowPane();
        root.getChildren().addAll(bc,pieC); //Bar chart and Pie Chart in one scene 

        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.show();

        customColor(
                pieChartData,
                "aqua",
                "gold",
                "darkorange",
                "darksalmon",
                "lawngreen",
                "plum"
        );
    }
        private void customColor(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
            int i = 0;
            for (PieChart.Data data : pieChartData) {
                data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
                i++;
            }
        }
    


    public static void main(String[] args) {
        launch(args);
    }
}
