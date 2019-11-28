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
             case 0:
                 current = "Kingston & St. Andrew";
                 break;
             case 1:
                 current ="St. Thomas";
                 break;
             case 2:
                 current = "Portland";
                 break;
             case 3:
                 current = "St. Mary";
                 break;
             case 4:
                 current = "St. Cathrine";
                 break;
             case 5:
                 current = "Clarendon";
                 break;
             case 6:
                 current = "Manchester";
                 break;
             case 7:
                 current = "St. Ann";
                 break;
             case 8:
                 current = "St. Elizebeth";
                 break;
             case 9:
                 current = "St. James";
                 break;
             case 10:
                 current = "Hanover";
                 break;
             case 11:
                 current = "Westmoreland";
                 break;
             case 12:
                 current = "Trelawney";
                 break;
             default:
                 break;
         }

         return current;
     }

}
