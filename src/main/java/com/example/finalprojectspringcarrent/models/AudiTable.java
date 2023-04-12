package com.example.finalprojectspringcarrent.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Tiina Raudla
 * @Date
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AudiTable<V> {
    @CreatedBy
    @JsonIgnore
    @Column(updatable = false)
    protected V createBy;
    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    protected LocalDateTime createdDate;
    @CreatedBy
    @JsonIgnore
    protected V lastModifiedBy;
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    protected LocalDateTime lastModifiedDate;
}
