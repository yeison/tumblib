package tumblib;

import com.google.gson.JsonObject;

public class AudioPost extends Post {
	private String audioCaption;
	private String audioPlayer;
	private int audioPlays;
	
	public AudioPost(long id, String url, String urlWithSlug, PostType type, long date, String format, 
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags,
			String audioCaption, String audioPlayer, int plays){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setAudioCaption(audioCaption);
		setAudioPlayer(audioPlayer);
		
	}

	void setAudioCaption(String audioCaption) {
		this.audioCaption = audioCaption;
	}

	public String getAudioCaption() {
		return audioCaption;
	}

	void setAudioPlayer(String audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	public String getAudioPlayer() {
		return audioPlayer;
	}
	
	void setAudioPlays(int audioPlays) {
		this.audioPlays = audioPlays;
	}

	public int getAudioPlays() {
		return audioPlays;
	}
	
	/******Static methods for deserializing AudioPosts from JSON.******/
	static String captionFromJson(JsonObject post){
		return post.getAsJsonPrimitive("audio-caption").getAsString();
	}
	
	static String playerFromJson(JsonObject post){
		return post.getAsJsonPrimitive("audio-player").getAsString();
	}
	
	static int playsFromJson(JsonObject post){
		return post.getAsJsonPrimitive("audio-plays").getAsInt();
	}


}
