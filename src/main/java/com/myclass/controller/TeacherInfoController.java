package com.myclass.controller;

import com.myclass.entity.TeacherInfo;
import com.myclass.service.TeacherInfoService;
import com.myclass.tools.PageData;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 教师表(TeacherInfo)(TeacherInfo)表控制层
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:34
 */
@RestController
@RequestMapping("backstage/teacherInfo")
public class TeacherInfoController {

    private Logger logger = Logger.getLogger(TeacherInfoController.class);

    /**
     * 服务对象
     */
    @Resource
    private TeacherInfoService teacherInfoService;

    @GetMapping("insert.html")
    public ModelAndView insert(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/insertTeacherInfo");
        return modelAndView;
    }

    @GetMapping("list.html")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/listTeacherInfo");
        return modelAndView;
    }

    @GetMapping("updatePwd.html")
    public ModelAndView updatePwd(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/updatePwd");
        return modelAndView;
    }

    @GetMapping("teacherList.json")
    public PageData<TeacherInfo> getTeachers(String sort, String order, int offset, int limit) {
        // 每页条数
        int pageSize = limit;
        // 当前页码
        int pageIndex = offset / limit + 1;
        PageData<TeacherInfo> teachers = teacherInfoService.getTeachers(pageIndex, pageSize, sort, order);
        return teachers;
    }

    @PostMapping("insert.do")
    public ModelAndView insert(TeacherInfo teacherInfo, ModelAndView modelAndView) {
        try {
            modelAndView.setViewName("backstage/super/insertTeacherInfo");
            teacherInfoService.insertTeacherInfo(teacherInfo);
            modelAndView.addObject("msg", "新增成功");
        } catch (Exception e) {
            modelAndView.addObject("msg", e);
            logger.error("insert.do error:", e);
        }
        return modelAndView;
    }

    @GetMapping("deleteTeacherInfo.do")
    public String deleteTeacherInfo(Integer id) {
        String msg = "";
        try {
            msg = (teacherInfoService.deleteTeacherInfoById(id)) ? "删除成功" : "删除失败";
        } catch (Exception e) {
            logger.error("deleteTeacherInfo error:", e);
        }
        return msg;
    }

    @PostMapping("updatePwd.do")
    public ModelAndView updatePwd(Integer id, String newPwd, String oldPwd) {
        ModelAndView modelAndView = new ModelAndView("backstage/updatePwd");
        try {
            if (teacherInfoService.updateTeacherInfoPwdById(id, oldPwd, newPwd)) {
                modelAndView.addObject("msg", "修改成功");
            } else {
                modelAndView.addObject("msg", "修改失败");
            }
        } catch (Exception e) {
            logger.error("updatePwd.do error", e);
        }
        return modelAndView;

    }

}