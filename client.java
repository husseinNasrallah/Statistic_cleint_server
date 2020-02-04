//name:hussein nasrallah
//id:201802472
//client that sends numbers to the statistic server to make it computation and then prints the answers
package project;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client 
{	
	public static void main(String[] args) throws Exception {
		//specify the socket and the scanners
		try (var Socket = new Socket("localhost", 6000)) {
			var scanner = new Scanner(System.in);
			var scanner2 = new Scanner(System.in);
			var in = new Scanner(Socket.getInputStream());
			var out = new PrintWriter(Socket.getOutputStream(), true);
			int menu;
			String number;
			String cmd="";
			int keep=0;
			//menu
			while(true) {
				System.out.println("press 0 for absolute");
				System.out.println("press 1 for average");
				System.out.println("press 2 for count");
				System.out.println("press 3 for max");
				System.out.println("press 4 for median");
				System.out.println("press 5 for min");
				System.out.println("press 6 for mode");
				System.out.println("press 7 for product");
				System.out.println("press 8 for square root");
				System.out.println("press 9 for sum");
				System.out.println("press 10 for standared deviation");
				System.out.println("press 11 for factorial");
				System.out.println("press 12 for fibonacci");
				System.out.println("press 13 for sumation series");
				System.out.println("press 14 for combination");
				System.out.println("press 15 to exit");
				menu=scanner.nextInt();
				//exit menu
				if(menu==15) {
					break;
				}
				//Absolute menu
				else if(menu==0) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="abs,";
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an absolute for ");
						number=scanner.next();
						cmd="abs,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//avarage menu
				else if(menu==1) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="avarage,";
						for(int i=0;i<=9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an avarage for ");
						number=scanner2.nextLine();
						cmd="avarage,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//count menu
				else if(menu==2) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="count,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do a count for ");
						number=scanner2.nextLine();
						cmd="count,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//max menu
				else if(menu==3) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="max,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an max for ");
						number=scanner2.nextLine();
						cmd="max,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//median menu
				else if(menu==4) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="median,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an median for ");
						number=scanner2.nextLine();
						cmd="median,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//min menu
				else if(menu==5) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="min,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an min for ");
						number=scanner2.nextLine();
						cmd="min,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//mode menu
				else if(menu==6) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="mode,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an mode for ");
						number=scanner2.nextLine();
						cmd="mode,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//product menu
				else if(menu==7) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="product,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an product for ");
						number=scanner2.nextLine();
						cmd="product,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//square root menu
				else if(menu==8) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="squareroot,";
						cmd=cmd+(int)(Math.random()*10+1);

					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an square root for ");
						number=scanner2.next();
						cmd="squareroot,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//sum menu
				else if(menu==9) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="sum,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do a sum for ");
						number=scanner2.nextLine();
						cmd="sum,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//Standard deviation menu
				else if(menu==10) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="standareddeviation,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an standared deviation for ");
						number=scanner2.nextLine();
						cmd="standareddeviation,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//
				//factorial function
				else if(menu==11) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random number between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="factorial,";
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an factorial for ");
						number=scanner.next();
						cmd="factorial,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//
				//fibonacci function
				else if(menu==12) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random number between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="fibonacci,";
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an fibonacci for ");
						number=scanner.next();
						cmd="fibonacci,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}

				}
				//sumation series function
				else if(menu==13) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random number between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="sumationseries,";
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an sumation series for ");
						number=scanner.next();
						cmd="sumationseries,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}

				}
				//combination function
				else if(menu==14) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random number between 1 and 10");
					numbermenu=scanner.nextInt();
					int variable=0;
					int variable2=(int)(Math.random()*10+1);
					//random numbers
					if(numbermenu==0) {
						variable=(int)(Math.random()*10+1);
						cmd="combination,";
						cmd=cmd+variable+" ";
						while(true) {
							if(variable2<=variable) {
								break;
							}
							else {
								variable2=(int)(Math.random()*10+1);
							}
						}
						cmd=cmd+variable2;
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an combination on ");
						number=scanner.next();
						cmd="combination,";
						cmd=cmd+number+" ";
						System.out.println("enter the number you want to do an combination by ");
						number=scanner.next();
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}

				}
				//everything else menu
				else {
					System.out.println("we have no such menu");
				}
				//when done from the action	
			}
			System.out.println("thank you for using our service");
		}


	}

}