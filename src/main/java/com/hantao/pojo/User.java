package com.hantao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/25
 * @description:
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String username;
    private String password;

    private String email;
    private String avatar;
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_time;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

}
