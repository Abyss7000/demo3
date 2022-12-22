package Mypack.ComputerParts;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ButtonCellFactory<T> implements Callback<TableColumn<T, Void>, TableCell<T, Void>> {
    private final Callback<T, Void> callback;

    public ButtonCellFactory(Callback<T, Void> callback) {
        this.callback = callback;
    }

    @Override
    public TableCell<T, Void> call(final TableColumn<T, Void> param) {
        final TableCell<T, Void> cell = new TableCell<T, Void>() {
            private final Button btn = new Button("Buy");

            {
                btn.setOnAction((ActionEvent event) -> {
                    T object = getTableView().getItems().get(getIndex());
                    callback.call(object);
                });
            }

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        };
        return cell;
    }
}