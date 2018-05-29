package com.kefang.autoditacte.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MajorCourse extends BaseEntity{
    private String id;
    private String courseId;
    private String majorId;
}
