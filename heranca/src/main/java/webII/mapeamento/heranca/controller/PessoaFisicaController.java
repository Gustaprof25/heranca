/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webII.mapeamento.heranca.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webII.mapeamento.heranca.entity.PessoaFisica;
import webII.mapeamento.heranca.repository.PessoaFisicaRepository;

/**
 *
 * @author CHFS
 */
@Transactional
@Controller
@RequestMapping("pessoafisica")
public class PessoaFisicaController {
    
    
    @Autowired
    PessoaFisicaRepository repository;
     
   
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("pessoafisica", repository.pessoaFisica());
        //return new 
        return new ModelAndView("/pessoafisica/list", model);
    }
        
    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica){
        return "/pessoafisica/form";
    }
    
    @PostMapping("/save")
    public ModelAndView save(PessoaFisica pessoaFisica){
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoafisica/list");
    }
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoafisica/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("pessoaFisica", repository.pessoaFisica(id));
        return new ModelAndView("/pessoafisica/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoafisica/list");
    }
    
}
