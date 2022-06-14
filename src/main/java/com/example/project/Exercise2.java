package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
         if(str == null) {
        	return false;
        }
        
        //Leer letra por letra, y guardar los abiertos
        for (int i = 0; i < str.length(); i++) {
        	////¿Es abierto o es una letra? Guardarlo
            if (str.charAt(i) != ')') 
                stack.push(str.charAt(i));
            
            //¿Es cerrado? Verificar si el ultimo elemento de la pila es abierto           
            else {
                //Si encontramos un parentesis abierto al iniciar, 
            	  //nos damos cuenta de que ya está duplicado
                if (stack.top() == '(') 
                    return true;

                //Buscaremos el parentesis abierto, para eso iremos eliminando
                  //las expresiones que estan en la pila hasta encontrarlo
                while (stack.top() != '(') 
                    stack.pop();

                //Una vez encontrado el parentesis abierto, lo eliminamos
                stack.pop(); 
            }
        }
        //Luego del recorrido damos con que la expresión no tiene ningún duplicado
        return false;
    }
}
