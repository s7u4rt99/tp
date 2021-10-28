package seedu.address.ui.classtab;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.ui.StudentListViewCell;
import seedu.address.ui.UiPart;

import java.util.logging.Logger;

public class StudentClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/StudentClassListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TuitionClassPanel.class);

    @FXML
    private ListView<Student> studentListView;

    public StudentClassPanel(ObservableList<Student> studentList) {
        super(FXML);
        studentListView.setItems(studentList);
        studentListView.setCellFactory(listView -> new StudentListViewCell());
    }

    public ListView<Student> getStudentListView() {
        return studentListView;
    }
}