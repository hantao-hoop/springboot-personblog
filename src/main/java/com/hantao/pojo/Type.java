package com.hantao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();


}
