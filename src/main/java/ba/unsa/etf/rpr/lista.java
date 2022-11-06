package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class lista {
    private List<Integer> lista=new ArrayList<>();
    public void ubaci(int a){lista.add(a);}
    public int min(){
        int minimalni=lista.get(0);
        for(int i=1;i<lista.size();i++){
            if(lista.get(i)<minimalni)minimalni=lista.get(i);
        }
        return minimalni;
    }
    public int max(){
        int maksimalni=lista.get(0);
        for(int i=1;i<lista.size();i++){
            if(lista.get(i)>maksimalni)maksimalni=lista.get(i);
        }
        return maksimalni;
    }
    public int mean()
    {
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
        {
            return (lista.get(lista.size()/2-1)+lista.get(lista.size()/2))/2;
        }
        else return (lista.get(lista.size()/2));
    }
    public float sr_vr(){
        float suma=0;
        for (Integer integer : lista) suma += integer;
        return suma/lista.size();
    }
    public float st_dev(){
        float suma=0;
        float sr=sr_vr();
        for(int i=0;i<lista.size();i++)
        {
            suma+=pow(lista.get(i)-sr,2);
        }
        return suma/(lista.size()-1);
    }
}
