package arbolBinAVL;

import java.util.Iterator;

import arbolBinOrdenado.ArbolOrdenado;




public class Prueba {

	public static void main(String[] args) {
		String[] letras=new String[26];
		ArbolBinAVL<String> arbolStrings=new ArbolBinAVL<String>();
		ArbolOrdenado<String> arbolStrings2=new ArbolOrdenado<String>();
		for(int i = 0;i<letras.length;i++){
			int a = 65+i;
			String ascii=Character.toString((char)a);
			letras[i]=ascii;
			arbolStrings.agregar(ascii);
			arbolStrings2.agregar(ascii);
		}
		Iterator<String> i=arbolStrings.iterator();
		Iterator<String> it=arbolStrings2.iterator();
		while(i.hasNext()&&it.hasNext()){
			String temp=i.next();
			String temp2=it.next();
			System.out.println(temp+temp2);
		}

	}
}
