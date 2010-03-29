package tumblib;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonObject;

/**
 * This class corresponds to the tumblr link post.  It contains a link, its text
 * and a description for the link.
 * @author Yeison Rodriguez
 *
 */
public class LinkPost extends Post {
	static int count;
	String linkText;
	URL linkUrl;
	String linkDescription;
	
	/**This wacky constructor is meant to be used by the {@link PostDeserializer}.*/
	public LinkPost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags, 
			String linkText, String linkUrl, String linkDescription){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setLinkText(linkText);
		setLinkUrl(linkUrl);
		setLinkDescription(linkDescription);
		
		count++;
	}
	
	/**
	 * Returns the url of this link, as well as a description if one exists.
	 */
	public String getContent(){
		return content + "\n" + getLinkUrl() + "\n" + getLinkDescription();
	}

	public String getLinkText() {
		return linkText;
	}

	void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public URL getLinkUrl() {
		return linkUrl;
	}

	void setLinkUrl(String linkUrl) {
		try {
			this.linkUrl = new URL(linkUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Please verify that the URL format is correct.");
			System.err.println(linkUrl);
		}
	}

	public String getLinkDescription() {
		return linkDescription;
	}

	void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}
	
	/******Static methods to be used in deserializing LinkPosts from JSON.******/
	static String urlFromJson(JsonObject post){
		return post.getAsJsonPrimitive("link-url").getAsString();
	}
	
	static String textFromJson(JsonObject post){
		return post.getAsJsonPrimitive("link-text").getAsString();
	}
	
	static String descriptionFromJson(JsonObject post){
		return post.getAsJsonPrimitive("link-description").getAsString();
	}
}
