/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import university.com.model.Mahasiswa;
import university.com.service.IMahasiswaSrvc;
import org.springframework.web.servlet.ModelAndView;
import university.com.utility.FileUpload;

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
            @RequestParam("file") MultipartFile fileUpload) throws Exception {
        if (result.hasErrors()) {
            return "/inputMahasiswa";
        }
        FileUpload fu = new FileUpload();
        fu.process(fileUpload);
        mahasiswa.setImg(fu.getImage());
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

    @RequestMapping(value = {"/tampilMahasiswa.do"})
    public ModelAndView tampilMahasiswa(Integer offset, Integer maxResults) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("/Home");

        List<Mahasiswa> mahasiswaList = mahasiswaService.getAllMahasiswas(offset, 7);

        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getImg() != null) {
                
                byte[] encodeBase64 =Base64.encodeBase64(mahasiswa.getImg());
                String encode = new String(encodeBase64);

                 mahasiswa.setByte64Encode(encode);
                
            }
        }
        modelAndView.addObject("count", mahasiswaService.count());
        modelAndView.addObject("offset", offset);
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
     }

}
