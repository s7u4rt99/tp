package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.exceptions.DuplicateStudentInClassException;

/**
 * Represents a unique list of names corresponding to the students
 * that a {@code TuitionClass} has.
 */
public class UniqueNameList implements Iterable<Name> {

    private final ArrayList<Name> internalList = new ArrayList<>();

    public UniqueNameList() {}

    /**
     * Constructs an UniqueNameList from an array of Strings.
     *
     * @param nameList The String array to convert into an UniqueNameList.
     */
    public UniqueNameList(String[] nameList) {
        for (String name : nameList) {
            internalList.add(new Name(name));
        }
    }


    /**
     * Checks to see if the name in argument is already in the NameList.
     *
     * @param toCheck Name to check.
     * @return boolean, true if name is already in list, false otherwise.
     */
    public boolean contains(Name toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    /**
     * Removes name from the list.
     *
     * @param name to be removed.
     */
    public void remove(Name name) {
        internalList.remove(name);
    }

    /**
     * Removes all names provided from the list.
     * @param names The UniqueNameList of names to be removed.
     */
    public void removeAll(UniqueNameList names) {
        for (Name name : names) {
            remove(name);
        }
    }

    /**
     * Removes all names provided from the list.
     * @param names The list of names to be removed.
     */
    public void removeAll(List<Name> names) {
        internalList.removeAll(names);
    }

    /**
     * Adds a name to the list.
     *
     * @param toAdd name to be added.
     * @throws DuplicateStudentInClassException if name is already in the list.
     */
    public void add(Name toAdd) throws DuplicateStudentInClassException {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateStudentInClassException(toAdd);
        }
        internalList.add(toAdd);
    }

    /**
     * Adds all the names in the argument into the list.
     *
     * @param names to be added in UniqueNameList form.
     */
    public void addAll(UniqueNameList names) {
        for (Name name : names) {
            if (!this.contains(name)) {
                this.add(name);
            }
        }
    }

    /**
     * Adds all the names in argument into the list.
     *
     * @param names list of names to be added.
     * @throws DuplicateStudentInClassException if there are duplicate names in list.
     */
    public void addAll(List<Name> names) throws DuplicateStudentInClassException {
        for (int i = 0; i < names.size(); i++) {
            this.add(names.get(i));
        }
    }

    public String size() {
        return String.valueOf(internalList.size());
    }

    @Override
    public Iterator<Name> iterator() {
        return internalList.iterator();
    }

    /**
     * Sorts the internal Name list in the same order as the list of students given.
     *
     * @param listToSortBy The student list to sort the name list by.
     */
    public void sortListByList(List<Student> listToSortBy) {
        Collections.sort(internalList,
                Comparator.comparing(name -> listToSortBy.stream().map(Person::getName)
                        .collect(Collectors.toList()).indexOf(name)));
    }

    /**
     * Gets the Name at the given index.
     *
     * @param zeroBasedIndex The index to retrieve the Name from.
     * @return The Name at the given index.
     */
    public Name get(int zeroBasedIndex) {
        assert (zeroBasedIndex < internalList.size());
        return internalList.get(zeroBasedIndex);
    }
}
