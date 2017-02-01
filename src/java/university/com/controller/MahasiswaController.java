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
import university.com.model.Mahasiswa;
import university.com.service.IMahasiswaSrvc;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iman
 */
@Controller
public class MahasiswaController {

    @Autowired
    IMahasiswaSrvc mahasiswaService;

    @RequestMapping(value = "/InputMahasiswa.do", method = RequestMethod.GET)
    public ModelAndView showInput() {
        return new ModelAndView("InputMahasiswa", "mahasiswa", new Mahasiswa());
    }

    @RequestMapping(value = "/addMahasiswa.do", method = RequestMethod.POST)
    public String submit(@ModelAttribute("") Mahasiswa mahasiswa, BindingResult result,
            ModelMap map) {
        if (result.hasErrors()) {
            return "/InputMahasiswa.do";
        }

        mahasiswaService.Save(mahasiswa);

        return "redirect:/tampilMahasiswa.do";
    }

    @RequestMapping(value = "/deleteMahasiswa.do", method = RequestMethod.GET)
    public String deleteMahasiswa(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("mhs_id"));
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(id);
        mahasiswaService.Delete(mahasiswa);
            System.out.print("Sucess Running");        
   
        return "redirect:/tampilMahasiswa.do";
    }

    @RequestMapping(value = "/tampilMahasiswa.do")
    public ModelAndView tampilMahasiswa(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/Home");

        List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswas();
        modelAndView.addObject("mahasiswalist", mahasiswaList);

        return modelAndView;
    }
    @RequestMapping(value = "/searchMahasiswa.do", method = RequestMethod.GET)
    public ModelAndView searchMahasiswa(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/Home");
        String nama = request.getParameter("mhs_nama");

        List<Mahasiswa> mahasiswaList = mahasiswaService.getSearch(nama);
        modelAndView.addObject("mahasiswalist", mahasiswaList);

        return modelAndView;
    }
    @RequestMapping(value = "/viewUpdate.do", method = RequestMethod.GET)
    public ModelAndView updateMahasiswa(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/UpdateMahasiswa");
        Long id = Long.parseLong(request.getParameter("mhs_id"));
        Mahasiswa mhs = new Mahasiswa();
        try {
            System.out.print("Sucess Running");
            mhs = mahasiswaService.getSingleMahasiswa(id);
        } catch (Exception e) {
            System.out.print("Not Running");
        }
        modelAndView.addObject(mhs);
        System.out.print("Sucess Running");
        return modelAndView;
    }

}
