package filmcollection;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FilmCollection extends ArrayList<Film> implements Serializable
{
    FilmCollection()
    {
        
    }
    
    public void showAllFilms()
    {
        int i = 1;
        Iterator I = this.iterator();
            while(I.hasNext())
            {
                Film x =  (Film) I.next();
                System.out.print(i + " : "); 
                x.showFilm();
                i++;
            }        
    }
     
    
    
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
        FilmCollection List = new FilmCollection();
        JanrCollection Janres = new JanrCollection();
        
        Janr a = new Janr("action");
        Janr f = new Janr("fantastic");
        Janr s = new Janr("serial");
        Janr d = new Janr("drama");
        Janres.add(a);
        Janres.add(f);
        Janres.add(s);
        Janres.add(d);        
                
        List.add(new Film("Rembo" ,         1972 , a));
        List.add(new Film("Star Wars" ,     1974 , f));
        List.add(new Film("Die Hard" ,      1986 , a));
        List.add(new Film("Lost" ,          2004 , s));
        List.add(new Film("Terminator 2" ,  1992 , a));
        List.add(new Film("Titanik" ,       2000 , d));
        
        
        int m;
        
        do
        {
            System.out.println("1) Add Film \n2) Remove Film \n3) Edit Film \n4) Edit Janres  \n5) Print All Films \n6) Save & Exit Menu ");  
            m = getInt(); 
                switch(m)
                {
                    
                    //<editor-fold defaultstate="collapsed" desc="1 : Add New Film">                    

                   case (1):                                          

                        System.out.println("Enter Film Name : ");
                        String  n  = getString();
                        System.out.println("Enter Film Year : ");
                        int     y  = getInt();
                        System.out.println("Janres of Films : ");               // Show all Available Janres Of Films
                        Janres.showAllJanres();
                        System.out.println("Enter JanrName : ");                // Create New Janr if this not Available
                        String  j = getString();
                        
                        boolean janrIsFound = false;                        

                        Iterator I = Janres.iterator();
                        while(I.hasNext())
                        {
                            Janr x =  (Janr) I.next();
                            if(x.getJanr().indexOf(j) >= 0)
                            {
                                try
                                {
                                    System.out.println("This Janr is Exist");
                                    List.add(new Film(n,y,x)); 
                                    janrIsFound = true;
                                    break;
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Error creating object Film : " + e.getMessage());
                                }                                    
                            }                                                        
                        }
                        
                        if(janrIsFound == false)
                        {
                            Janr newjanr = new Janr(j);                        
                            Janres.add(newjanr);
                            try
                            {
                                List.add(new Film(n,y,newjanr));                                        
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error creating object Film : " + e.getMessage());
                            }    
                            janrIsFound = true;
                        }
                                                
                   break;
                       
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="2 : Remove Film ">                     

                   case (2):     
                       
                        System.out.println("Enter the index of Film what you want to Remove : ");
                        List.showAllFilms();
                        int removeIndex = getInt(); 
                        List.remove(removeIndex-1);
                        System.out.println("New List of Films : ");
                        List.showAllFilms();
                        //List.writeFile();
                   break;
                       
                    //</editor-fold> 
                    //<editor-fold defaultstate="collapsed" desc="3 : Edit Film">
                   
                   case (3):   // Edit Film       
                        int exchange;
                        List.showAllFilms();                        
                        do
                            {      
                                System.out.println ("Enter the index of Film what you want to Edit :  ");
                                exchange = getInt();
                            }
                        while (exchange < 0  &&  exchange > List.size());  

                        Film old = (Film) List.get(exchange-1);                 // Save Old Profile
                        List.remove(exchange-1);                                // Remove Old profile
                        System.out.println ("enter new Film Name : ");
                        String nameEx = getString();
                        System.out.println ("enter new Film Year : ");
                        int yearEx = getInt();                                             
                        System.out.println("Janres of Films : ");               // Show all Available Janres Of Films
                        Janres.showAllJanres();
                        System.out.println("Enter Janr Name : ");                                      
                        String newj  = getString();   
                        
                        boolean Janr_is_Found = false;                        

                        Iterator J = Janres.iterator();
                        while(J.hasNext())
                        {
                            Janr ex =  (Janr) J.next();
                            if(ex.getJanr().indexOf(newj) >= 0)
                            {
                                try
                                {
                                    System.out.println("This Janr is Exist");
                                    List.add(exchange-1, new Film(nameEx,yearEx,ex)); 
                                    Janr_is_Found = true;
                                    break;
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Error Editing Film : " + e.getMessage());
                                    List.add(exchange-1, old);                  // return Old Profile if Exception 
                                }                                    
                            }                                                        
                        }
                        
                        if(Janr_is_Found == false)
                        {
                            Janr newjanr = new Janr(newj);                        
                            Janres.add(newjanr);
                            try
                            {
                                List.add(exchange-1,new Film(nameEx,yearEx,newjanr));                                        
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error Editing Film : " + e.getMessage());
                                List.add(exchange-1, old);                      // return Old Profile if Exception 
                            }    
                            Janr_is_Found = true;
                        }                       

                        System.out.println("New List of Films : ");
                        List.showAllFilms();

                   break; 
                       
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="4 : Edit Janres / SubMenu">
                    
                   case (4):   

                        int submenu;
                        do
                            {
                                System.out.println ("Edit Janres : 1) Show All Janres 2) Add 3) Remove 4) Replace 5) Quit To Main Menu ");
                                submenu =  getInt();
                                switch(submenu)
                                {
                                    //<editor-fold defaultstate="collapsed" desc="1) Show All Janres">
                                    case (1):    // 
                                        
                                        Janres.showAllJanres();   
                                        
                                    break;
                                    
//</editor-fold>                                    
                                    //<editor-fold defaultstate="collapsed" desc="2) Add Janr">
                                    
                                    case (2):                 

                                        System.out.println("Enter Janr Name : ");
                                        String newjanr = getString();
                                        
                                        if(Janres.janrIsExist(newjanr) == true)
                                        {
                                            System.out.println("This Janr is Exist in Collection.");
                                        }
                                        else
                                        {
                                            Janres.add(new Janr(newjanr));
                                        }
                                                                               
                                    break;
//</editor-fold>
                                    //<editor-fold defaultstate="collapsed" desc="3) Remove Janr">
                                   
                                    case (3):    

                                        System.out.println("Enter index of Janr what you want to remove :  ");
                                        Janres.showAllJanres();
                                        
                                        int re = getInt();
                                        String S = Janres.get(re-1).JanrName;
                                        
                                        Iterator F = List.iterator();
                                        while(F.hasNext())
                                        {
                                            Film x =  (Film) F.next();
                                            
                                            if(x.j.JanrName.indexOf(S) >= 0)
                                            {
                                                System.out.println("This Janr Used by one or more Film(s) in FilmList and cannot be Delete");
                                                break;
                                            }
                                            else
                                            {
                                                //int remove = re - 1;
                                                Janres.remove(Janres.get(re-1));                                                
                                            }
                                            
                                        }
                                        
                                        System.out.println("New List of Janres : ");
                                        Janres.showAllJanres();
                                        
                                    break;
//</editor-fold>                                        
                                        
                                    //<editor-fold defaultstate="collapsed" desc="4) Replace Janr">
                                        

                                    case (4):    

                                        Janres.showAllJanres();
                                        System.out.println("Enter the index of Janr what you want to Replace :  ");
                                        int rpl = getInt();
                                        Janres.remove(rpl-1);
                                        System.out.println("Enter a New Janr : ");
                                        Janres.add(rpl-1, new Janr(getString()));                                      
                                        System.out.println("New List of Janres : ");
                                        Janres.showAllJanres();
                                        
                                    break;
//</editor-fold>                                   
                                    //<editor-fold defaultstate="collapsed" desc="5) Quit to Main Menu">
                                    case (5):    
                                        
                                        System.out.println("Go to MainMenu : ");
                                                                          
                                    break; 
                                        
//</editor-fold>                                                                           
                                }
                            }
                        while (submenu !=5);                            
                            
                   break;
                       //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="5 : Print All">                       

                   case (5):   //  
                       
                        List.showAllFilms();
                        
                   break;
                       //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc="6 : Save & Exit">                       

                   case (6):
                       
                        System.out.println("Good Bye !");
                        //List.writeFile();
                   break;  
                       //</editor-fold>
            }       
        }
        while(m !=6);
        
        
        //Newlist ListFromFile = Firma.readFile();
       
    }
    
}

