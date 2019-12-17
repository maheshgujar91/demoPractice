package com.crud_operation_hibernatedemo;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	
		Operation o=new Operation();
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("Enter Your Choice:-\n1.To Create new Student Data press 'CTRL+F11'\n2.View Existing Student Data\n3.Update Existing Student Data\n4.Delete Student Data of your Choice");
		int ch=sc.nextInt();
		System.out.println("Cloned Git is Here");
		switch(ch){
		case 1:
			o.a1();
			System.out.println("Congratulations.....!\nNew data Inserted into Student Table");
			
			break;
		case 2:
			o.v1();
			break;
		case 3:
			o.u1();
			System.out.println("Congratulations.....! Entered Details are updated Successfully");
			break;
		case 4:
			o.d1();
			System.out.println("Congratulation.....! As per Your request,Data is successfully deleted from Database");
            break;
            default:
            System.out.println("!!!!*WARNING*!!!!\n!!!!*WARNING*!!!!\n!!!!*WARNING*!!!!\nPlease Enter Valid Choice");
		    break;
		}
		}
	}
}
