package tumblib;

import com.google.gson.JsonObject;

public class QuotePost extends Post {
	private String quoteText;
	private String quoteSource;
	
	public QuotePost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags, 
			String quoteText, String quoteSource){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setQuoteText(quoteText);
		setQuoteSource(quoteSource);
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}

	public String getQuoteSource() {
		return quoteSource;
	}
	
	/******Static methods to be used in deserializing QuotePosts from JSON.******/
	static String textFromJson(JsonObject post){
		return post.getAsJsonPrimitive("quote-text").getAsString();
	}
	
	static String sourceFromJson(JsonObject post){
		return post.getAsJsonPrimitive("quote-source").getAsString();
	}

}
