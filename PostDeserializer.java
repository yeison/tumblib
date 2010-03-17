package tumblib;

import java.lang.reflect.Type;

import com.google.gson.*;



public class PostDeserializer implements JsonDeserializer<Post> {

	/**
	 * @param JsonElement post is the post in its JSON format.
	 * @param 
	 * **/
	public Post deserialize(JsonElement post, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		JsonObject postObj =  post.getAsJsonObject(); 
		// TODO Auto-generated method stub
		return null;
	}
	
	long id(JsonObject post){
		return post.getAsJsonPrimitive("id").getAsLong();
	}
	
	String url(JsonObject post){
		return post.getAsJsonPrimitive("url").getAsString();
	}
	

}
