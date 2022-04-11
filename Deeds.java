import java.lang.String;

//*****************************************************************************

/*
 * Name = name of property
 * Owner = player that owns property
 * CostOfDeed = Price to buy
 * Mortgage = money player gets of mortgaging the property
 * Rent = base rent
 * Own = is the property owned by a player
 */
public class Deeds {
    String Name; String Owner;
    int CostOfDeed, Mortgage, Rent;
    boolean Own;

    Deeds (String name, int cost, int mort, int rent)
    {
        Name = name;
        CostOfDeed = cost;
        Mortgage = mort;
        Rent = rent;
        Own = false;
        Owner = "N/A";
    }
}
