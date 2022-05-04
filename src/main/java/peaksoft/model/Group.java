package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private int dateOfStart;
    private int dateOfFinish;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "course_group",
                joinColumns = @JoinColumn(name="course_id"),
                inverseJoinColumns = @JoinColumn(name="group_id"))
    private List<Course> course;

    @OneToMany(mappedBy = "group")
    private List<Student> students;


    public Group(String groupName, int dateOfStart, int dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }



}
