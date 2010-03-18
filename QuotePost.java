package tumblib;

public class QuotePost extends Post {
	private String quoteText;
	private String quoteSource;
	
	QuotePost(long id, String url, String urlWithSlug, PostType type, long date, 
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags){
		
		super(id, url, urlWithSlug, type, date, bookmarklets, mobiles, reblogKey, slug, tags);
		
		
	}

}
