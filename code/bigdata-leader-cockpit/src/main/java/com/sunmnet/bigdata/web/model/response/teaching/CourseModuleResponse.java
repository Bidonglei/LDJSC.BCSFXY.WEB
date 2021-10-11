package com.sunmnet.bigdata.web.model.response.teaching;

import java.util.ArrayList;
import java.util.List;

/**  
* @ClassName: CourseModuleResponse  
* @Description: 课程模块封装对象
* @author lenovo  
* @date 2018年9月2日    
*/
public class CourseModuleResponse
{
    // 课程分类
    private String courseType;
    
    // 详细课程
    private List<String> courseDetail = new ArrayList<String>();
    
    public CourseModuleResponse(String courseType)
    {
        super();
        this.courseType = courseType;
    }
    
    public String getCourseType()
    {
        return courseType;
    }
    
    public void setCourseType(String courseType)
    {
        this.courseType = courseType;
    }
    
    public List<String> getCourseDetail()
    {
        return courseDetail;
    }
    
    public void setCourseDetail(List<String> courseDetail)
    {
        this.courseDetail = courseDetail;
    }
    
    public void addCourseDetail(String course)
    {
        this.courseDetail.add(course);
    }
    
}
