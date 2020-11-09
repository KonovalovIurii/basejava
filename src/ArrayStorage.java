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
    }

    void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size++;
        }
        System.out.println("Not enough space in the array");
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (i == size - 1) {
                    //удаляемый элемент является последним
                    storage[size - 1] = null;
                } else {
                    //переносим последний элемент в удаляемый и затираем последний
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }
}
