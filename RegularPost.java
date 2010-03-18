package tumblib;

public class RegularPost extends Post {
	
	RegularPost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		
		
	}

}
