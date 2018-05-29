package com.kefang.autoditacte.dto;


import com.kefang.autoditacte.entity.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class MajorDto extends Major {
    List<String> courseIdList;
    public static MajorDto adapt(Major major){
        MajorDto majorDto=new MajorDto();
        BeanUtils.copyProperties(major,majorDto);
        return majorDto;
    }
}
