package tumblib;

import java.net.MalformedURLException;
import java.net.URL;

public class TumblrPhoto {
	String photoCaption;
	String offset;
	URL photoUrl1280;
	URL photoUrl500;
	URL photoUrl400;
	URL photoUrl250;
	URL photoUrl100;
	URL photoUrl75;
	
	public TumblrPhoto(String[] photoUrls, String photoCaption){
		setUrls(photoUrls);
		setPhotoCaption(photoCaption);
	}
	
	public String getCaption(){
		return photoCaption;
	}
	
	void setPhotoCaption(String photoCaption) {
		this.photoCaption = photoCaption;	
	}
	
	public URL getPhotoUrl(int resolution){
		switch(resolution){
		case 1280: return this.photoUrl1280;
		case 500: return this.photoUrl500;
		case 400: return this.photoUrl400;
		case 250: return this.photoUrl250;
		case 100: return this.photoUrl100;
		case 75: return this.photoUrl75;
		default: return this.photoUrl500;			
		}
	}
	
	void setUrls(String[] photoUrls){
		try {
			this.photoUrl500 = new URL(photoUrls[0]);
			this.photoUrl400 = new URL(photoUrls[1]);
			this.photoUrl250 = new URL(photoUrls[2]);
			this.photoUrl100 = new URL(photoUrls[3]);
			this.photoUrl75 = new URL(photoUrls[4]);
			try{
				this.photoUrl1280 = new URL(photoUrls[5]);
			}catch (ArrayIndexOutOfBoundsException e){
				this.photoUrl1280 = null;
			}	
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("  Please verify that the URL format is correct.");
		} 
	}

}
