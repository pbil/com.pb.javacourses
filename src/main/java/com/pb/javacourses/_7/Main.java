package com.pb.javacourses._7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {

	public static class Car implements Serializable {
		
		String model;

		int power;
		
		
		public Car(int power, String model) {
			super();
			this.power = power;
			this.model = model;
		}

		@Override
		public String toString() {
			return "Car [power=" + power + ", model=" + model + "]";
		}
		
	}
	
	public static void main(String ... args) {
		try {
			String fname = "carbytes";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			Car obj = new Car(132, "tesla");
			System.out.println(obj);
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			Object readObject = ois.readObject();
			System.out.println(readObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
