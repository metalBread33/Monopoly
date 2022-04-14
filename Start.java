import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

import javax.swing.text.LabelView;

public class Start {
    public static void main(String args[]){
        BufferedReader input;
        try{
            input = new BufferedReader(new FileReader("Info.txt"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        Land[] lands;
        lands = new Land[40];
        Integer[] property_nums = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
        for(int i = 0; i < 40; i ++){
            String name = "N/A";
            int cost = 0, 
                price_per_house = 0, 
                rent = 0, 
                rent_1_house = 0, 
                rent_2_house = 0, 
                rent_3_house = 0, 
                rent_4_house = 0, 
                rent_hotel = 0, 
                mortgage = 0;
            
            lands[i] = new Land();
            if(i%10 == 5){
                lands[i].SetDeed(new RailRoad());
            }
            else if(i == 10){
                lands[i].SetDeed(new Deed("Just Visiting", true, false));
            }
            else if(i == 30){
                lands[i].SetDeed(new Deed("Go To Jail", false, true));
            }
            else if(Arrays.asList(property_nums).contains(i)){
                try{
                    name = input.readLine();
                    cost = Integer.parseInt(input.readLine());
                    price_per_house = Integer.parseInt(input.readLine());
                    rent = Integer.parseInt(input.readLine());
                    rent_1_house = Integer.parseInt(input.readLine());
                    rent_2_house = Integer.parseInt(input.readLine());
                    rent_3_house = Integer.parseInt(input.readLine());
                    rent_4_house = Integer.parseInt(input.readLine());
                    rent_hotel = Integer.parseInt(input.readLine());
                    mortgage = Integer.parseInt(input.readLine());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                lands[i].SetDeed(new Deed(name, cost, mortgage, rent));
            }
            
        }
        for(int i = 0; i < 40; i ++){
            System.out.println(lands[i].GetDeed().GetName());
        }
    }
}
