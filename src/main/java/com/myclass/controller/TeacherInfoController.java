package com.myclass.controller;

import com.myclass.entity.DataDictionary;
import com.myclass.entity.TeacherInfo;
import com.myclass.service.DataDictionaryService;
import com.myclass.service.TeacherInfoService;
import com.myclass.tools.PageData;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 教师表(TeacherInfo)(TeacherInfo)表控制层
 *
 * @author 蜀山剑仙
 * @since 2019-07-11 16:59:34
 */
@RestController
@RequestMapping("teacherinfo")
public class TeacherInfoController {

    private Logger logger = Logger.getLogger(TeacherInfoController.class);

    /**
     * 服务对象
     */
    @Resource
    private DataDictionaryService dataDictionaryService;

    /**
     * 服务对象
     */
    @Resource
    private TeacherInfoService teacherInfoService;

    /**
     * 打开登录页面
     *
     * @return 登录页面
     */
    @GetMapping("login.html")
    public ModelAndView login(String backUri, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("backstage/login");
        request.getSession().invalidate();
        request.getSession().setAttribute("backUri", backUri);
        return modelAndView;
    }

    @PostMapping("login.do")
    public ModelAndView login(String loginName, String pwd, HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:index.html");
        TeacherInfo teacherinfo = null;
        try {
            teacherinfo = teacherInfoService.login(loginName, pwd);
            if (teacherinfo == null) {
                modelAndView.setViewName("backstage/login");
                modelAndView.addObject("error", "用户名或密码错误!");
                return modelAndView;
            }
            String backUri = (String) request.getSession().getAttribute("backUri");
            if (backUri != null) {
                modelAndView.setViewName("redirect:" + backUri);
            }
        } catch (Exception e) {
            logger.error("login.do error:", e);
        }
        request.getSession().setAttribute("teacher", teacherinfo);
        return modelAndView;
    }


    @RequestMapping("index.html")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/index");
        return modelAndView;
    }

    @GetMapping("insert.html")
    public ModelAndView insert(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/insert");
        return modelAndView;
    }

    @GetMapping("list.html")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/list");
        return modelAndView;
    }

    @GetMapping("updatePwd.html")
    public ModelAndView updatePwd(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/updatePwd");
        return modelAndView;
    }

    @GetMapping("addDD.html")
    public ModelAndView dataDictionaryInsert(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/addDD");
        return modelAndView;
    }

    @GetMapping("listDD.html")
    public ModelAndView dataDictionaryList(ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/listDD");
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

    @GetMapping("dataDictionaryList.json")
    public PageData<DataDictionary> getDataDictionary(String sort, String order, int offset, int limit) {
        // 每页条数
        int pageSize = limit;
        // 当前页码
        int pageIndex = offset / limit + 1;
        PageData<DataDictionary> dataDictionaryPageData = dataDictionaryService.listDataDictionary(pageIndex, pageSize, sort, order);
        return dataDictionaryPageData;
    }

    @PostMapping("insert.do")
    public ModelAndView insert(TeacherInfo teacherInfo, ModelAndView modelAndView) {
        try {
            modelAndView.setViewName("backstage/super/insert");
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

    @PostMapping("addDD.do")
    public ModelAndView dataDictionaryInsert(DataDictionary dataDictionary, ModelAndView modelAndView) {
        modelAndView.setViewName("backstage/super/addDD");
        boolean insertDataDictionary = dataDictionaryService.insertDataDictionary(dataDictionary);
        if (insertDataDictionary) {
            modelAndView.addObject("msg", "添加成功!");
        } else {
            modelAndView.addObject("msg", "添加失败!");
        }
        return modelAndView;
    }
}