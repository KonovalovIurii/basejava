import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                storage[i] = null;

            }
        }
        return;
    }

    void save(Resume r) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
        // Т.к сигнатуры методов менять нельзя выведем простое сообщение в консоль
        //throw new Exception("Not enough space in the array");
        System.out.println("Not enough space in the array");
        return;
    }

    Resume get(String uuid) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                return storage[i];
            } else {
                break;
            }
        }
        System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        int j = this.size();
        for (int i = 0; i <= j; i++) {
            if (storage[i] != null) {
                if (storage[i].toString() == uuid) {
                    //переносим последний элемент в удаляемый и затираем последний
                    storage[i] = storage[j];
                    storage[j] = null;
                }
            } else {
                break;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (storage[0] != null) {
            return storage;

        } else {
            return new Resume[0];
        }
    }

    int size() {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                return i--;
            }
        }
        return 0;
    }
}
