package example.com.ulacitwork.model;

/**
 * Created by Administrator on 12/4/2015.
 */
public class MVCModel {

    private int id;
    private String name;
    private String course;
    private String grade;
    private String rating;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MVCModel mvcModel = (MVCModel) o;

        if (id != mvcModel.id) return false;
        if (!name.equals(mvcModel.name)) return false;
        if (!course.equals(mvcModel.course)) return false;
        if (grade != null ? !grade.equals(mvcModel.grade) : mvcModel.grade != null) return false;
        return !(rating != null ? !rating.equals(mvcModel.rating) : mvcModel.rating != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MVCModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", grade='" + grade + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}