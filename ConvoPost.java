package tumblib;

import com.google.gson.JsonObject;

public class ConvoPost extends Post {
	private String convoTitle;
	private String convoText;
	
	public ConvoPost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags, 
			String convoTitle, String convoText){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setConvoTitle(convoTitle);
		setConvoText(convoText);
	}

	public void setConvoText(String convoText) {
		this.convoText = convoText;
	}

	public String getConvoText() {
		return convoText;
	}

	public void setConvoTitle(String convoTitle) {
		this.convoTitle = convoTitle;
	}

	public String getConvoTitle() {
		return convoTitle;
	}
	
	/******Static methods to be used in deserializing ConvoPosts from JSON.******/
	static String titleFromJson(JsonObject post){
		return post.getAsJsonPrimitive("conversation-title").getAsString();
	}
	
	static String textFromJson(JsonObject post){
		return post.getAsJsonPrimitive("conversation-text").getAsString();
	}
}
