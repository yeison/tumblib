package tumblib;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
/**
 * A Post object that also contains the URL of a main photo, or an array of
 * photos.
 */
public class PhotoPost extends Post {
	TumblrPhoto mainPhoto;
	TumblrPhoto[] photoArray;

	public PhotoPost(long id, String url, String urlWithSlug, PostType type, long date, String format,
			int bookmarklets, int mobiles, String reblogKey, String slug, String[] tags, 
			String photoCaption, String[] photoUrls, TumblrPhoto[] photoArray){

		super(id, url, urlWithSlug, type, date, format, bookmarklets, mobiles, reblogKey, slug, tags);
		mainPhoto = new TumblrPhoto(photoUrls, photoCaption);
	}

	/**
	 * Retrieves the url of the main photo, as well as its caption.
	 */
	public String getContent(){
		return content + "\n" + getPhotoUrl(1280) + "\n" + getCaption();
	}

	/**
	 * Retrieves the caption of the main photo.
	 */
	public String getCaption(){
		return mainPhoto.getCaption();
	}

	/**
	 * Sets the caption of the main photo.
	 * @param photoCaption The caption as a String.
	 */
	void setPhotoCaption(String photoCaption) {
		mainPhoto.setPhotoCaption(photoCaption);	
	}

	/**
	 * Retrieves the url of the main photo.
	 * @param resolution The resolutition of the photo-url to be retrieved.
	 * @return
	 */
	URL getPhotoUrl(int resolution){
		return mainPhoto.getPhotoUrl(resolution);
	}

	/**
	 * Sets the various urls corresponding to the different photo resolutions.
	 * @param photoUrls A string array of the different photo resolutions.
	 */
	void setUrls(String[] photoUrls){
		mainPhoto.setUrls(photoUrls);
	}

	/******Static methods to be used in deserializing PhotoPosts from JSON.******/
	static String[] urlsFromJson(JsonObject post){
		ArrayList<String> urlList = new ArrayList<String>();
			urlList.add(post.getAsJsonPrimitive("photo-url-500").getAsString());
			urlList.add(post.getAsJsonPrimitive("photo-url-400").getAsString());
			urlList.add(post.getAsJsonPrimitive("photo-url-250").getAsString());
			urlList.add(post.getAsJsonPrimitive("photo-url-100").getAsString());
			urlList.add(post.getAsJsonPrimitive("photo-url-75").getAsString());
		try{
			urlList.add(post.getAsJsonPrimitive("photo-url-1280").getAsString());	
		}catch(NullPointerException e){
			//System.err.println("  The 1280 resolution does not exist for photo.");
		}
		
		String[] urls = {};
		urls = urlList.toArray(urls);
		return urls;

	}

	/**
	 * Parses the Json of a tumblr photo post to extract its caption.
	 * @param post The tumblr post in its Json-Object form.
	 * @return The string corresponding to this photo caption.
	 */
	static String captionFromJson(JsonObject post){
		return post.getAsJsonPrimitive("photo-caption").getAsString();
	}

	/**
	 * Parses the Json of a tumblr photo post to extract the urls of its photos.
	 * @param post The tumblr post in its Json-Object form.
	 * @return An array of TumblrPhoto objects with captions and urls.
	 */
	static TumblrPhoto[] photosFromJson(JsonObject post){
		Iterator<JsonElement> photoIterator = null;
		if(post.getAsJsonArray("photos").size() > 0)
			photoIterator = post.getAsJsonArray("photos").iterator();
		else
			return null;
		
		ArrayList<TumblrPhoto> photos = new ArrayList<TumblrPhoto>();
		while(photoIterator.hasNext()){
			JsonObject jsonPhotoObject;
			jsonPhotoObject =  photoIterator.next().getAsJsonObject();
			String caption = jsonPhotoObject.getAsJsonPrimitive("caption").getAsString();
			String[] urls = urlsFromJson(jsonPhotoObject);
			photos.add(new TumblrPhoto(urls, caption));
		}
		
		TumblrPhoto[] photoArray = {};
		photoArray = photos.toArray(photoArray);
		return photoArray;

	}

}
