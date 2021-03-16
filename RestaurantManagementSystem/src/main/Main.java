package main;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;
import presentationLayer.RestaurantController;
import presentationLayer.RestaurantView;

public class Main {

	public static void main(String[] args) {

		Restaurant restaurant = RestaurantSerializator.deserialize(args[0]);
		RestaurantView restaurantView = new RestaurantView();
		RestaurantController restaurantController = new RestaurantController(restaurantView, restaurant);

		restaurantView.setVisible(true);
	}
}
