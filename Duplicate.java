package com.ola;
	import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.util.*;
	import java.util.regex.Pattern;

import com.practice.Gst;

import java.util.regex.Matcher;
	//import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;
	public class Duplicate {
		public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
			// TODO Auto-generated method stub
			//Login
			System.out.println("***** Welcome To Ola *******\n***** Login ******");
			//System.out.println("Login");
			//getting mobile  number
			System.out.println("Enter the mobile number");
			Long mobile=scan.nextLong();
			String cellno=String.valueOf(mobile);
			//checking the number is valid or not
			if(cellno.length()==10) {
				System.out.println("valid");
				System.out.println("*****************************");
				
				//getting the password from the user
				System.out.println("Enter the password number");
				String password=scan.next();
				//regex function to check password
				String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&+=])(?=\\S+$).{8,20}";
				//checking password matching or not
				if(password.matches(pattern)) {
						System.out.println("valid");
						System.out.println("************************");
						System.out.println("Enter the Travel Vechile\n 1.Micro\n2.Mini\n 3.Prime");
						int vechileNumber=scan.nextInt();
						//creating the object
						Duplicate a1=new Duplicate();
						System.out.println("Enter the date of birth");
						//getting age from user
						String age=scan.next();
						//converting it to date
						LocalDate localAge=LocalDate.parse(age);
						//extracting the year
						int presentAge=localAge.getYear();
						Period period=Period.between(localAge, LocalDate.now());
						//printing the age
					//System.out.println(period.getYears());
							if(period.getYears()>=18) {
						//through the input of user usecase will work
							switch(vechileNumber) {
							case 1:
							
								double micromoney=a1.micro();
								//calculating GST
								double totalAmountForMicro=Gst.calculateGst(micromoney, 7.0);
								//validation of age
									if(period.getYears()<=60) {
										System.out.println("Total amount After calculating GST "+totalAmountForMicro);
									} else {
										totalAmountForMicro=totalAmountForMicro/2.0;
										System.out.println("Your Fare after Gst"+totalAmountForMicro);
									}
									break;        
							case 2:
								double macromoney=a1.macro();
								//calculating GST
									double totalAmountForMacro=Gst.calculateGst(macromoney, 7.0);
									//validation of age
									if(period.getYears()<60) {
									System.out.println("Your Total amount After calculating GST "+totalAmountForMacro);
									} else {
										totalAmountForMacro=totalAmountForMacro/2.0;
										System.out.println("Your Fare after Gst"+totalAmountForMacro);
									}
									break;
							case 3:
								double primemoney=a1.prime();
								//calculating GST
								double totalAmountForPrime=Gst.calculateGst(primemoney, 7.0);
								//validation of age
								if(period.getYears()<60) {
								System.out.println("Your Total amount After calculating GST "+totalAmountForPrime);
								} else {
									totalAmountForPrime=totalAmountForPrime/2.0;
									System.out.println("Your Fare after Gst"+totalAmountForPrime);
								}
								break;
							default:
								System.out.println("Enter correct number");	
								
						}
							System.out.println("****** Online Payment ************");
							System.out.println("Enter the expiery Month and year MM/YY");
							String yearMonth=scan.next();
							YearMonth ym=YearMonth.parse(yearMonth);
							int month=ym.getMonthValue();
							System.out.println(month);
				} else {
					System.out.println("You Cannot Book the Vechile");
				}
				}
				else {
					System.out.println("Not valid\n Enter Correct password");
				}	
			} else {
				System.out.println("Not Valid");
			}
			
			//To check make credict card bills
			
			
			
			
			
		}
		//calculating the gst and extracting the hour for micro
					public static double micro() {
						Scanner scan=new Scanner(System.in);
						System.out.println("You Have Selcted Micro\n Enter the Journey Time");
						String time=scan.next();
						LocalTime localTime=LocalTime.parse(time);
						int hours=localTime.getHour();
						System.out.println("Enter the kilometer you need to travel");
						double kilometer=scan.nextInt();
						//checking peak time
						if(hours>16 && hours<19) {
							System.out.println("You'r journey is in Peek Hours");
							double amount= (kilometer*10+1.5);
							return amount;
									
						} else {
						
						return kilometer*10;
		
							}
					}
					//calculating the gst and extracting the hour for macro
					public static double macro() {
						Scanner scan=new Scanner(System.in);
						System.out.println("You Have Selcted Micro\n Enter the Journey Time");
						String time=scan.next();
						LocalTime localTime=LocalTime.parse(time);
						int hours=localTime.getHour();
						System.out.println("Enter the kilometer you need to travel");
						double kilometer=scan.nextInt();
						//checking peak time
						if(hours>16 && hours<19) {
							System.out.println("You'r journey is in Peek Hours");
							double amount= (kilometer*15+1.5);
							return amount;
									
						} else {
						
						return kilometer*15;
		
							}
			
		}
					//calculating the gst and extracting the hour for prime
					public static double prime() {
						Scanner scan=new Scanner(System.in);
						System.out.println("You Have Selcted Micro\n Enter the Journey Time");
						String time=scan.next();
				
						LocalTime localTime=LocalTime.parse(time);
						int hours=localTime.getHour();
						System.out.println("Enter the kilometer you need to travel");
						double kilometer=scan.nextInt();
						//checking peak time
						if(hours>16 && hours<19) {
							System.out.println("You are journey is in Peek Hours");
							double amount= (kilometer*20+1.5);
							return amount;
									
						} else {
						
						return kilometer*20;
		
							}
			
		}
//					public static void menu() {
//						System.out.println("Enter The Correct Value");
//						System.out.println("Enter the Travel Vechile\n 1.Micro\n2.Mini\n 3.Prime");
//					}
					
					
}
