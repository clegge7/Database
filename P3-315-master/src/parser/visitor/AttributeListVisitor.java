package parser.visitor;

import java.util.ArrayList;

import database.Attribute;
import database.AttributeType;
import parser.ProgramBaseVisitor;
import parser.ProgramParser.TypedatrlistContext;

public class AttributeListVisitor extends ProgramBaseVisitor<ArrayList<Attribute>>{

	public static final AttributeListVisitor instance = new AttributeListVisitor();
	
	
	private AttributeListVisitor(){}
	
	@Override
	public ArrayList<Attribute> visitTypedatrlist(TypedatrlistContext ctx){
		
		if(ctx.getChildCount() < 2 || (ctx.getChildCount()-2)%3 != 0)
			return null;
		
		ArrayList<Attribute> attributeList = new ArrayList<>();
		
		for(int i = 0; i < ctx.getChildCount(); i += 3){
			
			String name = ctx.getChild(i).accept(IdentifierVisitor.instance);
			String type = ctx.getChild(i+1).getText();
			
			if(name == null || name.isEmpty() || name.equals("<missing identifier>"))
				return null;
			if(type == null || name.isEmpty() || name.equals("<missing identifier>"))
				return null;
			
			if(type.contains("(")){
				
				try{
					
					int size = Integer.parseInt(type.substring(type.indexOf('(')+1, type.indexOf(')')));
					attributeList.add(new Attribute(name, AttributeType.fromName(type), size, false));
				}catch(NumberFormatException e){
					
					System.out.println("Error parsing attribute type '" + type + "' invalid size.");
					return null;
				}
			}
			else{
				
				attributeList.add(new Attribute(name, AttributeType.fromName(type), false));
			}
		}
		
		return attributeList;
	}
}
