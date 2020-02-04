//server that calculate some statistical functions

package project;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class server {

	public static void main(String[] args) throws IOException {
		//specify the sockets and the multi thread
		try (var listener = new ServerSocket(6000)) { 
			System.out.println("The statistics server is running...");
			var pool = Executors.newFixedThreadPool(20);
			while (true) {
				pool.execute(new StatThread (listener.accept()));

			}
		}
	}
	private static class StatThread implements Runnable { 
		private Socket socket;
		StatThread (Socket socket) 
		{
			this.socket = socket; 
		}
		@Override
		public void run() {
			System.out.println("Connected: " + socket);
			try { 
				var in = new Scanner(socket.getInputStream());
				var out = new PrintWriter(socket.getOutputStream(), true);
				while (in.hasNextLine()) {
					String[] exp = in.nextLine().toString().split(",");
					String command = exp[0];
					String []values = exp[1].split(" ");
					double result=0;
					//avarage function
					if(command.equals("avarage")) {
						//calculate the avarage by summing all the numbers
						for(int i=0;i<values.length;i++) {
							result=result+Integer.parseInt(values[i]);	
						}
						//then dividing by the number of elements
						result=result/(values.length);
					}
					//abs function
					else if(command.equals("abs")) {
						//if it is already positive just take the number
						if(Integer.parseInt(values[0])>0) {
							result=Integer.parseInt(values[0]);
						}
						//if negative take the negative of the negative to become positive
						else {
							result=-Integer.parseInt((values[0]));
						}	
					}
					//Max function
					else if(command.equals("max")) {
						//check for all the numbers for the max number and pass it by
						result=Integer.parseInt(values[0]);
						for(int i=1;i<values.length;i++) {
							if(result<Integer.parseInt(values[i])) {
								result=Integer.parseInt(values[i]);
							}
						}
					}
					//min function
					else if(command.equals("min")) {
						//check in all numbers the min number and pass it by
						result=Integer.parseInt(values[0]);
						for(int i=1;i<values.length;i++) {
							if(result>Integer.parseInt(values[i])) {
								result=Integer.parseInt(values[i]);
							}
						}
					}
					//Count function
					else if(command.equals("count")) {
						//the length of the array is the amount of elemnts in it which is the count
						result=values.length;
					}
					//median function
					else if(command.equals("median")) {
						//in case even numbers of elements in array can not get exactly the middle element
						if(values.length%2==0) {
							Arrays.sort(values);
							//get the average between middle/2 floor and middle/2 top
							result=(Integer.parseInt(values[values.length/2])+Integer.parseInt(values[(values.length/2)-1]));
							result=result/2;
						}
						else {
							//sort and get the value in the middle
							Arrays.sort(values);
							result=Integer.parseInt(values[values.length/2]);
						}

					}
					//mode function
					else if(command.equals("mode")) {
						int maxrepetition=0;
						//check in the array for the most repeated element
						//if 2 elements repeated the same amount take the last one
						for(int i=0;i<values.length;i++) {
							int repetition=0;
							for(int j=0;j<values.length;j++) {
								if(values[i].equals(values[j])) {
									repetition++;
								}
							}
							if(repetition>=maxrepetition) {
								maxrepetition=repetition;
								result=Integer.parseInt(values[i]);
							}
						}

					}
					//sum function
					else if(command.equals("sum")) {
						//sum all the elements
						for(int i=0;i<values.length;i++) {
							result= Integer.parseInt(values[i])+result;
						}
					}
					//product function
					else if(command.equals("product")) {
						//go over all the elements and multiply them by each others
						result=Integer.parseInt(values[0]);
						for(int i=1;i<values.length;i++) {
							result=Integer.parseInt(values[i])*result;
						}
					}
					//square root function
					else if(command.equals("squareroot")){
						//if negative take the absolute value and then use square root
						if(Integer.parseInt(values[0])<0) {
							result=-Integer.parseInt(values[0]);
							result=Math.pow(result, 0.5);
						}
						else {
							result=Math.pow(Integer.parseInt(values[0]), 0.5);
						}
					}
					else if(command.equals("standareddeviation")){
						//calculate the mean
						double mean=0;
						for(int i=0;i<values.length;i++) {
							mean=mean+Integer.parseInt(values[i]);	
						}
						mean=mean/(values.length);
						//Summation
						for(int i=0;i<values.length;i++) {
							result=result+(Math.pow((Integer.parseInt(values[i])-mean), 2));
						}
						//divide by n
						result=result/values.length;
						//radical the answer but check if negative first
						if(result>0) {
							result=Math.pow(result,0.5);
						}
						else {
							result=-result;
							result=Math.pow(result,0.5);
						}
					}
					//factorial function
					else if(command.equals("factorial")) {
						//result=factorial(Integer.parseInt(values[0]));
						result=1;
						for(int i=1;i<=Integer.parseInt(values[0]);i++) {
							result=result*i;
						}
					}
					//fibonacci function
					else if(command.equals("fibonacci")) {
						fibArray[0]=1;
						fibArray[1]=1;
						result=fibonacci(Integer.parseInt(values[0]));  
					}
					//sumation series function
					else if(command.equals("sumationseries")) {
						for(int i=0;i<=Integer.parseInt(values[0]);i++) {
							result=result+(i*(i+1)*2);
						}
					}
					else if(command.equals("combination")) {
						result=(factorial(Integer.parseInt(values[0])))/(factorial(Integer.parseInt(values[1]))*(factorial(Integer.parseInt(values[0])-Integer.parseInt(values[1]))));
					}
					//send the answer
					out.println(result);
				}

			}
			catch(Exception e) { 
				System.out.println("Error:" + socket);
			}
			finally {
				try { socket.close(); } catch (IOException e) {}
				System.out.println("Closed: " + socket);
			}
		}

	}
	//fibonacci function used in fibonacci calculation
	public static long fibArray[]=new long[100000];
	public static long fibonacci(long n){
		long fibValue=0;
		if(n==0 ){
			return 0;
		}else if(n==1){
			return 1;
		}else if(fibArray[(int)n]!=0){
			return fibArray[(int)n];
		}else{
			fibValue=fibonacci(n-1)+fibonacci(n-2);
			fibArray[(int) n]=fibValue;
			return fibValue;
		}
	}
	//factorial function
	public static int factorial(int n) {
		int value=1;
		for(int i=1;i<=n;i++) {
			value=value*i;
		}
		return value;
	}
}
