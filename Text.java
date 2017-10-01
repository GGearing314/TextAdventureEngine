//Really simple text based adventure engine, uses string arrays to store choices and results and a 2D array to organise them
import java.io.*;	//needed for input
public class Text{
	//STORY SECITON----------------------------
	//snippet for choice array ='ch'
	//choices and outputs for each choice
	//All arrays must have 8 elements , 4 choices and respective results
	public static String[] choice0={"Go into the tavern","Go to the market stall","Look for someone to talk to","You walk to the tavern and the smell of beer and blood hits your nose as you cross the threshold","You walk up the the market stall and find a gnome standing on the top smoking a pipe, his wares are splayed about him","The nearest person is a grimy peasant"};
	public static String[] choice1={"Ask for a drink","Look at the bounty board","Talk to the nearest person","look around the room","1","2","3","4"};	//tavern


	//2D array containing all the choice arrays
	public static String[][] collection={choice0,choice1};


//ENGINE--------------------------
	public static boolean game_bool=true;
	public static int turn_count=0;
	public static void main(String[] args){
		//Introduction text EDIT as required
		System.out.println("Welcome to  text adventure, to play simply type in the number of the choice you wish to complete.");
		System.out.print("You find yourself in the middle of the town square, a crowd of dirty citizans bustles around you.\nA Tavern resides on your left named the Dirty Horse.\nA market stall is to your right.\n");
		String[] list=choice0;
		while(game_bool==true){	//main game loop
			for(int i=0;i<list.length/2;i++){
				System.out.println((i+1)+": "+list[i]);
			}			//prints choices
			String choice=getInput("What shall you do? ");
			int choice_num=Integer.parseInt(choice);
			for(int i=0;i<(list.length/2);i++){	//length halved as array contains both choices and results
				if(choice_num==(i+1)){
					System.out.println("\n"+list[(list.length/2)+i]);	//prints result
					if(list[(list.length/2)+i]=="You Died!"){
						game_bool=false;break;//breaks while loop
					}
					try{
						list=collection[turn_count+choice_num];
					}
					catch(Exception e){
						System.out.println("Choice not found, not written yet.");
						game_bool=false;
					}
					turn_count+=list.length/2; //moves point in collection by choice amount
					break;	//prevents searching through the rest of the choices
				}
			}
		}
	}
	public static String getInput(String prompt){
    System.out.print(prompt);
    InputStreamReader isr=new InputStreamReader(System.in);
    BufferedReader buffer=new BufferedReader(isr);
    String input="";
    try{
  		input=buffer.readLine();
    }
    catch(IOException e){
      System.out.println("Input Error");
    }
    return input;
  }
}
