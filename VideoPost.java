package tumblib;

import com.google.gson.JsonObject;

public class VideoPost extends Post {
	private String videoCaption;
	private String videoSource;
	private String videoPlayer;
	
	/**This wacky constructor is meant to be used by the {@link PostDeserializer}.*/
	public VideoPost(long id, String url, String urlWithSlug, PostType type, long date, String format, 
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags,
			String videoSource, String videoCaption, String videoPlayer){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setVideoCaption(videoCaption);
		setVideoSource(videoSource);
		setVideoPlayer(videoPlayer);
		
	}

	/**The content of this post in a format ready for insertion into a javascript/html 
	 * document.**/
	public String getContent(){
		return this.getVideoSource() + "\n" + this.getVideoCaption();
	}
	
	void setVideoCaption(String videoCaption) {
		this.videoCaption = videoCaption;
	}

	public String getVideoCaption() {
		return videoCaption;
	}

	void setVideoSource(String videoSource) {
		this.videoSource = videoSource;
	}

	public String getVideoSource() {
		return videoSource;
	}

	public void setVideoPlayer(String videoPlayer) {
		this.videoPlayer = videoPlayer;
	}

	public String getVideoPlayer() {
		return videoPlayer;
	}
	
	
	/******Static methods for deserializing VideoPosts from JSON.******/
	
	/**@return The javascript source to display the video.**/
	static String sourceFromJson(JsonObject post){
		return post.getAsJsonPrimitive("video-source").getAsString();
	}
	
	/**@return The caption of the video.  Most likely in html format.**/
	static String captionFromJson(JsonObject post){
		return post.getAsJsonPrimitive("video-caption").getAsString();
	}
	
	/**@return javascript source code for an alternative video player.**/
	static String playerFromJson(JsonObject post){
		return post.getAsJsonPrimitive("video-player").getAsString();
	}
	
		
}
