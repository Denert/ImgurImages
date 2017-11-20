package com.example.varia.imgurimages.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CommentsDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("author_id")
    @Expose
    private Integer authorId;
    @SerializedName("on_album")
    @Expose
    private Boolean onAlbum;
    @SerializedName("album_cover")
    @Expose
    private String albumCover;
    @SerializedName("ups")
    @Expose
    private Integer ups;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("datetime")
    @Expose
    private Integer datetime;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("deleted")
    @Expose
    private Boolean deleted;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("children")
    @Expose
    private List<CommentsDatum> children = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Boolean getOnAlbum() {
        return onAlbum;
    }

    public void setOnAlbum(Boolean onAlbum) {
        this.onAlbum = onAlbum;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Object getVote() {
        return vote;
    }

    public void setVote(Object vote) {
        this.vote = vote;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<CommentsDatum> getChildren() {
        return children;
    }

    public void setChildren(List<CommentsDatum> children) {
        this.children = children;
    }

}
