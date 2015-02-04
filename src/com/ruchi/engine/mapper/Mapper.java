package com.ruchi.engine.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ruchi.engine.database.DataStore;
import com.ruchi.hibernate.model.DAO.FoodDao;
import com.ruchi.hibernate.model.DAO.FoodInitDao;
import com.ruchi.hibernate.model.DAO.RestaurantDao;
import com.ruchi.hibernate.model.DAO.ReviewDao;
import com.ruchi.hibernate.model.DAO.ReviewTrainDao;

public class Mapper {
	static DataStore dataStore;

	static {
		dataStore = new DataStore();
	}

	public static ArrayList<String> getRestaurantReviewsByRestName(String res_name) {
		ArrayList<String> rest_reviews = new ArrayList<String>();
		List<ReviewDao> daos = dataStore.getReviewsByRestName(res_name);
		for (ReviewDao r : daos) {
			rest_reviews.add(r.getReview());
		}

		return rest_reviews;
	}
	
	public static ArrayList<String[]> getRestaurantReviewsAndIdsByRestName(String res_name) {
		ArrayList<String[]> rest_reviews = new ArrayList<String[]>();
		List<ReviewDao> daos = dataStore.getReviewsByRestName(res_name);
		String[] review=new String[2];
		for (ReviewDao r : daos) {
			review[0]=r.getReview_id();
			review[1]=r.getReview();
			rest_reviews.add(review);
		}
		return rest_reviews;
	}

	public static ArrayList<String> getRestaurantReviewsByRestNameTrain(String res_name) {
		ArrayList<String> rest_reviews = new ArrayList<String>();
		List<ReviewTrainDao> daos = dataStore
				.getReviewsTrainByRestName(res_name);
		for (ReviewTrainDao r : daos) {
			rest_reviews.add(r.getReview());
		}

		return rest_reviews;
	}
	
	public static ArrayList<String[]> getRestaurantReviewsAndIdsByRestNameTrain(String res_name) {
		ArrayList<String[]> rest_reviews = new ArrayList<String[]>();
		List<ReviewTrainDao> daos = dataStore
				.getReviewsTrainByRestName(res_name);
		String[] review=new String[2];
		for (ReviewTrainDao r : daos) {
			review[0]=r.getReview_id();
			review[1]=r.getReview();
			rest_reviews.add(review);
		}

		return rest_reviews;
	}

	public static ArrayList<String> getRestaurantNames() {
		ArrayList<String> rest_names = new ArrayList<String>();
		List<RestaurantDao> daos = dataStore.getRestaurantNames();
		for (RestaurantDao r : daos) {
			rest_names.add(r.getRest_name());
		}
		return rest_names;
	}

	public static ArrayList<String> getRestaurantIDs() {
		ArrayList<String> rest_ids = new ArrayList<String>();
		List<RestaurantDao> daos = dataStore.getRestaurantIds();
		for (RestaurantDao r : daos) {
			rest_ids.add(r.getRest_id());
		}
		return rest_ids;
	}

	public static ArrayList<String> getRestaurantReviewsByRestId(String rest_id) {
		ArrayList<String> rest_reviews = new ArrayList<String>();
		List<ReviewDao> daos = dataStore.getReviewsByRestId(rest_id);
		for (ReviewDao r : daos) {
			rest_reviews.add(r.getReview());
		}
		return rest_reviews;
	}
	
	public static ArrayList<String[]> getRestaurantReviewsAndIdsByRestId(String rest_id) {
		ArrayList<String[]> rest_reviews = new ArrayList<String[]>();
		List<ReviewDao> daos = dataStore.getReviewsByRestId(rest_id);
		String[] review=new String[2];
		for (ReviewDao r : daos) {
			review[0]=r.getReview_id();
			review[1]=r.getReview();
			rest_reviews.add(review);
		}
		return rest_reviews;
	}

	public static ArrayList<String[]> getRestaurantReviewsByRestIdTrain(String rest_id) {
		ArrayList<String[]> rest_reviews = new ArrayList<String[]>();
		List<ReviewTrainDao> daos = dataStore.getReviewsTrainByRestId(rest_id);
		String[] review=new String[2];
		for (ReviewTrainDao r : daos) {
			review[0]=r.getReview_id();
			review[1]=r.getReview();
			rest_reviews.add(review);
		}
		return rest_reviews;
	}
	
	public static ArrayList<String> getRestaurantReviewsAndIdsByRestIdTrain(String rest_id) {
		ArrayList<String> rest_reviews = new ArrayList<String>();
		List<ReviewTrainDao> daos = dataStore.getReviewsTrainByRestId(rest_id);
		for (ReviewTrainDao r : daos) {
			rest_reviews.add(r.getReview());
		}
		return rest_reviews;
	}

	public static void removeFood(String food_name) {
		dataStore.removeFoodName(food_name);
	}

	public static void getFoodNames(ArrayList<String> dictionary) {
		List<FoodDao> daos = dataStore.getFoodNames();
		for (FoodDao r : daos) {
			dictionary.add(r.getFood_name());
		}
	}

	public static void insertFood(String food_name) {
		dataStore.insertFood(food_name);
	}

	public static void insertFoodInit(String food_name) {
		dataStore.insertFoodInit(food_name);
	}

	public static void removeFoodInit(String food_name) {
		dataStore.removeFoodInitName(food_name);
	}

	public static void getFoodInitNames(ArrayList<String> dictionary) {
		List<FoodInitDao> daos = dataStore.getFoodInitNames();
		for (FoodInitDao r : daos) {
			dictionary.add(r.getFood_name());
		}
	}

	public static boolean insertReviewFood(String review_id, String food_id,
			float rating) {
		return dataStore.insertReviewFood(review_id, food_id, rating);
	}

	public boolean insertRestFood(String rest_id, String food_id, float rating) {
		return dataStore.insertRestFood(rest_id, food_id, rating);
	}

}
