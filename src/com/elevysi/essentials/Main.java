package com.elevysi.essentials;

import java.util.LinkedList;

public class Main {

		public static void main(String[] args){
//			isUniqueChar("elvis hatungimana");
			System.out.println((int) 'a');
		}
		
		static void removeDups(LinkedList<String> n){
		}
		
		static boolean isUniqueChar(String s){
			if(s.length() > 128) return false;
			boolean[] chars = new boolean[128];
			for(int i = 0; i < s.length(); i ++){
				char ith = s.charAt(i);
				System.out.print("The character at "+i+" is "+ith+"\n");
				if(chars[ith]) return false; //there was already this char at this place
				chars[ith] = true;
			}
			System.out.print(chars['e']);
			return true;
		}
		
		static boolean isUniqueCharVector(String str){
			int checker = 0;
			for(int i = 0; i < str.length(); i ++){
				int val = str.charAt(i) - 'a';
				if((checker & (1 << val)) > 0){
					return false;
				}
				checker |= (1 << val);
			}
			
			return true;
		}
		
		static boolean isPermutation(String st1, String st2){
			if(st1.length() != st2.length()) return false;
			//Sort them
			String sorted1 = sortedChars(st1);
			String sorted2 = sortedChars(st2);
			return sorted1.equals(sorted2);
		}
		
		static String sortedChars(String s){
			char[] sChars = s.toCharArray();
			java.util.Arrays.sort(sChars);
			return sChars.toString();
		}
		
		static boolean isPermutationCount(String st1, String st2){
			if(st1.length() != st2.length()) return false;
			int[] stringChars = new int[128];  //Considering we are using the ASCI alphabet
			char[] s1Array = st1.toCharArray();
			for(char c: s1Array){
				stringChars[c]++;
			}
			char[] s2Array = st2.toCharArray();
			for(char c : s2Array){
				stringChars[c]--;
				if(stringChars[c] < 0) return false;
			}
			
			return true;
		}
		
		static void compareStrings(String s1, String s2){
			char[] s1Chars = s1.toCharArray();
			char[] s2Chars = s2.toCharArray();
			
			for(char c : s1Chars){
				for(char d: s2Chars){
					//comapre c with d
				}
			}
		}
		
		static boolean hasUniqueString(String s1){
			if(s1.length() > 128) return false;
			for (int i = 0; i < s1.length(); i ++){
				for (int j = i + 1; j < s1.length(); j ++){
					if(s1.charAt(i) == s1.charAt(j)) return false;
				}
			}
			
			return true;
		}
//		/https://stackoverflow.com/questions/26558741/what-does-strnewlength-0-mean/26558831
		static String replaceSpacees(String s1, int trueLength){
			//Count the number of spaces
			char[] s1Chars = s1.toCharArray();
			
			int spaceCount = 0;
			for(char c : s1Chars){
				if(c == ' '){
					spaceCount++;
				}
			}
			//Final Length is prior length + (number of spaces * 2) ; eg. 2 spaces requires 4 more spaces = 6 for the 6 char %20%20
			int finalLength = trueLength + (spaceCount * 2);
			
			//Index will be at the end of the string
			int index = finalLength;
			
			//Loop through the string starting from backwards
			for(int i = trueLength -1 ; i >= 0; i--){
				if(s1Chars[i] == ' '){
					s1Chars[index -1] = '0';
					s1Chars[index -2] = '2';
					s1Chars[index -3] = '%';
					index = index -3;
				}else{
					s1Chars[index -1] = s1Chars[i];
					index--;
				}
			}
			
			return s1Chars.toString();
		}
		
		static boolean isPalindrome(String phrase){
			/**
			 * Is Palindrome permutation if the count of letters is equal
			 * If the count for each character is even with at most one odd character count
			 */
			int countOdd = 0;
			int[] charTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];
			for(char c: phrase.toCharArray()){
				int cValue = getNumValue(c);
				if(cValue != -1){
					charTable[cValue]++;
					if(charTable[cValue]%2 == 1) countOdd++; 
					else countOdd--;
				}
				
			}
			
			return countOdd <=1;
		}
		
		//assuming it is case insensitive
		static int getNumValue(char c){
			int lower = Character.getNumericValue('a');
			int upper = Character.getNumericValue('z');
			int cValue = Character.getNumericValue('c');
			
			if(lower <= cValue && cValue <= upper){
				return cValue - lower;
			}
			
			return -1;
		}
		
		static boolean oneEditAway(String start, String end){
			if(start.length() == end.length()){
				return oneReplaceAway(start, end);
			}else if((start.length() -1) == end.length()){
				return oneInsertAway(end, start); //Removed from start to get end
			}else if((start.length() +1) == end.length()){
				return oneInsertAway(start, end); //Insert from start to get end
			}
			
			return false;
		}

		static boolean oneReplaceAway(String s1, String s2){
			//Must be similar except one
			boolean foundDifferent = false;
			for (int i = 0; i < s1.length(); i++){
				if(s1.charAt(i) != s2.charAt(i)){
					if(foundDifferent) return false;
					foundDifferent = true;
				}
			}
			return true;
		}

		static boolean oneInsertAway(String small, String bigger){
			int s = 0, b = 0;
			while(s < small.length() && b < bigger.length()){
				
				if(small.charAt(s) != bigger.charAt(b)){
					//if b is already ahead of s, then there was already one shift identified, return false
					if(s != b){
						return false;
					}
					b++;
				}else{
					s++;
					b++;
				}
				
			}
			return true;
		}
		
		static String compressed(String s){
			StringBuilder sb = new StringBuilder();
			int countCons = 0;
			for (int i = 0; i < s.length(); i ++){
				countCons++;  //Each has at least one
				if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i +1)){
					sb.append(s.charAt(i));
					sb.append(countCons);
					countCons = 0;
				}
			}
			
			return sb.length() > s.length()? s : sb.toString();
		}
		
		static boolean isRotation(String original, String rotated){
			int length = original.length();
			if(length == rotated.length() && length > 0){
				String concatenated = original+original;
//				return isSubstring(original+original, rotated);
				return concatenated.toLowerCase().contains(rotated.toLowerCase());
			}
			
			return false;
		}
		
}
