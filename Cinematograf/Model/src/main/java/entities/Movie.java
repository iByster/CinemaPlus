package entities;

import javax.persistence.Column;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name = "Movies")
public class Movie extends Entity {
    @Column(name = "title", unique = true, nullable = false)
    private String title;
//    @Temporal(TemporalType.TIME)
    @Column(name = "duration", nullable = false, columnDefinition = "varchar(8)")
    private String duration;
    @Column(name = "rating", nullable = false)
    private Integer rating;
    @Column(name = "description")
    private String description;
    @Column(name = "movieType")
    private String movieType;
    @Column(name = "image")
    private String image;

    public Movie(){}

    public Movie(Long id){
        this.setId(id);
    }

    public Movie(String id){
        this.setId(Long.parseLong(id));
    }

    public Movie(String title, String duration, Integer rating, String description, String movieType,String image) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.movieType = movieType;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", movieType='" + movieType + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
