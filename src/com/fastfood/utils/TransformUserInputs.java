package com.fastfood.utils;

public class TransformUserInputs {
	
public String transform(String chaine) throws ArrayIndexOutOfBoundsException{
		
		String newChaine = "";
		chaine = chaine.toLowerCase();
		char[] char_table = chaine.toCharArray();
		char_table[0] = Character.toUpperCase(char_table[0]);
		
		for(int i=1; i<char_table.length; i++) {
			if(char_table[i]==' ') {
				char_table[i+1]=Character.toUpperCase(char_table[i+1]);
			}
			newChaine = new String(char_table);

		}
		return newChaine;
	}

}
