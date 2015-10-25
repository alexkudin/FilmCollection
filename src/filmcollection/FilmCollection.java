package filmcollection;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;

public class FilmCollection //extends ArrayList 
{
    public static String getString()
    {        
        String              S   = "";
        try
        {
            LineNumberReader    L = new LineNumberReader(new InputStreamReader(System.in, "CP1251"));
            S   = L.readLine();
        }
        catch (Exception ioe) 
        {
            S   = "";
        }
        return  S;
    }
    public static int getInt()
    {
        try
        {
            return Integer.parseInt(getString());
        }
        catch (Exception ie) 
        {
            return 0;
        }
    }
    
    public static void main(String[] args) throws Exception 
    {
        ArrayList<Film> List = new ArrayList<>();
        ArrayList<Janr> Janres = new ArrayList<>();
        
        int m;
        
        do
        {
            System.out.println("1) Add Film \n2) Remove Film \n3) Edit Film \n4) Print All Films  \n5) Edit Janres \n6) Save & Exit Menu ");  
            m = getInt(); 
                switch(m)
                {
                   case (1):   // Add New Film                                      

                        System.out.println("Enter Film Name : ");
                        String n  = getString();
                        System.out.println("Enter Film Year : ");
                        int y     = getInt();
                        System.out.println("Janres of Film : ");
                        Iterator I = Janres.iterator();
                        while(I.hasNext())
                        {
                            Janr x =  (Janr) I.next();
                            x.showJanr();
                        }
                        System.out.println("Enter JanrName : ");
                        String j  = getString();
                        boolean janrIsFound = false;
                        while(janrIsFound == false)
                        {
                            while(I.hasNext())
                            {
                                Janr x =  (Janr) I.next();
                                if(x.getJanr() == j)
                                {
                                    janrIsFound = true;
                                    try
                                    {
                                        List.add(new Film(n,y,j));                                        
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Error creating object Film : " + e.getMessage());
                                    }                                    
                                }                                                        
                            }
                            
                            Janres.add(new Janr(j));
                            List.add(new Film(n,y,j));
                            janrIsFound = true;
                            try
                            {
                                List.add(new Film(n,y,j));                                        
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error creating object Film : " + e.getMessage());
                            }     
                        }
                                               
                   break;


//                   case (2):   // Remove human  
//                       
//                        System.out.println("Enter the index of Human Whom you want to Remove : ");
//                        ListFromFile.Editedlist();
//                        int re = getInt(); 
//                        ListFromFile.remove(re-1);
//
//                        System.out.println("New List of Humans : ");
//                        ListFromFile.Editedlist();
//                        ListFromFile.writeFile();
//                   break;
//
//                   case (3):   // Edit profile                      
//
//                        int exchange;
//                        ListFromFile.Editedlist();
//                        do
//                            {      
//                                System.out.println ("Enter the index of Human Whom you want to Edit :  ");
//                                exchange = getInt();
//                            }
//                        while (exchange < 0  &&  exchange > ListFromFile.size());  
//
//                        Human old = ListFromFile.get(exchange-1);                                // Save Old Profile
//                        ListFromFile.remove(exchange-1);                                             // Remove Old profile
//
//                        System.out.println ("enter Name : ");
//                        String nameEx = getString();
//                        System.out.println("enter Family : ");
//                        String famEx = getString();
//                        System.out.println ("enter Age : ");
//                        int ageEx = getInt();
//                        System.out.println ("enter Position : ");
//                        int posEx = getInt();
//
//                        try
//                            {
//                                Human ex = new Human (nameEx, famEx, ageEx, posEx);    
//                                ListFromFile.add(exchange-1, ex);                                    // Add New Edited Profile
//                            }
//                        catch(Exception e)
//                            {
//                                System.out.println("Error : " + e.getMessage());
//                                ListFromFile.add(exchange-1, old);                                  // return Old Profile if Exception 
//                            }            
//
//                        System.out.println("List of Humans : ");
//                        ListFromFile.Editedlist();
//                        ListFromFile.writeFile();
//                   break; 
//
//                   case (4):   // Search Human
//
//                        int subm;
//                        do
//                            {
//                                System.out.println ("Search :  1) Position  2) Fam ");
//                                subm =  getInt();
//                            }
//                        while (subm == 1 && subm == 2);
//
//                            switch(subm)
//                            {
//                                case (1):     // Search by Position             
//
//                                    Newlist PoiskPosit = new Newlist();
//                                    int pos;
//                                    do
//                                    {                                 
//                                        System.out.println ("Enter Position : \n_Chief = 1;\n_Accountant = 2;\n_Engineer = 3;\n_Working = 4;");
//                                        pos = getInt();
//                                    }
//                                    while (pos <1 && pos >4);    
//
//                                    PoiskPosit = ListFromFile.foundPos(pos);
//                                    PoiskPosit.Editedlist();                                        
//
//                                break;
//
//                                case (2):     // Search By Fam
//                                    
//                                    Newlist PoiskFam = new Newlist();
//                                    System.out.println("Enter fam or beginning of fam :  ");
//                                    String F = getString();
//                                    
//                                    PoiskFam = ListFromFile.foundFam(F);
//                                    PoiskFam.Editedlist();   
//                                    
//                                break;                                    
//                            }
//                            
//                   break;
//
//
//                   case (5):   // Print All 
//                       
//                       //<editor-fold defaultstate="collapsed" desc="Old Print All">
//                       
//    //                    Iterator<Human> P = Firma.iterator();
//    //                    while(P.hasNext())
//    //                        {
//    //                            Human h = P.next();                        
//    //                            //h.showHum();
//    //                            h.arrayHum(h);
//    //                        }
//                       //</editor-fold>
//                       ListFromFile.Editedlist();
//                   break;
//
//                   case (6):
//                       
//                        System.out.println("Good Bye !");
//                        ListFromFile.writeFile();
//                   break;                
            }       
        }
        while(m !=6);
        
        
        //Newlist ListFromFile = Firma.readFile();
       
    }
    
}

class Film
{
    public String Filmname;
    public int year;
    public Janr j;    
    
    Film(String s, int y, Object janr) throws Exception
    {
        this.Filmname = this.setName(s);
        this.year = this.setYear(y); 
        this.j = (Janr) janr;        
    }
    public String setName(String s) throws Exception
    {
        if(s.isEmpty() != false)
        {
            this.Filmname = s;
            return this.Filmname;
        }
        else
        {
            throw new Exception("Film Name can not be empty! ");            
        }
    }
    public int setYear(int y) throws Exception
    {
        if(y > 1900 && y < 2015)
        {
            this.year = y;
            return this.year;
        }
        else
        {
            throw new Exception("Film Yearis not possible ");
        }
    }    
    public void showFilm()
    {
        System.out.println("Film : " + this.Filmname + " year : " + this.year + "Janr " + j.getJanr());
    }   
}


class Janr
{
    public String JanrName;   
    
    Janr (String j) throws Exception
    {
        this.JanrName = this.setJanrName(j);       
    }
    public String setJanrName(String j) throws Exception
    {
        if(j.isEmpty() != false)
        {
            this.JanrName = j;
            return this.JanrName;
        }
        else
        {
            throw new Exception("Film Name can not be empty! ");            
        }
    }
    public String getJanr()
    {
        return this.JanrName;
    }
    public void showJanr()
    {
        System.out.println("Janr of Film : " + this.JanrName);
    }
}
