package com.boram.life.aprvlDocuments.controller;

import com.boram.life.aprvlDocuments.dto.DraftDTO;
import com.boram.life.aprvlDocuments.service.AprvlDocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Controller
public class AprvlDocsController {

    private final AprvlDocsService draftService;

    @Autowired
    public AprvlDocsController(AprvlDocsService draftService) {
        this.draftService = draftService;
    }

    @GetMapping("/draft")
    public String getAllDrafts(Model model, @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size) {
        System.out.println("model ========================== " + model);
        Pageable pageable = PageRequest.of(page, size);
        List<DraftDTO> drafts = draftService.findAllByDraftStatus(pageable);
        System.out.println("drafts =>>>>>>>>>>>>>>>>>>> " + drafts);
        model.addAttribute("drafts", drafts);
        return "draft";
    }


}

