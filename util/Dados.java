package util;


import java.io.Serializable;

public class Dados implements Serializable{

  private static final long serialVersionUID = 1L;
  private String app;
	private String category;
	private String rating;
	private String reviews;
	private String size;
	private String installs;
	private String type;
  private String price;
	private String content_rating;
	private String genres;
	private String last_update;
	private String current_ver;
	private String android_ver;

  public Dados(){

  }
  
  public Dados(String app, String category, String rating, String reviews, String size, String installs, String type,
      String price, String content_rating, String genres, String last_update, String current_ver, String android_ver) {
    super();
    this.app = app;
    this.category = category;
    this.rating = rating;
    this.reviews = reviews;
    this.size = size;
    this.installs = installs;
    this.type = type;
    this.price = price;
    this.content_rating = content_rating;
    this.genres = genres;
    this.last_update = last_update;
    this.current_ver = current_ver;
    this.android_ver = android_ver;
  }
  public String getApp() {
    return app;
  }
  public void setApp(String app) {
    this.app = app;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getRating() {
    return rating;
  }
  public void setRating(String rating) {
    this.rating = rating;
  }
  public String getReviews() {
    return reviews;
  }
  public void setReviews(String reviews) {
    this.reviews = reviews;
  }
  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }
  public String getInstalls() {
    return installs;
  }
  public void setInstalls(String installs) {
    this.installs = installs;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }
  public String getContent_rating() {
    return content_rating;
  }
  public void setContent_rating(String content_rating) {
    this.content_rating = content_rating;
  }
  public String getGenres() {
    return genres;
  }
  public void setGenres(String genres) {
    this.genres = genres;
  }
  public String getLast_update() {
    return last_update;
  }
  public void setLast_update(String last_update) {
    this.last_update = last_update;
  }
  public String getCurrent_ver() {
    return current_ver;
  }
  public void setCurrent_ver(String current_ver) {
    this.current_ver = current_ver;
  }
  public String getAndroid_ver() {
    return android_ver;
  }
  public void setAndroid_ver(String android_ver) {
    this.android_ver = android_ver;
  }
  @Override
  public String toString() {
    String saida = String.format("%s,%s,", app,category)
    +String.format("%s,%s,", rating,reviews)
    +String.format("%s,%s,", size,installs)
    +String.format("%s,%s,", type,price)
    +String.format("%s,%s,", content_rating,genres)
    +String.format("%s,%s,", last_update,current_ver)
    +String.format("%s", android_ver);
    return saida;
  }  
}

