package game;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Skeleton {
    /**
     * A tarolo tárolja a dolgok referenciáját és a nevűket értékként.
     */
    private Map<Object ,String> tarolo;
    /**
     * Saját magáról példány <<Singleton>>
     */
    private static Skeleton skeleton = new Skeleton();
    /**
     * Életciklus aktuális szintje.
     */
    private int level=1;

    /**
     * Konstruktor, HashMap inicializálása.
     */
    private Skeleton(){
        tarolo = new HashMap<Object, String>();
    }

    /**
     * A magából készült példány elérése.
     * @return A saját magából létrehozott példány.
     */
    public static Skeleton getInstance(){
        return skeleton;
    }

    /**
     * A hívásokat konzolra kiíró függvény.
     * @param caller A hívó fél.
     * @param fv A hívott függvény.
     * @param receiver Akin hívják a függvényt.
     */
    public void Call(Object caller, Object receiver, String fv){
        try{
          if(tarolo.get(caller)==null)throw new Exception("The caller object has not found");
          else if(tarolo.get(receiver)==null)throw new Exception("The Receiver object has not found");
          else {
              for(int i=0;i<level;i++)System.out.println(">");
              System.out.println(tarolo.get(caller)+" meghivja"+ tarolo.get(receiver)+" " + fv+" metodusat");
              level++;
          }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Kiírja ki tér vissza.
     * @param returner Aki visszatér.
     */
    public void Return(Object returner){
        try{
            if(tarolo.get(returner)==null)throw new Exception("The returner object has not found");
            else {
                System.out.println("< "+tarolo.get(returner)+" visszater");
                level--;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * A kérdésre adott igen vagy nem válasz.
     * @param q Kérdés.
     * @return Kérdésre adott válasz kiértékelve.
     */
    public Boolean Option(String q){
        System.out.println(q);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true){
                String s = br.readLine();
                if(s.equals("y"))return true;
                if(s.equals(("n")))return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * tarolo feltöltése egy elemmel.
     * @param a dolog referenciája
     * @param b név
     */
    public void Add(Object a, String b){
        tarolo.put(a,b);
    }

    /**
     * tarolo teljes kiürítése
     */
    public void Clear(){
        tarolo.clear();
    }

}
