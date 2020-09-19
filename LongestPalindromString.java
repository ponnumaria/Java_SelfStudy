package com.myworks.java.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalindromString {
	public static void main(String...args) {
		Scanner scanner= new Scanner(System.in);
		String input=scanner.nextLine();
		String subStr,firstPart;
		StringBuffer secondPart;
		List<String> subStringList=new ArrayList<>();
		int i,j,k=0;
		for(i=0;i<input.length()-1;i++) {
			for(j=i;j<input.length();j++) {
				subStr=input.substring(i,i==j?j+2:j+1);
				//System.out.println("subStr:"+subStr);

				firstPart=subStr.substring(0, subStr.length()/2);
				secondPart=new StringBuffer();
				if(subStr.length()%2==0) {
					secondPart=new StringBuffer(subStr.substring(subStr.length()/2, subStr.length()));
					secondPart=secondPart.reverse();
				}
				else {
					secondPart=new StringBuffer(subStr.substring((subStr.length()/2)+1, subStr.length()));
					secondPart=secondPart.reverse();
				}
				if(firstPart.equals(secondPart.toString()))
				{
					subStringList.add(subStr);
				}
			}
		}
		String longest="";
		int size=0;
		for(String palin:subStringList) {
			if(size<palin.length())
			{
				size=palin.length();
				longest=palin;
			}
		}
		System.out.println(longest);
	}
}
