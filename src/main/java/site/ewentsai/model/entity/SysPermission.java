package site.ewentsai.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "permission")
public class SysPermission implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "pid") }, inverseJoinColumns = {
            @JoinColumn(name = "rid") })
    private List<SysRole> roles;
}
