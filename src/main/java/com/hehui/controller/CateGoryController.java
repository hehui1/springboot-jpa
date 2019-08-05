package com.hehui.controller;

import com.hehui.dao.CateGoryDao;
import com.hehui.model.CateGory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by he_hui on 2019/8/2.
 */
@Controller
public class CateGoryController {
    @Autowired
    private CateGoryDao cateGoryDao;
    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/categorylist")
    public ModelAndView categorylist(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                     @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "categoryid");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<CateGory> page = cateGoryDao.findAll(pageable);

//        System.out.println(page.getNumber());
//        System.out.println(page.getNumberOfElements());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotalElements());
//        System.out.println(page.getTotalPages());
//        System.out.println(page.isFirst());
//        System.out.println(page.isLast());

        ModelAndView mav = new ModelAndView("categorylist");
        mav.addObject("page", page);
        return mav;
    }

    /**
     64      * 类别新增视图
     65      * @return
     66      */
      @RequestMapping("/categoryadd")
         public String categoryinit() {
                 return "categoryadd";
             }
    //添加单个
    @RequestMapping("/categoryinsert")
    public String categoryinsert(CateGory model){
        cateGoryDao.save(model);
        return "redirect:categorylist";
    }
    //删除
    @RequestMapping("/categorydele")
    public String categorydele(CateGory model){
        cateGoryDao.delete(model);
        return "redirect:categorylist";
    }

    //编辑
    @RequestMapping("/categoryedit")
    public ModelAndView categoryedit(Integer categoryid){
        ModelAndView mav = new ModelAndView();
        CateGory cateGory = cateGoryDao.getOne(categoryid);
        mav.addObject("category", cateGory);
        return mav;
    }
    @RequestMapping("/categoryupdate")
    public String categoryupdate(CateGory model){
        CateGory cateGory  = cateGoryDao.save(model);
        return "redirect:categorylist";
    }


}
