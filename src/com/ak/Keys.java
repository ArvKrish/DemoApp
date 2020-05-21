package com.ak;
import java.util.*;


public class Keys {
	
	public static Player p;
	static Scanner sc = new Scanner(System.in);
	static int opponentCount=0;
	static Random generator=new Random();
	 static boolean start(String pname,int power) {
		
		
		
		
		
		
		
		
		p= new Player(pname,power);
		//sc.nextLine();
		
		if(p instanceof Player)	
			return true;	
		else
			return false;
		
	}
		
		

	
	static boolean newVillain(String name,int power) {

		return p.addNewVillain(name, power);
		
	}
	
	public static int villainSize() {
		return p.villains.size();
	}
	
	
	static String showList() {
		String list="";
		
		list+="The list of Villains are:<br/>";
		
		for(Map.Entry<Integer,Villain> entry:p.villains.entrySet()) {
		
			list+=" <br/>Code: &ensp;"+ entry.getKey()+ ". Name: &ensp; "+entry.getValue().getName()+"<br/>" ;
		 }
		
		return list;
	}


	static String villainAction(int method, String oName,int oKey,String compliment){
		
		String status="";
		if(p.villains.size()==1) {
					
			for(Map.Entry<Integer,Villain> entry:p.villains.entrySet())
			{
				if(method==1) {
				status+="Villain Found - "+entry.getValue().getName()+"\n";
					
					status+=p.strike(entry.getValue());
				
					status+="\n Health reduced to "+Math.round(entry.getValue().getHealth())+".<br/>";
							
					return status;		
				}
					
					
				else if (method==8)
					{
					
					return addCompliment(entry.getValue(),compliment);
					}
				else if (method==10)
					return showCompliment(entry.getValue());
				
			}
			
		}
		else {
			String name=oName;
			int key=oKey;
			boolean striker=false;
			System.out.println(key+"gey");
			
			for(Map.Entry<Integer,Villain> entry:p.villains.entrySet())
			{	
				if(key==0) 
				{
					Villain v=entry.getValue();
					if(v.getName().equals(name))
					{
						if(method==1) {
							status+="Villain Found - "+entry.getValue().getName()+"\n";
						
							status+=p.strike(entry.getValue());
					
							status+="\n Health reduced to "+Math.round(v.getHealth())+"<br/>.";
							
							return status;		
						
						}
					else if(method==8)
					{
						return addCompliment(entry.getValue(),compliment);
					
					}
					else if (method==10)
						return showCompliment(entry.getValue());
				
					striker=true;
				
				
					}
				
				}
				else if(key>0){

					System.out.println(key+"ki");
					System.out.println(entry.getKey()+"bi");
						if(entry.getKey()==(key))
						{
							Villain v=p.villains.get(entry.getKey());
							if(method==1) {
								status+="Villain Found - "+entry.getValue().getName()+"\n";
	
								status+=p.strike(v);
							
								status+="\n Health reduced to "+Math.round(v.getHealth())+".";
								System.out.println(status);		
								return status;			
														
								
								
							}
							else if(method==8)
							{
							
							
								return addCompliment(entry.getValue(),compliment);
								}
							else if (method==10)
								return showCompliment(entry.getValue());
						
							striker=true;
						}
				}
				
			}
			
			if(!striker)
				return "Opponent does not exist";
	
		}
		return "a";
			
	  }


	static String villainActionAll(int method) {
		String compliment="";
		String str="";
		for(Map.Entry<Integer,Villain> entry:p.villains.entrySet()){
			
			if (method==1){

				str+="Villain Found - "+entry.getValue().getName()+"\n";			
				str+=p.strike(entry.getValue());
			
				str+="Health reduced to "+entry.getValue().getHealth();
				str+="<br/><br/>";
			}

			else if(method==8)
				
				addCompliment(entry.getValue(),compliment);
			else if (method==11)
				showCompliment(entry.getValue());
			else
				entry.getValue().getSummary();
			
				
		}
		return str;
		
		}
	static String boostEnergy(int method) {
		if(method>0)
			return p.powerUp(1);
		else
			return p.powerUp();
	}

		
	
	static String addCompliment(Villain v,String compliment) {
		
		v.setCompliment(compliment.toLowerCase());
		
		return "<br/>You are my enemy and you're "+compliment+", Mr."+v.getName()+".<br/><br/>";
		
		
		
	}
	
	static String showCompliment(Villain v) {
		
		System.out.println("Test");
		return v.getCompliments();
			}

		
	static String allSummary() {
		String str="";
		str+="<br/> "+p.getSummary()+"<br/><br/> ";
		

		for(Map.Entry<Integer,Villain> entry:p.villains.entrySet()){
	
			str+="<br/> "+entry.getValue().getSummary()+"<br/><br/> ";
		}
		return str;
		
		}
					
	

}
	
		
	
	

	
