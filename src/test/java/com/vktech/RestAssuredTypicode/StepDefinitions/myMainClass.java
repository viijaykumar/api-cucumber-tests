package com.vktech.RestAssuredTypicode.StepDefinitions;

public class myMainClass {
	
	public static void main(String[] args){
		
		
		Colour newColour = new Colour("red");
		Colour newColour2 = new Colour("red");
		
		
		//String validateColours = new String();
		if(newColour==newColour2){
			System.out.println("Both Colours are Equal");
		}else{
			
		newColour.equals(newColour2);
			System.out.println("Both ColourObjects are Equal");
		}
	}
}
