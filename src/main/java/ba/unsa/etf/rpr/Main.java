package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static boolean isNum(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println("Unesite brojeve:");
        Scanner in=new Scanner(System.in);
        String s=new String();
        List<Integer> lista=new ArrayList<>();
        do
        {
            s=in.nextLine();
            if(s.equals("stop")) {
                break;
            }
            if(isNum(s)) {
                lista.add(Integer.parseInt(s));
            } else {
                System.out.println("Upisite validan broj");
            }
        }while(!s.equals("stop"));

        int minimalni=lista.get(0);
        for(int i=1;i<lista.size();i++){
            if(lista.get(i)<minimalni)minimalni=lista.get(i);
        }
        System.out.println("Minimalna vrijednost: "+minimalni);

        int maksimalni=lista.get(0);
        for(int i=1;i<lista.size();i++){
            if(lista.get(i)>maksimalni)maksimalni=lista.get(i);
        }
        System.out.println("Maksimalna vrijednost: "+maksimalni);

        double mean;
        for(int i=0;i<lista.size();i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(i) > lista.get(j)) {
                    int pom = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, pom);
                }
            }
        }
        if(lista.size()%2==0)
            mean = (lista.get(lista.size()/2-1)+lista.get(lista.size()/2))/2;
        else mean = (lista.get(lista.size()/2));
        System.out.println("Mean vrijednost: "+mean);
        double suma=0;
        for (Integer integer : lista)
            suma += integer;
        System.out.println("Srednja vrijednost: "+suma/lista.size());

        double suma2=0;
        double sr=suma/lista.size();
        for(int i=0;i<lista.size();i++)
            suma2+=pow(lista.get(i)-sr,2);
        System.out.println("Standardna devijascija: "+suma2/(lista.size()-1));

    }
}
