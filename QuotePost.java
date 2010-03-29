package tumblib;

import com.google.gson.JsonObject;

/**
 * This class corresponds to the quote post-type on tumblr.  It contains a quote
 * and the source for that quote.
 * @author Yeison Rodriguez
 *
 */
public class QuotePost extends Post {
	private String quoteText;
	private String quoteSource;
	
	/**This wacky constructor is meant to be used by the {@link PostDeserializer}.*/
	public QuotePost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags, 
			String quoteText, String quoteSource){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setQuoteText(quoteText);
		setQuoteSource(quoteSource);
	}

	/**
	 * Returns the quote itself, and the source of the quote if it exists.
	 */
	public String getContent(){
		return content + "\n" + getQuoteText() + "\n" + getQuoteSource();
	}
	
	void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getQuoteText() {
		return quoteText;
	}

	void setQuoteSource(String quoteSource) {
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
