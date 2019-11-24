package model;

public class ParishCode{

    private String kingston = "Kingston $ St. Andrew";
    private String thomas = "St. THomas";
    private String portland = "Portland";
    private String mary = "St. Mary";
    private String cathrine = "St. Cathrine";
    private String clarendon = "Clarendon";
    private String manchester = "Manchester";
    private String ann = "St. Ann";
    private String elizebeth = "St. Elizabeth";
    private String james = "St. James";
    private String hanover = "Hanover";
    private String westmoreland = "Westmoreland";
    private String trelawney = "Trelawny";


     public static String getParish(int parishCode){
         String current = "";
         switch (parishCode){
             case 1:
                 current = "Kingston $ St. Andrew";
                 break;
             case 2:
                 current ="St. Thomas";
                 break;
             case 3:
                 current = "Portland";
                 break;
             case 4:
                 current = "St. Mary";
                 break;
             case 5:
                 current = "St. Cathrine";
                 break;
             case 6:
                 current = "Clarendon";
                 break;
             case 7:
                 current = "Manchester";
                 break;
             case 8:
                 current = "St. Ann";
                 break;
             case 9:
                 current = "St. Elizebeth";
                 break;
             case 10:
                 current = "St. James";
                 break;
             case 11:
                 current = "Hanover";
                 break;
             case 12:
                 current = "Westmoreland";
                 break;
             case 13:
                 current = "Trelawney";
                 break;
             default:
                 break;
         }

         return current;
     }

}
