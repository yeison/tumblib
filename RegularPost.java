package tumblib;

import com.google.gson.JsonObject;

public class RegularPost extends Post {
	String title;
	String body;
	

	RegularPost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags,
			String title, String body){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);	
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	/******Static methods for deserializing QuotePosts from JSON.******/
	static String titleFromJson(JsonObject post){
		return post.getAsJsonPrimitive("regular-title").getAsString();
	}
	
	static String bodyFromJson(JsonObject post){
		return post.getAsJsonPrimitive("regular-body").getAsString();
	}

}
