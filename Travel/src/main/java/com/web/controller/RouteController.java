package com.web.controller;

import com.github.pagehelper.PageInfo;
import com.web.entity.Category;
import com.web.entity.Route;
import com.web.entity.RouteImg;
import com.web.entity.Seller;
import com.web.service.CategoryService;
import com.web.service.RouteImgService;
import com.web.service.RouteService;
import com.web.service.SellerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/route")
public class RouteController {
    @Resource
    private RouteService routeService;
    @Resource
    private SellerService sellerService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private RouteImgService imgService;

    @RequestMapping("/page")
    public String findPage(Route route,
                           @RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int pageSize,
                           Model model){
        PageInfo<Route> page = routeService.findPage(route, pageNum, pageSize);
        model.addAttribute("page",page);

        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers",sellers);

        List<Category> categories = categoryService.find(new Category());
        model.addAttribute("company",categories);

        model.addAttribute("route",route);

        return "/route/list";
    }

    @RequestMapping("/toadd")
    public String toAdd(Model model){
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers",sellers);

        List<Category> categories = categoryService.find(new Category());
        model.addAttribute("categories",categories);

        return "/route/add";
    }

    @RequestMapping("/doadd")
    public String add(Route route,
                      @RequestParam("rimageFile") MultipartFile multipartFile,
                      HttpServletRequest request) throws IOException {
        performRImage(route, multipartFile, request);
        routeService.add(route);
        return "redirect:/admin/route/page";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Integer id, Model model){
        Route route = routeService.findById(id);
        model.addAttribute("route",route);

        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers",sellers);

        List<Category> categories = categoryService.find(new Category());
        model.addAttribute("categories",categories);
        return "/route/update";
    }

    @RequestMapping("/update")
    public String update(Route route,
                         @RequestParam("rimageFile") MultipartFile rimageFile,
                         HttpServletRequest request) throws IOException{
        performRImage(route,rimageFile,request);
        routeService.update(route);
        return "redirect:/admin/route/page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        routeService.delete(id);
        return "redirect:/admin/route/page";
    }

    @RequestMapping("/delete")
    public String batchDelete(@PathVariable("ids") Integer[] ids){
        for (Integer i:ids){
            routeService.delete(i);
        }
        return "redirect:/admin/route/page";
    }

    /**
     * 根据id加载线路图片，跳到image.html
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toimage/{id}")
    public String toImage(@PathVariable("id") Integer id, Model model) {
        Route route = routeService.findById(id);
        model.addAttribute("route", route);
        return "route/image";
    }

    @RequestMapping("/doimage")
    public String doImage(
            Integer rid,
            @RequestParam("bigPicFile") MultipartFile[] bigPicFile,
            @RequestParam("smallPicFile") MultipartFile[] smallPicFile,
            HttpServletRequest request) throws Exception {

        List<String> bigPic = new ArrayList<>();
        List<String> smallPic = new ArrayList<>();
        //String path = request.getServletContext().getRealPath("/");
        String savePath="F:\\X\\IDEA_workspace\\Travel\\src\\main\\resources\\static\\img\\product\\rimage";
        for (MultipartFile f : bigPicFile) {
            File bigPath = new File(savePath);
            if (!bigPath.exists()) {
                bigPath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replace("-", "") + "." +
                    FilenameUtils.getExtension(f.getOriginalFilename());
            f.transferTo(new File(bigPath, fileName));
            bigPic.add("img/product/rimage/" + fileName);
        }
        for (MultipartFile f : smallPicFile) {
            File smallPath = new File(savePath);
            if (!smallPath.exists()) {
                smallPath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replace("-", "") + "." +
                    FilenameUtils.getExtension(f.getOriginalFilename());
            f.transferTo(new File(smallPath, fileName));
            smallPic.add("img/product/rimage/" + fileName);
        }
        //要添加的图片列表
        List<RouteImg> ris = new ArrayList<>();
        for (int i = 0; i < bigPic.size(); i++) {
            RouteImg img = new RouteImg();
            img.setRid(rid);
            img.setBigPic(bigPic.get(i));
            img.setSmallPic(smallPic.get(i));
            ris.add(img);
        }
        imgService.saveImg(rid, ris);
        return "redirect:/admin/route/page";
    }
    private void performRImage(Route route, @RequestParam("rimageFile") MultipartFile rimageFile,
                               HttpServletRequest request) throws IOException {
        //项目的部署目录 + img/product/rimage/
        //String savePath = request.getServletContext().getRealPath("img/product/rimage/");
        String savePath="F:\\X\\IDEA_workspace\\Travel\\src\\main\\resources\\static\\img\\product\\rimage";

        //处理随机文件名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." +
                FilenameUtils.getExtension(rimageFile.getOriginalFilename());
        //上传目录如果不存在,先创建
        File savePathDir = new File(savePath);

        if (!savePathDir.exists()) {
            savePathDir.mkdirs();
        }
        //保存文件
        rimageFile.transferTo(new File(savePathDir, fileName));
        //设置线路的rimage属性=文件的相对路径
        route.setRimage("img/product/rimage/" + fileName);
    }
}
