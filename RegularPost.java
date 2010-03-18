package tumblib;

public class RegularPost extends Post {
	
	RegularPost(long id, String url, String urlWithSlug, PostType type, long date, 
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags){
		
		super(id, url, urlWithSlug, type, date, bookmarklets, mobiles, reblogKey, slug, tags);
		
		
	}

}
