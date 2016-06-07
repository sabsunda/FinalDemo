package com.mydomain.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;


@Entity("posts")
@Indexes(
    @Index(value = "title", fields = @Field("title"))
)
public class Post {
	@Id
    private ObjectId id;
    private String title;
    private String description;
    private List<ImageInfo> imageInfos;
    private String by;
    private Date date_created;
    private String category;
    private List<String> tags;
    private Integer likes;
    private List<Comment> comments;
    
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<ImageInfo> getImageInfos() {
		return imageInfos;
	}
	public void setImageInfos(List<ImageInfo> imageInfos) {
		this.imageInfos = imageInfos;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", imageInfos=" + imageInfos
				+ ", by=" + by + ", date_created=" + date_created + ", category=" + category + ", tags=" + tags
				+ ", likes=" + likes + ", comments=" + comments + "]";
	}
    
}
