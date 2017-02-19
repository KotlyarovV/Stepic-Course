package Serialization;
import java.io.*;
/**
 * Created by vitaly on 11.02.17.
 */
public class Main {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            int length;
            Animal[] animals;
            Animal animal;
            length = objectInputStream.readInt();
            animals = new Animal[length];

            for (int i = 0; i < animals.length ; i ++) {
                animal = (Animal)objectInputStream.readObject();
                animals[i] = animal;
            }
            return animals;
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}