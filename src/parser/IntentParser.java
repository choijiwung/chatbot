package parser;

import java.sql.SQLException;
import java.util.StringTokenizer;

public class IntentParser {
	
	String intent = null;
	String intent_detail = null;
	String intent_fixture = null;
	String target = null;
	
	//Watson과 통신하는 부분 
	/*public void tokenParser(String returnedMessage){
		
		returnedMessage=returnedMessage.replace("[", "");
		returnedMessage=returnedMessage.replace("]", "");
		StringTokenizer st = new StringTokenizer(returnedMessage, "|");  
		intent = st.nextToken();
	  	intent_detail = st.nextToken();
	  	target = st.nextToken();
	  	System.out.println("TOKENED INTENT :" + intent);
	  	System.out.println("TOKENED INTENT_DETAIL : "+ intent_detail);
	  	System.out.println("TOKENED PLAYER_NAME : "+ target); 
	}*/
	
	public String[]  crawlerParser(String msg) throws Exception {
		System.out.println(msg.indexOf("년"));
		System.out.println(msg.indexOf("월"));
		int guide_year = msg.indexOf("년");
		int guide_month = msg.indexOf("월");
		
		String year = msg.substring(guide_year-4,guide_year).trim();
		String month = msg.substring(guide_year+1, guide_month).trim();
		String [] yearmonth = {year,month};
		return yearmonth;
	}
	
	public String detailParser() throws ClassNotFoundException, SQLException{
		if (intent.equals("intent_team"))	return new DetailParserTeam(intent_detail, target).parsing();			
		if (intent.equals("intent_player")) return new DetailParserPlayer(intent_detail, target).parsing();
		if (intent.equals("intent_fixture")) return new DetailParserFixture(intent_detail, target).parsing();
		return null; 
	}
		
}
