package com.saqeeb.random;
/*
 
 when n=3, O/P :: -*-
                  ***
                  -*-
                  
 when n=5, O/P :: --*--
                  -***-
                  *****
                  -***-
                  --*--
                  
 when n=7, O/P :: ---*---
 				  --***--
 				  -*****-
 				  *******
 				  -*****-
 				  --***--
 				  ---*---
 				  
 n must always be odd
 */
public class DiamondPattern {
	private static final char DIAMOND_SYMBOL  = '$';
	private static final char OUTLINER_SYMBOL = '-';
	
	public static void main(String[] args) {
		int n = 7;
		draUpper(n);
		drawLower(n);
	}
	
	private static void draUpper(int n) {
		int stars = 1;
		
		for(int i=0; stars <= n; i++) {
				int slashes = (n - stars);
				for(int j=slashes/2; j>0; j--) {
					System.out.print(OUTLINER_SYMBOL);
				}
				for(int j=0; j<stars; j++) {
					System.out.print(DIAMOND_SYMBOL);
				}
				for(int j=slashes/2; j>0; j--) {
					System.out.print(OUTLINER_SYMBOL);
				}
				stars += 2;
				System.out.println();
		}
	}
	
	private static void drawLower(int n) {
		int stars = n-2;
		for(int i=0; stars>0; i++) {
			int slashes = n-stars;
			for(int j=slashes/2; j>0; j--) {
				System.out.print(OUTLINER_SYMBOL);
			}
			for(int j=0; j<stars; j++) {
				System.out.print(DIAMOND_SYMBOL);
			}
			for(int j=slashes/2; j>0; j--) {
				System.out.print(OUTLINER_SYMBOL);
			}
			stars -=2;
			System.out.println();
		}
	}
	
}
