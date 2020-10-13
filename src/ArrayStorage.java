import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        for (Object resume : storage) {
            if (resume != null) {
                storage[i] = null;

            } else {
                return;
            }
            i++;
        }
        return;
    }

    void save(Resume r) {
        int i = 0;
        for (Object resume : storage) {
            if (resume == null) {
                storage[i] = r;
                return;
            }
            i++;
        }
        // Т.к сигнатуры методов менять нельзя выведем простое сообщение в консоль
        //throw new Exception("Not enough space in the array");
        System.out.println("Not enough space in the array");
        return;
    }

    Resume get(String uuid) {
        int i = 0;

        for (Object resume : storage) {
            if (resume != null) {
                if (storage[i].uuid.equals(uuid)) {
                    return storage[i];

                }
            } else {
                break;
            }
            i++;
        }
        System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        List<Resume> list = new ArrayList<>(Arrays.asList(storage));
        list.remove(uuid);
        storage = list.toArray(new Resume[10000]);
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
         for (Object resume : storage) {
            if (resume != null) {
                return storage;

           } else {
                return storage;
            }

        }
        return new Resume[0];
    }

    int size() {
        return 0;
    }
}
