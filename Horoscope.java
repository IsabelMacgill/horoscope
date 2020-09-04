import java.io.BufferedReader;
import java.net.URL;
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Horoscope{
    private URL site;
    public int sign; 
    private BufferedReader in;
    private final int ARIES = 1; 
    private final int TAURUS = 2; 
    private final int GEMINI = 3; 
    private final int CANCER = 4;
    private final int LEO = 5; 
    private final int VIRGO = 6; 
    private final int LIBRA = 7; 
    private final int SCORPIO = 8 ;
    private final int SAGITTARIUS = 9 ;
    private final int CAPRICORN = 10;
    private final int AQUARIUS= 11;
    private final int PISCES = 12;

    public Horoscope(){
        System.out.println("Please enter your star sign.");
        Scanner a = new Scanner(System.in);
        String s = a.next();
        boolean valid = false;
        while(valid == false){
            if(s.toLowerCase().equals("aries")){
                sign = ARIES;
                valid = true;
            }
            else if(s.toLowerCase().equals("taurus")){
                sign = TAURUS;
                valid = true;
            }
            else if(s.toLowerCase().equals("gemini")){
                sign = GEMINI;
                valid = true;
            }
            else if(s.toLowerCase().equals("cancer")){
                sign = CANCER;
                valid = true;
            }
            else if(s.toLowerCase().equals("leo")){
                sign = LEO;
                valid = true;
            }
            else if(s.toLowerCase().equals("virgo")){
                sign = VIRGO;
                valid = true;
            }
            else if(s.toLowerCase().equals("libra")){
                sign = LIBRA;
                valid = true;
            }
            else if(s.toLowerCase().equals("scorpio")){
                sign = SCORPIO;
                valid = true;
            }
            else if(s.toLowerCase().equals("sagittarius")){
                sign = SAGITTARIUS;
                valid = true;
            }
            else if(s.toLowerCase().equals("capricorn")){
                sign = CAPRICORN;
                valid = true;
            }
            else if(s.toLowerCase().equals("aquarius")){
                sign = AQUARIUS;
                valid = true;
            }
            else if(s.toLowerCase().equals("pisces")){
                sign = PISCES;
                valid = true;
            }
            else{
                System.out.println("Please enter a valid start sign: aries, aquarius, cancer, capricorn, gemini, libra, leo, pisces, taurus, sagiitarius, scorpio, or virgo.");
                s = a.next();
            }
        }
    }
    

    public Horoscope(String s){
        boolean valid = false;
        while(valid == false){
            if(s.toLowerCase().equals("aries")){
                sign = ARIES;
                valid = true;
            }
            else if(s.toLowerCase().equals("taurus")){
                sign = TAURUS;
                valid = true;
            }
            else if(s.toLowerCase().equals("gemini")){
                sign = GEMINI;
                valid = true;
            }
            else if(s.toLowerCase().equals("cancer")){
                sign = CANCER;
                valid = true;
            }
            else if(s.toLowerCase().equals("leo")){
                sign = LEO;
                valid = true;
            }
            else if(s.toLowerCase().equals("virgo")){
                sign = VIRGO;
                valid = true;
            }
            else if(s.toLowerCase().equals("libra")){
                sign = LIBRA;
                valid = true;
            }
            else if(s.toLowerCase().equals("scorpio")){
                sign = SCORPIO;
                valid = true;
            }
            else if(s.toLowerCase().equals("sagittarius")){
                sign = SAGITTARIUS;
                valid = true;
            }
            else if(s.toLowerCase().equals("capricorn")){
                sign = CAPRICORN;
                valid = true;
            }
            else if(s.toLowerCase().equals("aquarius")){
                sign = AQUARIUS;
                valid = true;
            }
            else if(s.toLowerCase().equals("pisces")){
                sign = PISCES;
                valid = true;
            }
            else{
                System.out.println("Please write your star sign.");
                Scanner a = new Scanner(System.in);
                s = a.next();
            }
        }
    }

    public void getAstroStyle(){
        try{
            StringBuilder b = new StringBuilder();
            b.append("https://astrostyle.com/horoscopes/daily");
            b.append(getAstroStyleSIGN());
            b.append("/");
            site = new URL(b.toString());
            in = new BufferedReader(new InputStreamReader(site.openStream()));
            String inputLine;
            String linetoP;
            boolean horo = false; 
            String toPrint  ="";
            String prediction = "";
            int count = 0;
            System.out.println("AstroStyle.Com:");
            while((linetoP = in.readLine()) != null){
                inputLine = linetoP.replaceAll(" ","");
                if (horo == true){
                    if(inputLine.equals("<iclass=\"fafa-caret-down\"></i>")){
                        horo = false;
                    }
                    else{
                        if(count == 1){
                            toPrint += linetoP;
                            prediction = astroStyleTrim(toPrint);
                            System.out.println(prediction);
                            count++;
                        }
                        else{
                            count++;
                        }
                    }
                }
                else{
                    //System.out.println(inputLine);
                    if(inputLine.equals("<divclass=\"horoscope-content\">")){
                        horo = true;
                    }
                
                }
            }
            in.close();
        }
        catch(Exception e){
            System.out.println("Error.");
        }
    }

    public void getHoroscopeCom(){
        try{
            int theSign = this.sign;
            StringBuilder b = new StringBuilder();
            b.append("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=");
            b.append(theSign);
            site = new URL(b.toString());
            in = new BufferedReader(new InputStreamReader(site.openStream()));
            String inputLine;
            String linetoP;
            boolean horo = false; 
            String toPrint  ="";
            String prediction = "";
            int count = 0;
            System.out.println("Horoscope.Com;");
            while((linetoP = in.readLine()) != null){
                inputLine = linetoP.replaceAll(" ","");
              //System.out.println(inputLine);
                if (horo == true){
                    if(inputLine.equals("<script>")){
                        horo = false;
                    }
                    else{
                        if(count == 3){
                            toPrint += linetoP;
                            prediction = horoTrim(toPrint);
                            System.out.println(prediction);
                            count++;
                        }
                        else{
                            count++;
                        }
                    }
                }
                else{
                    //System.out.println(inputLine);
                   if(inputLine.equals("<aclass=\"\"id=\"datepicker-horo\"data-toggle=\"datepicker\"><iclass=\"icon-calendar\"></i></a>")){
                       horo = true;
                   }
                
                }
            }
            in.close();
        }
        catch(Exception e){
            System.out.println("Error.");
        }
    }

    public void getAstrology(){
        try{
            StringBuilder b = new StringBuilder();
            b.append("https://www.astrology.com/horoscope/daily");
            b.append(getAstroStyleSIGN());
            b.append(".html");
            site = new URL(b.toString());
            in = new BufferedReader(new InputStreamReader(site.openStream()));
            String inputLine;
            String linetoP;
            boolean horo = false; 
            String toPrint  ="";
            String prediction = "";
            int count = 0;
            System.out.println("Astrology.Com:");
            while((linetoP = in.readLine()) != null){
                inputLine = linetoP.replaceAll(" ","");
                if (horo == true){
                    if(inputLine.equals("<divclass=\"hide-small\">")){
                        horo = false;
                    }
                    else{
                        if(count == 1){
                            toPrint += linetoP;
                            prediction = astrologyTrim(toPrint);
                            System.out.println(prediction);
                            count++;
                        }
                        else{
                            count++;
                        }
                    }
                }
                else{
                    StringBuilder c = new StringBuilder();
                    c.append("<aclass=\"sign-color\"href=\"https://www.astrology.com/horoscope/daily/tomorrow");
                    c .append(getAstroStyleSIGN());
                    c.append(".html\">tomorrow</a>");
                    if(inputLine.equals(c.toString())){
                        horo = true;
                    }
                
                }
            }
            in.close();
        }
        catch(Exception e){
            System.out.println("Error.");
        }
    }


    public void getDailyHoroscope(){
        try{
            StringBuilder b = new StringBuilder();
            b.append("https://www.dailyhoroscope.com/horoscopes/daily");
            b.append(getAstroStyleSIGN());
            b.append("?full=true");
            //System.out.println(b.toString());
            site = new URL(b.toString());
            in = new BufferedReader(new InputStreamReader(site.openStream()));
            String inputLine;
            String linetoP;
            boolean horo = false; 
            String toPrint  ="";
            String prediction = "";
            int count = 0;
            System.out.println("DailyHoroscope.Com:");
            while((linetoP = in.readLine()) != null){
                inputLine = linetoP.replaceAll(" ","");
                //System.out.println(inputLine);
                if (horo == true){
                    if(inputLine.equals("</column")){
                        horo = false;
                    }
                    else{
                        if(count == 6){
                            toPrint += linetoP;
                            prediction = dailyHoroscopeTrim(toPrint);
                            System.out.println(prediction);
                            count++;
                        }
                        else{
                            count++;
                        }
                    }
                }
                else{
                    StringBuilder c = new StringBuilder();
                    c.append("<divclass=\"horoscope-daily-links\">");
                    if(inputLine.equals(c.toString())){
                        horo = true;
                    }
                
                }
            }
            in.close();
        }
        catch(Exception e){
            System.out.println("Error.");
            e.printStackTrace();
        }
    }



    public String astroStyleTrim(String h){
        String result = "";
        result = h.substring(11,h.length()-4);
        return result;
    }

    public String horoTrim(String h){
        String result = "";
        result = h.substring(35,h.length()-4);
        return result;
    }

    public String astrologyTrim(String h){
        String result = "";
        result = h.substring(43,h.length()-4);
        return result;
    }

    public String dailyHoroscopeTrim(String h){
        String result = "";
        result = h.substring(28,h.length()-155);
        return result;
    }

    public String getAstroStyleSIGN(){
        String result = "";
        int theSign = this.sign;
        switch(theSign){
            case 1:
                result = "/aries";
                break;
            case 2:
                result = "/taurus";
                break;
            case 3:
                result = "/gemini";
            case 4:
                result = "/cancer";
                break;
            case 5:
                result = "/leo";
                break;
            case 6:
                result = "/vrigo";
                break;
            case 7:
                result = "/libra";
                break;
            case 8:
                result = "/scorpio";
                break;
            case 9:
                result = "/sagittarius";
                break;
            case 10:
                result = "/capricorn";
                break;
            case 11:
                result = "/aquarius";
                break;
            case 12:
                result = "/pisces";
                break;
        }
        return result;
    }
   
    public static void main(String[] args){
        Horoscope me = new Horoscope(); 
        System.out.println(me.sign);
        me.getAstroStyle();
        System.out.println();
        me.getHoroscopeCom();
        System.out.println();
        me.getAstrology();
        System.out.println();
        me.getDailyHoroscope();
        System.out.println();
        
    }


}
