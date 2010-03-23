package tumblib;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.*;

public class PostStatistics {

	String jsonString = "";
	//Google's JSON library for Java requires some funny-looking syntax.
	Gson gson = new GsonBuilder().
	registerTypeAdapter(Post.class, new PostDeserializer()).
	create();


	public PostStatistics(String jsonString){
		setJsonString(jsonString);

		//Parse the JsonString and return a JsonElement (supertype).
		JsonParser jParser = new JsonParser();
		JsonElement jElement = jParser.parse(jsonString);

		//The JsonElement should be a JsonObject (the tumblog is a JSON objects).
		JsonObject jObject = jElement.getAsJsonObject();
		//From the tumblog extract the JSON-format posts in an Iterator.
		Iterator<JsonElement> postIterator = jObject.getAsJsonArray("posts").iterator();

		ArrayList<Post> postList =  new ArrayList<Post>(); 
		while(postIterator.hasNext()){
			jElement = postIterator.next();
			postList.add(gson.fromJson(jElement, Post.class));
		}
		Post[] postArray = {};
		postArray = postList.toArray(postArray);

		TimeStats.createTable("PostTimes", "times", postArray);
	}

	/**@return */
	public String getJsonString() {
		return jsonString;
	}

	/**@return */
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	

}
