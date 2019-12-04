/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etapa2projetosin142;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.*;


/**
 *
 * @author edunu
 */
class CountSemap extends Thread{

    static ArrayList<Integer> listview = new ArrayList<Integer>();
    static ArrayList<Integer> listlike = new ArrayList<Integer>();
    static ArrayList<Integer> listdislike = new ArrayList<Integer>();
    static ArrayList<Integer> listview2 = new ArrayList<Integer>();
    static ArrayList<Integer> listlike2 = new ArrayList<Integer>();
    static ArrayList<Integer> listdislike2 = new ArrayList<Integer>();
    static int i=0, d=0, l=0, v=0;
   static Semaphore s = new Semaphore(1, true); // semÃ¡foro forte
   int id;

    CountSemap(){
        
    }
    CountSemap(int par) {
        this.id=par;
    }
            
    /**
     * @param args the command line arguments
     */
            
    
    public void lerArquivo2(){


        File file1 = new File("c:\\ArquivoVetor1\\atualizarValores.txt");
        BufferedReader reader = null;

        int numero;

        try{
            
            try {

                reader = new BufferedReader(new FileReader(file1));
                int posicao;
                int posicao1;
                String Ax;
                String Ax1;
                String Ax2;
                String Linha;
                int codigo;
                int codigo1;
                int codigo2;
                        
                        
                int w=0;
                while((Linha = reader.readLine())!= null){
                    posicao = Linha.indexOf(" ");
                    Ax = Linha.substring(0,posicao);
                    codigo = new Integer(Ax); 
                    listview.add(codigo);
                    Linha = Linha.substring(posicao +1);
                    posicao1 = Linha.indexOf(" ");
                    Ax1 = Linha.substring(0,posicao1);
                    codigo1 = new Integer(Ax1);                       
                    listlike.add(codigo1);                        
                    Ax1 = Linha.substring(posicao1 + 1);
                    codigo2 = new Integer(Ax1);                       
                    listdislike.add(codigo2);
                    w++;                           
                    }
 
                } catch (Exception t) {
                    
                    t.printStackTrace();
                    t.printStackTrace();
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    }catch (Exception t) {
                        
                    }
                }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
    public void lerArquivo(){


        File file = new File("c:\\ArquivoVetor1\\diminuirValores.txt");
        BufferedReader reader = null;

        int numero;

        try{
            
            try {

                reader = new BufferedReader(new FileReader(file));
                int posicao;
                int posicao1;
                String Ax;
                String Ax1;
                String Ax2;
                String Linha;
                int codigo;
                int codigo1;
                int codigo2;
                        
                        
                int w=0;
                while((Linha = reader.readLine())!= null){
                    posicao = Linha.indexOf(" ");
                    Ax = Linha.substring(0,posicao);
                    codigo = new Integer(Ax); 
                    listview2.add(codigo);
                    Linha = Linha.substring(posicao +1);
                    posicao1 = Linha.indexOf(" ");
                    Ax1 = Linha.substring(0,posicao1);
                    codigo1 = new Integer(Ax1);                       
                    listlike2.add(codigo1);                        
                    Ax1 = Linha.substring(posicao1 + 1);
                    codigo2 = new Integer(Ax1);                       
                    listdislike2.add(codigo2);
                    w++;                           
                    }
                } catch (Exception t) {
                    
                    t.printStackTrace();
                    t.printStackTrace();
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    }catch (Exception t) {
                        
                    }
                }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }

    public void run(){
        int aux,aux2;
        try{
            while(i<1000){
            s.acquire(1);
            
            aux = listview.get(i);            
            v=v+aux;         
            aux = listlike.get(i);
            l=l+aux;
            aux = listdislike.get(i);
            d=d+aux;
            
            
            aux = listview2.get(i);
            v=v-aux;            
            aux = listlike2.get(i);
            l=l-aux;
            aux = listdislike2.get(i);
            d=d-aux;
            
            
            i++;
            s.release(1);
            }

        }catch(Exception e){
            
        }
    }
    public int getViews(){
        return v;
    }
    public int getLike(){
        return l;
    }
    public int getDislike(){
        return d;
    }
    public void semafaro(){
        lerArquivo2();
        lerArquivo();
        CountSemap a = new CountSemap(1);
        CountSemap b = new CountSemap(2);
        CountSemap c = new CountSemap(3);
        CountSemap d = new CountSemap(4);
        CountSemap e = new CountSemap(5);
        CountSemap f = new CountSemap(6);
        CountSemap g = new CountSemap(7);
        CountSemap h = new CountSemap(8);
        CountSemap i = new CountSemap(9);
        CountSemap j = new CountSemap(10);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
        g.start();
        h.start();
        i.start();
        j.start();
        
        
    }
} 
        

    
    

