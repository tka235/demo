package com.justsystems.sample;

public class FizzBuzz {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (i+1 % 3 = 0) {
				System.out.println("Fizz");
			} else if(i+1 % 5 == 0) {
				System.out.println("Buzz");
			} else if(i+1 % 3 == 0 & i+1 % 5 == 0) {
				System.out.println("FizzBuzz");
			} else {
				System.out.println(i+1);
			}
		}
	}
}