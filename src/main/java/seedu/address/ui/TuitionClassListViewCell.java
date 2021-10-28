package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.classtab.TuitionClassCard;

/**
 * Custom {@code ListCell} that displays the graphics of a {@code TuitionClass} using a {@code TuitionClassCard}.
 */
public class TuitionClassListViewCell extends ListCell<TuitionClass> {

    private final ObservableList<Student> studentList;
    private final ListView<Student> tuitionClassListView;

    /**
     * Represents the cell displaying the tuition class.
     *
     * @param studentList The student list associated with the tuition class.
     * @param studentListView The UI associated with the tuition class.
     */
    public TuitionClassListViewCell(ObservableList<Student> studentList, ListView<Student> studentListView) {
        this.studentList = studentList;
        this.tuitionClassListView = studentListView;
    }

    @Override
    protected void updateItem(TuitionClass tuitionClass, boolean empty) {
        super.updateItem(tuitionClass, empty);

        if (empty || tuitionClass == null) {
            setGraphic(null);
            setText(null);
        } else {
            setGraphic(new TuitionClassCard(tuitionClass, getIndex() + 1, studentList, tuitionClassListView).getRoot());
        }
    }
}
