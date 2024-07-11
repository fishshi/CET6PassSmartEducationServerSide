package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 六级试题的下载数据
 */
@AllArgsConstructor
@Data
public class Download {
    private String fileName;
    private String fileUrl;
    private String coverUrl;
}
