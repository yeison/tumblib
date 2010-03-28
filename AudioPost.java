package tumblib;

import com.google.gson.JsonObject;

/**
 * The tumblr audio-post contains an audio player and a caption, and corresponds
 * to the AudioPost class.
 * @author Yeison Rodriguez
 */
public class AudioPost extends Post {
	private String audioCaption;
	private String audioPlayer;
	private int audioPlays;
	
	/**This wacky constructor is meant to be used by the {@link PostDeserializer}.*/
	public AudioPost(long id, String url, String urlWithSlug, PostType type, long date, String format, 
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags,
			String audioCaption, String audioPlayer, int plays){
		
		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		setAudioCaption(audioCaption);
		setAudioPlayer(audioPlayer);
		
	}
	
	/**
	 * Grabs the audio player and the caption of this audio post, and returns
	 * it them as a String.
	 */
	public String getContent(){
		return getAudioPlayer() + "\n" + getAudioCaption();
	}

	/**
	 * Sets the caption of this audio-post.
	 * @param audioCaption The caption to be set as a String.
	 */
	void setAudioCaption(String audioCaption) {
		this.audioCaption = audioCaption;
	}

	/**
	 * Gets the caption of this audio-post.
	 * @return The caption of the audio post as a String.
	 */
	public String getAudioCaption() {
		return audioCaption;
	}

	/**
	 * Sets the javascript code that defines the audioplayer.  This includes
	 * the location of the audio file as well.
	 * @param audioPlayer A javascript string that defines the audioplayer
	 * and the audio source.
	 */
	void setAudioPlayer(String audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	/**
	 * Gets the javascript of the audio player and its audio file source
	 * @return The javascript source code of the audioplayer.
	 */
	public String getAudioPlayer() {
		return audioPlayer;
	}
	
	/**
	 * Sets the number of times this audio player has be played.
	 */
	void setAudioPlays(int audioPlays) {
		this.audioPlays = audioPlays;
	}

	/**
	 * Gets the number of times this audio player has been played.
	 */
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
