package dataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import businessLayer.Restaurant;

public class RestaurantSerializator {
	public static void serialize(Restaurant r) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Restaurant.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(r);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in Restaurant.ser\n");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static Restaurant deserialize(String inputFile) {
		Restaurant restaurant = null;
		try {
			FileInputStream fileIn = new FileInputStream(inputFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			restaurant = (Restaurant) in.readObject();
			in.close();
			fileIn.close();
			System.out.println(restaurant);
			return restaurant;
		} catch (IOException i) {
			System.out.println(i);
			restaurant = new Restaurant();
			serialize(restaurant);
			return restaurant;
		} catch (ClassNotFoundException c) {

			System.out.println("Restaurant class not found\n");
			c.printStackTrace();
			return restaurant = new Restaurant();
		}
	}
}
