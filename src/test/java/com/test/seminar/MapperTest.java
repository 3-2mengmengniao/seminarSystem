package com.test.seminar;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.CourseClass;
import com.test.seminar.entity.Round;
import com.test.seminar.mapper.CourseClassMapper;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.mapper.RoundMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    CourseClassMapper courseClassMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    RoundMapper roundMapper;

    @Test
    public void getCourseClassByCourseClassId(){
        CourseClass class1=courseClassMapper.getCourseClassByCourseClassId(new BigInteger("3"));
        assertEquals("软工一班",class1.getIntroduction());
    }

    @Test
    public void insertCourseClass(){
        CourseClass courseClass=new CourseClass();
        courseClass.setCourseId(new BigInteger("1"));
        courseClass.setClassName("三班");
        courseClass.setIntroduction("OOAD三班");
        courseClassMapper.insertCourseClass(courseClass);
        CourseClass class1=courseClassMapper.getCourseClassByCourseClassId(new BigInteger("5"));
        assertEquals("OOAD三班",class1.getIntroduction());
    }

    @Test
    public void updateCourseClassByCourseClassId(){
        CourseClass courseClass=new CourseClass();
        courseClass.setCourseId(new BigInteger("1"));
        courseClass.setClassName("三班");
        courseClass.setIntroduction("OOAD三班修改");
        courseClassMapper.updateCourseClassByCourseClassId(courseClass);
        CourseClass class1=courseClassMapper.getCourseClassByCourseClassId(new BigInteger("5"));
        assertEquals("OOAD三班修改",class1.getIntroduction());
    }

    @Test
    public void deleteCourseClassByCourseClassId(){
        courseClassMapper.deleteCourseClassByCourseClassId(new BigInteger("5"));
        CourseClass class1=courseClassMapper.getCourseClassByCourseClassId(new BigInteger("5"));
        assertEquals(null,class1);
    }

    @Test
    public void getCourseClassByCourseId(){
        List<CourseClass> courseClasses= courseClassMapper.getCourseClassByCourseId(new BigInteger("1"));
        System.out.println(courseClasses.get(0).getIntroduction());
        System.out.println(courseClasses.get(1).getIntroduction());
        assertEquals(2,courseClasses.size());
    }

    @Test
    public void getCourseByStudentId(){
        List<Course> courses= courseMapper.getCourseByStudentId(new BigInteger("1"));
        System.out.println(courses.get(0).getCourseName());
        System.out.println(courses.get(1).getCourseName());
        assertEquals(2,courses.size());
    }

    @Test
    public void insertCourse(){
       Course course=new Course();
       course.setTeacherId(new BigInteger("1"));
       course.setCourseName("J2EE");
       course.setMaxTeamMember(5);
       course.setMinTeamMember(3);
       course.setPresentationProportion(50);
       course.setQuestionProportion(20);
       course.setReportProportion(30);
       course.setTeamEndTime(new Date());
       course.setTeamStartTime(new Date());
       courseMapper.insertCourse(course);
    }

    @Test
    public void getCourseByCourseId(){
        Course course=courseMapper.getCourseByCourseId(new BigInteger("6"));
        System.out.println(course.getIntroduction());
    }

    @Test
    public void getRoundByCourseId(){
        List<Round> rounds =roundMapper.getRoundByCourseId(new BigInteger("1"));
        assertEquals(2,rounds.size());
    }

    @Test
    public void getCourseClassByStudentIdAndCourseId(){
        List<CourseClass> class1 =courseClassMapper.getCourseClassByStudentIdAndCourseId(new BigInteger("2"),new BigInteger("1"));
        System.out.println(class1.get(0).getIntroduction());
        assertEquals(1,class1.size());
    }
}
