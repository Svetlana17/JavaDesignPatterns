package mvc.controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import mvc.model.Point;
import mvc.model.PointsHolder;

public class TabulatedLineChartWithLegend extends Application {
    private TableView<Point> table;
    private LineChart lineChart;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart With Attached Tabulated Data");

        final NumberAxis xAxis = new NumberAxis();
        xAxis.setTickLength(0);
        final NumberAxis yAxis = new NumberAxis();

        table = createTableView();
        table.setItems(FXCollections.observableList(PointsHolder.getInstance().getPoints()));

        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setStyle("-fx-padding: 0;");
        lineChart.setLegendVisible(false);
        lineChart.setTitle("Stock Monitoring, 2010");
        updateSeries();

        HBox hb = new HBox();
        final TextField addXName = new TextField();
        addXName.setPromptText("Parameter");
        addXName.prefWidthProperty().bind(table.widthProperty().divide(3));
        final TextField addYName = new TextField();
        addYName.prefWidthProperty().bind(table.widthProperty().divide(3));
        addYName.setPromptText("Value");

        final Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            table.getItems().add(new Point(
                    Double.parseDouble(addXName.getText()),
                    Double.parseDouble(addYName.getText())));
            addXName.clear();
            addYName.clear();
            updateSeries();
        });
        addButton.prefWidthProperty().bind(table.widthProperty().divide(3));
        hb.getChildren().addAll(addXName, addYName, addButton);
        hb.setSpacing(5);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(lineChart, table, hb);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setMinWidth(500);

        HBox layout = new HBox();
        layout.getChildren().add(vbox);
        HBox.setHgrow(vbox, Priority.ALWAYS);

        Scene scene = new Scene(layout, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

    private Series<Number, Number> createSeries(ObservableList<Point> data) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (Point point : data) {
            series.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
        }
        return series;
    }

    private TableView<Point> createTableView() {
        TableView<Point> table = new TableView<>();
        table.setEditable(true);

        TableColumn parametersColumn = new TableColumn("Parameter");
        parametersColumn.prefWidthProperty().bind(table.widthProperty().divide(2));
        parametersColumn.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        parametersColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        parametersColumn.setOnEditCancel(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                System.err.println("edit canceled");
            }
        });
        parametersColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Point, Number>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Point, Number> event) {
                int rowId = event.getTablePosition().getRow();
                table.getItems().get(rowId).setX(event.getNewValue());
                updateSeries();
            }
        });

        TableColumn valuesColumn = new TableColumn<>("Value");
        valuesColumn.prefWidthProperty().bind(table.widthProperty().divide(2));
        valuesColumn.setCellValueFactory(new PropertyValueFactory<>("y"));

        table.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.DELETE) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    table.getItems().remove(table.getSelectionModel().getSelectedItem());
                    updateSeries();
                }
            }
        });

        table.getColumns().addAll(parametersColumn, valuesColumn);

        return table;
    }

    private void updateSeries() {
        lineChart.getData().clear();
        lineChart.getData().add(createSeries(table.getItems()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}