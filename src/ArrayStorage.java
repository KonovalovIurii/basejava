import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    //кол-во элементов в массиве
    Integer size = 0;

    void clear() {
        for (int i = 0; i <= size; i++) {
            storage[i] = null;
        }
        //сбросим после очистки
        size = 0;
        return;
    }

    void save(Resume r) {
        if (size < 10000) {
            storage[size] = r;
            size++;
            return;
        }
        System.out.println("Not enough space in the array");
        return;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            } else {
                break;
            }
        }
        System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (i == size -1) {
                    //удаляемый элемент является последним
                    storage[size-1] = null;
                }else {
                    //переносим последний элемент в удаляемый и затираем последний
                    storage[i] = storage[size - 1];
                    storage[size-1] = null;
                    size--;
                }
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] outstorage = new Resume[size];
        for (int i=0; i < size; i++){
           outstorage[i] =  storage[i];
        }
        return outstorage;
    }

    int size() {
        return size;
    }
}
