package com.myworks.java.hackerearth;

import java.util.Scanner;

public class FavouriteCandy {
	public static void main(String...args) {
	 Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	 String[] first= scanner.nextLine().split(" ");
	 Integer typesOfCandy=Integer.parseInt(first[0]);
	 Integer limitPerDay=Integer.parseInt(first[1]);
	 String[] numOfEachTypeStr= scanner.nextLine().split(" ");
	 int[] numOfEachType=new int[typesOfCandy];
	 String[] priorityOfEachTypeStr= scanner.nextLine().split(" ");
	 int[] priorityOfEachType=new int[typesOfCandy];

	 for(int i=0;i<typesOfCandy;i++) {
		 numOfEachType[i]=Integer.parseInt(numOfEachTypeStr[i]);
		 priorityOfEachType[i]=Integer.parseInt(priorityOfEachTypeStr[i]);
	 }
	 int temp;
	 for(int i=0;i<typesOfCandy;i++) {
		 for(int j=0;j<typesOfCandy-1-i;j++) {
			if(priorityOfEachType[j]>priorityOfEachType[j+1]) {
				temp=priorityOfEachType[j];
				priorityOfEachType[j]=priorityOfEachType[j+1];
				priorityOfEachType[j+1]=temp;
				
				temp=numOfEachType[j];
				numOfEachType[j]=numOfEachType[j+1];
				numOfEachType[j+1]=temp;
			}
		 }
	 }
	 int candyType,day;
	 int noOfQueries= Integer.parseInt(scanner.nextLine());
	 String[] queries = new String[noOfQueries];
	 for(int i=0;i<noOfQueries;i++) {
		 queries[i]= scanner.nextLine();
	 }
	 for(int i=0;i<queries.length;i++) {
		 int candySize=0;
		 String[] queryStr= queries[i].split(" ");
		 candyType=Integer.parseInt(queryStr[0]);
		 day=Integer.parseInt(queryStr[1]);
		 for(int j=candyType;j<priorityOfEachType[priorityOfEachType.length-1];j++) {
			 candySize= candySize+numOfEachType[j];
		 }
		 int beginningDay=(candySize/limitPerDay)+1;
		 int endingDay=candySize+numOfEachType[candyType-1];
		 if(day>=beginningDay&&day<=endingDay) {
			 System.out.println("YES");
		 }
		 else
		 {
			 System.out.println("NO");
		 }
	 }
	 scanner.close();
	}
}
