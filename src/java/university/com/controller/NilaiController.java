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
import university.com.model.Nilai;
import university.com.service.INilaiSrvc;

/**
 *
 * @author iman
 */
@Controller
public class NilaiController {

    @Autowired
    INilaiSrvc iNilaiSrvc;

    @RequestMapping(value = "/tampilNilai.do")
    public ModelAndView tampilNilai(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/HomeNilai");

        List<Nilai> nilais = iNilaiSrvc.getAllNilai();
        mav.addObject("nilailist", nilais);
        return mav;
    }

    @RequestMapping(value = "/InputNilai.do", method = RequestMethod.GET)
    public ModelAndView showInputNilai() {
        return new ModelAndView("InputNilai", "nilai", new Nilai());
    }

    @RequestMapping(value = "/addNilai.do", method = RequestMethod.POST)
    public String submitNilai(@ModelAttribute() Nilai nilai, BindingResult result,
            ModelMap map) {
        if (result.hasErrors()) {
            return "/inputNilai.do";
        }
        iNilaiSrvc.save(nilai);
        return "redirect:/tampilNilai.do";
    }

    @RequestMapping(value = "/deleteNilai.do", method = RequestMethod.GET)
    public String deleteNilai(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("n_id"));
        Nilai n = new Nilai();

        n.setId_nilai(id);
        iNilaiSrvc.delete(n);

        return "redirect:/tampilNilai.do";
    }

    @RequestMapping(value = "/updateNilai.do", method = RequestMethod.GET)
    public ModelAndView updateNilai(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/UpdateNilai");
        Long id = Long.parseLong(request.getParameter("n_id"));
        Nilai n = new Nilai();
        try {
            System.out.print("Sucess Running");
            n = iNilaiSrvc.getSingleNilai(id);
        } catch (Exception e) {
            System.out.print("Not Running");
        }
        modelAndView.addObject("nilai", n);
        System.out.print("Sucess Running");
        return modelAndView;
    }
}
