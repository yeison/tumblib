package tumblib;

import com.google.gson.JsonObject;

/**
 * The chat or conversation post-type corresponds to the ConvoPost java class.
 * This post-type contains a title and the text of the conversation.
 * @author Yeison Rodriguez
 *
 */
public class ConvoPost extends Post {
	private String convoTitle;
	private String convoText;
	
	/**This wacky constructor is meant to be used by the {@link PostDeserializer}.*/
	public ConvoPost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags, 
			String convoTitle, String convoText){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setConvoTitle(convoTitle);
		setConvoText(convoText);
	}

	/**
	 * Returns the title and and text/body of this conversation post.
	 */
	public String getContent(){
		return  content + "\n" + getConvoTitle() + "\n" + getConvoText() ;
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