class Film implements Serializable
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
        if(s.isEmpty())
        {
            throw new Exception("Film Name can not be empty! ");           
        }
        else
        {
           this.Filmname = s;
           return this.Filmname;            
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
        System.out.println(this.Filmname + ", Year : " + this.year + ", Janr : " + j.getJanr() + ".");
    } 
    public String getJanr()
    {        
        return this.j.getJanr();
    }
}


class Janr implements Serializable
{
    public String JanrName;   
    
    Janr (String j) throws Exception
    {
        this.JanrName = this.setJanrName(j);       
    }
    public String setJanrName(String j) throws Exception
    {
        if(j.isEmpty())
        {
            throw new Exception("Film Janr can not be empty! ");            
        }
        else
        {
            this.JanrName = j;
            return this.JanrName;              
        }
    }
    public String getJanr()
    {
        return this.JanrName;
    }
    public void showJanr()
    {
        System.out.println(this.JanrName);
    }
}

class JanrCollection extends ArrayList<Janr>
{
    JanrCollection()
    {
        
    }
    
    public void showAllJanres()
    {
        int i = 1;
        Iterator I = this.iterator();
            while(I.hasNext())
            {
                Janr x =  (Janr) I.next();
                System.out.print(i + ") ");
                x.showJanr();
                i++;
            }        
    }
    
    public boolean janrIsExist(String S) 
    {
        boolean Exist = false;
        Iterator N = this.iterator();
        while(N.hasNext())
        {
            Janr x =  (Janr) N.next();
            if(x.getJanr().indexOf(S) >= 0)
            {
                Exist = true;
                break;                                                   
            }                                                        
        }

//        if(Exist == false)
//        {
//            Janr newjanr = new Janr(S); 
//            try
//            {
//                this.add(newjanr);                                                 
//            }
//            catch(Exception e)
//            {
//                System.out.println("Error creating object Janr : " + e.getMessage());
//            }    
//            Exist = true;
//        }     
        
        return Exist;
    }  
    
}
