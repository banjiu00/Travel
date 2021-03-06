package com.web.controller;

import com.web.entity.Category;
import com.web.service.CategoryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

import java.util.List;


@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list")
    public String findAll(Category category, Model model){
        List<Category> all = categoryService.findAll(category);
        model.addAttribute("all",all);
        return "category/list";
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "category/add";
    }

    @RequestMapping("/doadd")
    public String add(Category category){
        categoryService.add(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/update";
    }

    @RequestMapping("/doupdate")
    public String update(Category category){
        categoryService.update(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/delete")
    public String patchDelete(Integer[] ids){
        for (Integer id:ids) {
            categoryService.delete(id);
        }
        return "redirect:/admin/category/list";
    }

}
