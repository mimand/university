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
import university.com.model.Dosen;
import university.com.service.IDosenSrvc;

/**
 *
 * @author iman
 */
@Controller
public class DosenController {

    @Autowired
    IDosenSrvc dosenSrvc;

    @RequestMapping(value = "/tampilDosen.do")
    public ModelAndView tampilDosen(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        ModelAndView modelAndView = new ModelAndView("/HomeDosen");
        List<Dosen> list = dosenSrvc.getAllDosens();

        modelAndView.addObject("dosenlist",list);

        return modelAndView;
    }

    @RequestMapping(value = "/inputDosen.do", method = RequestMethod.GET)
    public ModelAndView showInputDosen() {
        return new ModelAndView("InputDosen", "dosen", new Dosen());
    }

    @RequestMapping(value = "/addDosen.do", method = RequestMethod.POST)
    public String submitDosen(@ModelAttribute("") Dosen dosen, BindingResult bindingResult,
            ModelMap map) {
        if (bindingResult.hasErrors()) {
            return "/inputDosen.do";
        }
        dosenSrvc.Save(dosen);
        return "redirect:/tampilDosen.do";

    }

    @RequestMapping(value = "/deleteDosen.do", method = RequestMethod.GET)
    public String deleteDosen(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("ds_id"));
        Dosen ds = new Dosen();
        ds.setNip(id);
        dosenSrvc.Delete(ds);
        return "redirect:/tampilDosen.do";
    }

    @RequestMapping(value = "/updateDosen.do", method = RequestMethod.GET)
    public ModelAndView updateMataKuliah(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/UpdateDosen");
        Long id = Long.parseLong(request.getParameter("ds_id"));
        Dosen ds = new Dosen();
        try {
            System.out.print("Sucess Running");
            ds = dosenSrvc.getSingleDosen(id);
        } catch (Exception e) {
            System.out.print("Not Running");
        }
        modelAndView.addObject("dosen", ds);
        System.out.print("Sucess Running");
        return modelAndView;
    }
    @RequestMapping(value ="/searchDosen.do",method =RequestMethod.GET)
    public ModelAndView searchDosen(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/HomeDosen");
        
        String dosen = request.getParameter("ds_nama");
        
        List<Dosen> list = dosenSrvc.getSearch(dosen);
        mav.addObject("dosenlist",list);
        
        return  mav;
    }
}
