/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import university.com.model.Matakuliah;
import university.com.service.IMataKuliahSrvc;

/**
 *
 * @author iman
 */
@Controller
public class MataKuliahController {

    @Autowired
    IMataKuliahSrvc mataKuliahSrvc;

    @RequestMapping(value = "/tampilMataKuliah.do")
    public ModelAndView tampilMataKuliah(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/HomeMataKuliah");

        List<Matakuliah> mataKuliahs = mataKuliahSrvc.getAllMataKuliah();
        mav.addObject("matakuliahlist", mataKuliahs);
        return mav;
    }

    @RequestMapping(value = "/InputMataKuliah.do", method = RequestMethod.GET)
    public ModelAndView showInputMataKuliah() {
        return new ModelAndView("InputMataKuliah", "matakuliah", new Matakuliah());
    }

    @RequestMapping(value = "/addMataKuliah.do", method = RequestMethod.POST)
    public String submitMataKuliah(@ModelAttribute("") Matakuliah mataKuliah, BindingResult result,
            ModelMap map) {
        if (result.hasErrors()) {
            return "/inputMataKuliah.do";
        }
        mataKuliahSrvc.save(mataKuliah);
        return "redirect:/tampilMataKuliah.do";
    }

    @RequestMapping(value = "/deleteMataKuliah.do", method = RequestMethod.GET)
    public String deleteMataKuliah(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("mk_id"));
        Matakuliah mk = new Matakuliah();
        mk.setKode(id);
        mataKuliahSrvc.delete(mk);

        return "redirect:/tampilMataKuliah.do";
    }

    @RequestMapping(value = "/updateMataKuliah.do", method = RequestMethod.GET)
    public ModelAndView updateMataKuliah(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/UpdateMataKuliah");
        Long id = Long.parseLong(request.getParameter("mk_id"));
        Matakuliah mk = new Matakuliah();
        try {
            System.out.print("Sucess Running");
            mk = mataKuliahSrvc.getSingleMataKuliah(id);
        } catch (Exception e) {
            System.out.print("Not Running");
        }
        modelAndView.addObject("matakuliah", mk);
        System.out.print("Sucess Running");
        return modelAndView;
    }
    @RequestMapping(value = "/searchMataKuliah.do", method = RequestMethod.GET)
    public ModelAndView searchMataKuliah(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/HomeMataKuliah");
        String mk = request.getParameter("mk_nama");
        
        List<Matakuliah> list = mataKuliahSrvc.getSearch(mk);
        mav.addObject("matakuliahlist", list);
        
        return mav;
    }
}
