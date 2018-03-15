package game;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.HashMap;
import java.util.Map;

public class Skeleton {

    private Map<Object ,String> tarolo;

    private static Skeleton skeleton = new Skeleton();

    private Skeleton(){
        tarolo = new HashMap<Object, String>();
    }

    public static Skeleton getInstance(){
        return skeleton;
    }

    public void Call(Object caller, String fv,Object receiver){
        try{

        }catch{

        }
    }

    public Return(){

    }

    public void Add(Object a, String b){
        tarolo.put(a,b);
    }

    public void Clear(){
        tarolo.clear();
    }

}
