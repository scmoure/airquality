package airquality;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import com.scmoure.csvreader.CSVReader;
import com.scmoure.csvreader.mapper.line.LineMapper;
import com.scmoure.csvreader.mapper.line.ObjectLineMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

  final XYChart.Series<String, Number> series = new XYChart.Series<>();

  final CategoryAxis xAxis = new CategoryAxis();

  final NumberAxis yAxis = new NumberAxis(0, 15.0, 0.5);

  final static String belgium = "Belgium";

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    simpleIndexChart(stage);
  }

  public void simpleIndexChart(Stage stage) {
    stage.setTitle("Stage Title : Air quality");
    yAxis.setLabel("yAxis Label : Air quality");
    xAxis.setLabel("Month");
    final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setTitle("lineChart Title : Madrid 2017 Air Quality");
    List<Double> data = loadData();
    for (int i = 0; i < data.size(); i++) {
      addDataItem(series, Month.of(i + 1).name(), data.get(i));
    }
    Scene scene = new Scene(lineChart, 800, 600);
    series.setName("Madrid Air Quality - 2017");
    lineChart.getData().add(series);
    stage.setScene(scene);
    stage.show();
  }

  public void addDataItem(XYChart.Series<String, Number> series, String x, Number y) {
    series.getData().add(new XYChart.Data<>(x, y));
  }

  @SuppressWarnings("unchecked")
  private static List<Double> loadData() {
    URI filePath = null;
    try {
      filePath = Main.class.getResource("/datos17.csv").toURI();
    } catch (URISyntaxException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }


    Function<List<String>, List<String>> prepareFunction = rawValues -> {
      List<String> values = new ArrayList<>(rawValues);
      for (int i = values.size(); i < 69; i++) {
        values.add("");
      }
      return values;
    };
    LineMapper lineMapper = new ObjectLineMapper.ObjectLineMapperBuilder(MonthlyData.class)
        .prepare(prepareFunction).build();

    List<MonthlyData> results = null;
    CSVReader csvreader = null;
    try {
      csvreader = new CSVReader.CSVReaderBuilder(filePath, MonthlyData.class).withMapper(lineMapper)
          .build();
      results = (List<MonthlyData>) csvreader.read();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    List<Double> averages = new ArrayList<>();
    for (MonthlyData monthlyData : results.subList(0, 12)) {
      averages.add(monthlyData.getDays().stream().filter(day -> "V".equals(day.getControl()))
          .map(day -> day.getValue()).mapToDouble(Float::floatValue).average().getAsDouble());
    }

    return averages;
  }
}
