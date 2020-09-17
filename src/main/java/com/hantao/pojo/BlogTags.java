package com.hantao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/17
 * @description:
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogTags implements Serializable {

    @Id
    private Long blogsId;
    @Id
    private Long tagsId;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BlogTags other = (BlogTags) that;
        return (this.getBlogsId() == null ? other.getBlogsId() == null : this.getBlogsId().equals(other.getBlogsId()))
                && (this.getTagsId() == null ? other.getTagsId() == null : this.getTagsId().equals(other.getTagsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlogsId() == null) ? 0 : getBlogsId().hashCode());
        result = prime * result + ((getTagsId() == null) ? 0 : getTagsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogsId=").append(blogsId);
        sb.append(", tagsId=").append(tagsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
