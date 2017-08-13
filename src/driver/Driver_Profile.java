package driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

import crawler.CrawlerPlayer;
import crawler.CrawlerProfile;

public class Driver_Profile {
	
	public Map <String, String> profileDetail(JSONObject player) {
		
		String rawData = null;
		String url = "https://www.premierleague.com/players/" + player.get("id") + "/overview";
		
		Map <String, String> map = new HashMap<>();
		CrawlerProfile crawlerProfile = new CrawlerProfile();
		
		crawlerProfile.setUrlstr(url);
		map =crawlerProfile.webReader();
		System.out.println("Driver_Profile / profileDetail / Map Size : " + map.size());
		for (String keymap : map.keySet() ) {
			System.out.println(keymap + " " + map.get(keymap));
		}
		return map;
	}
}