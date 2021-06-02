package data;

import java.util.HashMap;
import java.util.Map;

public enum CourseName {

    Angewandte_Informatik(1), Bauingenieurwesen(2), Bekleidungstechnik(3), Betriebswirtschaftslehre(4), Computer_Engineering(5), Elektrotechnik(6), Facility_Management(7), Fahrzeugtechnik(8), Game_Design(9), Gebäudeenergie_und_informationstechnik(10), Gesundheitselektronik(11), Immobilienwirtschaft(12), Industrial_Design(13), Informatik_und_Wirtschaft(14), Informations_und_Kommunikationstechnik(15), Ingenieurinformatik(16), International_Business(17), Medieninformatik(18), Kommunikationsdesign(19), Grabungstechnik(20), Life_Science_Engineering(21), Maschinenbau(22), Mikrosystemtechnik(23), Modedesign(24), Museologie(25), Museumskunde(26), Public_und_Nonprofit_Management(27), Regenerative_Energien(28), Umweltinformatik(29), Wirtschaft_und_Politik(30), Wirtschaftsinformatik(31), Wirtschaftsingenieurwesen(32),  Wirtschaftskommunikation(33), Wirtschaftsmathematik(34), Wirtschaftsrecht(35);

    private int value;

    CourseName(int value){
        this.value = value;
    }

    private static Map map = new HashMap <>();

    static{
        for(CourseName courseName : CourseName.values()){
            map.put(courseName.value, courseName);
        }
    }

   public static CourseName valueOf(int courseName){
        return (CourseName) map.get(courseName);
    }

    public int getValue(){
        return value;
    }

    public static CourseName lookup(String course){
        for(CourseName courseName : CourseName.values()){
            if(courseName.name().equalsIgnoreCase(course)){
                return courseName;
            }
        }
        return null;
    }

    }


