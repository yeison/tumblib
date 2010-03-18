package tumblib;

public class VideoPost extends Post {
	private String videoCaption;
	private String videoSource;
	private String videoPlayer;
	
	VideoPost(long id, String url, String urlWithSlug, PostType type, long date, 
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags){
		
		super(id, url, urlWithSlug, type, date, bookmarklets, mobiles, reblogKey, slug, tags);
		
		
	}
		
}
