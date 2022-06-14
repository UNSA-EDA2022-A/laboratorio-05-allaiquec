package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
         MyStack<Character> stack = new LinkedListStack<>();
        
        //Si esta vacio
        if(s == null) {
        	return true;
        }
        
        //Leer letra por letra, y guardar los abiertos
        for (int i=0; i<s.length(); i++) {
        	   
        	//¿Es abierto? Guardarlo
        	if(s.charAt(i) == '(' || s.charAt(i) == '{' ||s.charAt(i) == '[') 
        		   stack.push(s.charAt(i));
        	
        	//¿Es cerrado? Verificar si el ultimo elemento de la pila es abierto
        	else {
        		//si es el primer elemento para verificar y es cerrado, pues ya esta mal
        		if(i==0) 
        			return false;
        		//Verificar si el ultimo elemento de la pila es del mismo tipo
        		else {
        			if(Tipo(s.charAt(i)) == Tipo(stack.top())) 
        				//se elimina el ultimo elemento
        				stack.pop(); 	   
        		}
        	}
        	   
        	
        	   
        }
      //Si la pila esta vacia, es correcto
       return stack.isEmpty();
        	
        
    }
    //Definir que tipo es 
    public char Tipo(char a) {
    	//parentesis (p)
    	if(a == '(' || a == ')' ) 
    		return 'p';
    	//corchete (c)
    	else if(a == '[' || a == ']')
    		return 'c';
    	// llave (l)
    	else 
    		return 'l';
    		
    }
}
